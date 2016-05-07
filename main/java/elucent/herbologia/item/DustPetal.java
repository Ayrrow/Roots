package elucent.herbologia.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mojang.realmsclient.gui.ChatFormatting;

import elucent.herbologia.Herbologia;
import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.ComponentManager;
import elucent.herbologia.component.EnumCastType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DustPetal extends Item {
	Random random = new Random();
	
	public DustPetal(){
		super();
		setUnlocalizedName("dustPetal");
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldS, ItemStack newS, boolean slotChanged){
		if (slotChanged){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void createData(ItemStack stack, ArrayList<ItemStack> items){
		stack.setTagCompound(new NBTTagCompound());
		int potency = 0;
		int duration = 0;
		int size = 0;
		for (int i = 0; i < items.size(); i ++){
			if (ComponentManager.isValidEffectItem(items.get(i))){
				stack.getTagCompound().setString("effect", ComponentManager.getComponentFromItem(items.get(i)).getName());
			}
			if (items.get(i) != null){
				if (items.get(i).getItem() == Items.glowstone_dust){
					potency ++;
				}
				if (items.get(i).getItem() == Items.redstone){
					duration ++;
				}
				if (items.get(i).getItem() == Items.gunpowder){
					size ++;
				}
			}
		}
		stack.getTagCompound().setInteger("potency", potency);
		stack.getTagCompound().setInteger("duration", duration);
		stack.getTagCompound().setInteger("size", size);
	}
	
	@Override
	public int getItemStackLimit(){
		return 1;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced){
		if (stack.hasTagCompound()){
			ComponentBase comp = ComponentManager.getComponentFromName(stack.getTagCompound().getString("effect"));
			tooltip.add(ChatFormatting.GOLD + "Type: " + comp.getTextColor() + comp.getEffectName());
			tooltip.add(ChatFormatting.RED + "  +" + stack.getTagCompound().getInteger("potency") + " potency.");
			tooltip.add(ChatFormatting.RED + "  +" + stack.getTagCompound().getInteger("duration") + " duration.");
			tooltip.add(ChatFormatting.RED + "  +" + stack.getTagCompound().getInteger("size") + " size.");
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
}
