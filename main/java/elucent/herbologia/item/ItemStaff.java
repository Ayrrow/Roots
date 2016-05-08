package elucent.herbologia.item;

import java.util.List;
import java.util.Random;

import com.mojang.realmsclient.gui.ChatFormatting;

import elucent.herbologia.Herbologia;
import elucent.herbologia.Util;
import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.ComponentManager;
import elucent.herbologia.component.EnumCastType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
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
	public EnumAction getItemUseAction(ItemStack stack){
		return EnumAction.BOW;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected){
		if (stack.hasTagCompound()){
			if (stack.getTagCompound().getInteger("cooldown") > 0){
				stack.getTagCompound().setInteger("cooldown", stack.getTagCompound().getInteger("cooldown")-1);
			}
		}
	}
	
	/*if (stack.hasTagCompound()){
			if (stack.getTagCompound().getInteger("cooldown") == 0 && stack.getTagCompound().getInteger("uses") > 0){
				stack.getTagCompound().setInteger("cooldown", 14);
				stack.getTagCompound().setInteger("uses", stack.getTagCompound().getInteger("uses") - 1);
				ComponentBase comp = ComponentManager.getComponentFromName(stack.getTagCompound().getString("effect"));
				int potency = stack.getTagCompound().getInteger("potency");
				int duration = stack.getTagCompound().getInteger("duration");
				int size = stack.getTagCompound().getInteger("size");
				Random random = new Random();
				comp.doEffect(world, player, EnumCastType.SPELL, player.posX+3.0*player.getLookVec().xCoord, player.posY+3.0*player.getLookVec().yCoord, player.posZ+3.0*player.getLookVec().zCoord, potency, duration, 3.0+2.0*size);
				for (int i = 0 ; i < 90; i ++){
					double offX = random.nextFloat()*0.5-0.25;
					double offY = random.nextFloat()*0.5-0.25;
					double offZ = random.nextFloat()*0.5-0.25;
					double coeff = (offX+offY+offZ)/1.5+0.5;
					double dx = (player.getLookVec().xCoord+offX)*coeff;
					double dy = (player.getLookVec().yCoord+offY)*coeff;
					double dz = (player.getLookVec().zCoord+offZ)*coeff;
					if (random.nextBoolean()){
						Herbologia.proxy.spawnParticleMagicFX(world, player.posX+dx, player.posY+1.5+dy, player.posZ+dz, dx, dy, dz, comp.primaryColor.xCoord, comp.primaryColor.yCoord, comp.primaryColor.zCoord);
					}
					else {
						Herbologia.proxy.spawnParticleMagicFX(world, player.posX+dx, player.posY+1.5+dy, player.posZ+dz, dx, dy, dz, comp.secondaryColor.xCoord, comp.secondaryColor.yCoord, comp.secondaryColor.zCoord);
					}
				}
				if (stack.getTagCompound().getInteger("uses") == 0){
					player.inventory.removeStackFromSlot(0);
				}
			}
		}*/
	@Override
	public int getMaxItemUseDuration(ItemStack stack){
		return 72000;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase player, int timeLeft){
		if (stack.hasTagCompound()){
			if (stack.getTagCompound().getInteger("cooldown") == 0 && stack.getTagCompound().getInteger("uses") > 0){
				stack.getTagCompound().setInteger("cooldown", 14);
				stack.getTagCompound().setInteger("uses", stack.getTagCompound().getInteger("uses") - 1);
				ComponentBase comp = ComponentManager.getComponentFromName(stack.getTagCompound().getString("effect"));
				int potency = stack.getTagCompound().getInteger("potency");
				int duration = stack.getTagCompound().getInteger("duration");
				int size = stack.getTagCompound().getInteger("size");
				Random random = new Random();
				comp.doEffect(world, player, EnumCastType.SPELL, player.posX+3.0*player.getLookVec().xCoord, player.posY+3.0*player.getLookVec().yCoord, player.posZ+3.0*player.getLookVec().zCoord, potency, duration, 3.0+2.0*size);
				for (int i = 0 ; i < 90; i ++){
					double offX = random.nextFloat()*0.5-0.25;
					double offY = random.nextFloat()*0.5-0.25;
					double offZ = random.nextFloat()*0.5-0.25;
					double coeff = (offX+offY+offZ)/1.5+0.5;
					double dx = (player.getLookVec().xCoord+offX)*coeff;
					double dy = (player.getLookVec().yCoord+offY)*coeff;
					double dz = (player.getLookVec().zCoord+offZ)*coeff;
					if (random.nextBoolean()){
						Herbologia.proxy.spawnParticleMagicFX(world, player.posX+dx, player.posY+1.5+dy, player.posZ+dz, dx, dy, dz, comp.primaryColor.xCoord, comp.primaryColor.yCoord, comp.primaryColor.zCoord);
					}
					else {
						Herbologia.proxy.spawnParticleMagicFX(world, player.posX+dx, player.posY+1.5+dy, player.posZ+dz, dx, dy, dz, comp.secondaryColor.xCoord, comp.secondaryColor.yCoord, comp.secondaryColor.zCoord);
					}
				}
				if (stack.getTagCompound().getInteger("uses") == 0){
					((EntityPlayer)player).inventory.removeStackFromSlot(0);
				}
			}
		}
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
		player.setActiveHand(hand);
		
		return new ActionResult(EnumActionResult.PASS, stack);
	}
	
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldS, ItemStack newS, boolean slotChanged){
		return slotChanged;
	}
	
	public static void createData(ItemStack stack, String effect, int potency, int duration, int size){
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("effect", effect);
		stack.getTagCompound().setInteger("potency", potency);
		stack.getTagCompound().setInteger("duration", duration);
		stack.getTagCompound().setInteger("size", size);
		stack.getTagCompound().setInteger("uses", 65+64*duration);
		stack.getTagCompound().setInteger("cooldown", 0);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced){
		if (stack.hasTagCompound()){
			ComponentBase comp = ComponentManager.getComponentFromName(stack.getTagCompound().getString("effect"));
			tooltip.add(ChatFormatting.GOLD + "Type: " + comp.getTextColor() + comp.getEffectName());
			tooltip.add(ChatFormatting.RED + "  +" + stack.getTagCompound().getInteger("potency") + " potency.");
			tooltip.add(ChatFormatting.RED + "  +" + stack.getTagCompound().getInteger("duration") + " duration.");
			tooltip.add(ChatFormatting.RED + "  +" + stack.getTagCompound().getInteger("size") + " size.");
			tooltip.add("");
			tooltip.add(ChatFormatting.GOLD + Integer.toString(stack.getTagCompound().getInteger("uses")) + " uses remaining.");
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName()+"_0","inventory"));
		ModelLoader.setCustomModelResourceLocation(this, 1, new ModelResourceLocation(getRegistryName()+"_1","inventory"));
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
