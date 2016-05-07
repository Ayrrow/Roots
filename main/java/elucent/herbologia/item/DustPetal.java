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
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected){
		if (stack.hasTagCompound()){
			if (stack.getTagCompound().getInteger("cooldown") > 0){
				stack.getTagCompound().setInteger("cooldown", stack.getTagCompound().getInteger("cooldown")-1);
			}
			if (stack.getTagCompound().getInteger("uses") == 0){
				stack.stackSize = 0;
			}
		}
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack){
		if (stack.hasTagCompound()){
			if (stack.getTagCompound().getInteger("cooldown") == 0){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack){
		if (stack.hasTagCompound()){
			return ((double)stack.getTagCompound().getInteger("cooldown"))/14.0;
		}
		return 1.0;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
		if (hand == EnumHand.MAIN_HAND || player.isSneaking() && hand == EnumHand.OFF_HAND){
			if (stack.hasTagCompound()){
				if (stack.getTagCompound().getInteger("cooldown") == 0 && stack.getTagCompound().getInteger("uses") > 0){
					stack.getTagCompound().setInteger("cooldown", 14);
					stack.getTagCompound().setInteger("uses", stack.getTagCompound().getInteger("uses")-1);
					ComponentBase comp = ComponentManager.getComponentFromName(stack.getTagCompound().getString("effect"));
					System.out.println(stack.getTagCompound().getString("name"));
					if (comp != null){
						comp.doEffect(world, player, EnumCastType.SPELL, player.posX+player.getLookVec().xCoord, player.posY+player.getLookVec().yCoord, player.posZ+player.getLookVec().zCoord, stack.getTagCompound().getInteger("potency"), stack.getTagCompound().getInteger("duration"), stack.getTagCompound().getInteger("size"));
						comp.doEffect(world, player, EnumCastType.SPELL, player.posX+player.getLookVec().xCoord*2.0, player.posY+player.getLookVec().yCoord*2.0, player.posZ+player.getLookVec().zCoord*2.0, stack.getTagCompound().getInteger("potency"), stack.getTagCompound().getInteger("duration"), stack.getTagCompound().getInteger("size")*1.5);
						comp.doEffect(world, player, EnumCastType.SPELL, player.posX+player.getLookVec().xCoord*3.0, player.posY+player.getLookVec().yCoord*2.0, player.posZ+player.getLookVec().zCoord*3.0, stack.getTagCompound().getInteger("potency"), stack.getTagCompound().getInteger("duration"), stack.getTagCompound().getInteger("size")*2.0);
					}
					for (int i = 0; i < 20; i ++){
						double x = player.posX+player.getLookVec().xCoord+(random.nextFloat()-0.5)*0.25;
						double y = player.posY+player.eyeHeight+player.getLookVec().yCoord+(random.nextFloat()-0.5)*0.25;
						double z = player.posZ+player.getLookVec().zCoord+(random.nextFloat()-0.5)*0.25;
						Herbologia.proxy.spawnParticleMagicFX(world, x, y, z, (x-player.posX)*0.15, ((y)-(player.posY+player.eyeHeight))*0.5+0.15, (z-player.posZ)*0.15, 1, 0, 0);
					}
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
				}
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
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
		stack.getTagCompound().setInteger("cooldown", 0);
		stack.getTagCompound().setInteger("uses",16);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced){
		if (stack.hasTagCompound()){
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel(){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
}
