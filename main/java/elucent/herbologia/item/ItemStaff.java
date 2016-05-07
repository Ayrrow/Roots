package elucent.herbologia.item;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import elucent.herbologia.Util;
import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.ComponentManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStaff extends Item {
	public ItemStaff(){
		super();
		setUnlocalizedName("staff");
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
		if (stack.getItemDamage() == 0){
			stack.setItemDamage(1);
		}
		else {
			stack.setItemDamage(0);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
	
	public static void createData(ItemStack stack, String effect, int potency, int duration, int size){
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("effect", effect);
		stack.getTagCompound().setInteger("potency", potency);
		stack.getTagCompound().setInteger("duration", duration);
		stack.getTagCompound().setInteger("size", size);
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
		ModelBakery.registerItemVariants(this, new ResourceLocation(getRegistryName()+"_0"), new ResourceLocation(getRegistryName()+"_1"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation(getRegistryName()+"_0","inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 1, new ModelResourceLocation(getRegistryName()+"_1","inventory"));
	}
	
	public static class ColorHandler implements IItemColor {
		public ColorHandler(){
			//
		}
		@Override
		public int getColorFromItemstack(ItemStack stack, int layer) {
			if (stack.hasTagCompound()){
				if (layer == 2){
					ComponentBase comp = ComponentManager.getComponentFromName(stack.getTagCompound().getString("effect"));
					return Util.intColor((int)comp.primaryColor.xCoord,(int)comp.primaryColor.yCoord,(int)comp.primaryColor.zCoord);
				}
				if (layer == 1){
					ComponentBase comp = ComponentManager.getComponentFromName(stack.getTagCompound().getString("effect"));
					return Util.intColor((int)comp.secondaryColor.xCoord,(int)comp.secondaryColor.yCoord,(int)comp.secondaryColor.zCoord);
				}
			}
			return Util.intColor(255, 255, 255);
		}
	}
}
