package elucent.herbologia.item;

import java.util.Random;

import elucent.herbologia.RegistryManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDruidKnife extends Item{
	
	Random rnd = new Random();
	
	public ItemDruidKnife(){
		super();
		setUnlocalizedName("druidKnife");
		setCreativeTab(CreativeTabs.tabMisc);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
	
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(worldIn.getBlockState(pos).getBlock() == Blocks.log ){
        	if(!worldIn.isRemote){
        		switch(worldIn.getBlockState(pos).getBlock().getMetaFromState(worldIn.getBlockState(pos))){
        		case 0:
	        	case 4:
	        	case 8:
        			if(!playerIn.isCreative()){
        				stack.getTagCompound().setInteger("durability",stack.getTagCompound().getInteger("durability")+1);
        			}
        			worldIn.destroyBlock(pos, false);
        			playerIn.entityDropItem(new ItemStack(RegistryManager.oakTreeBark,(rnd.nextInt(2)+1)), 1.f);
        			break;
        		case 1:
        		case 5:
        		case 9:
        			if(!playerIn.isCreative()){
        				stack.getTagCompound().setInteger("durability",stack.getTagCompound().getInteger("durability")+1);
        			}
        			worldIn.destroyBlock(pos, false);
        			playerIn.entityDropItem(new ItemStack(RegistryManager.spruceTreeBark,(rnd.nextInt(2)+1)), 1.f);
        			break;
        		case 2:
        		case 6:
        		case 10:
        			if(!playerIn.isCreative()){
        				stack.getTagCompound().setInteger("durability",stack.getTagCompound().getInteger("durability")+1);
        			}
        			worldIn.destroyBlock(pos, false);
        			playerIn.entityDropItem(new ItemStack(RegistryManager.birchTreeBark,(rnd.nextInt(2)+1)), 1.f);
        			break;
        		case 3:
        		case 7:
        		case 11:
        			if(!playerIn.isCreative()){
        				stack.getTagCompound().setInteger("durability",stack.getTagCompound().getInteger("durability")+1);
        			}
        			worldIn.destroyBlock(pos, false);
        			playerIn.entityDropItem(new ItemStack(RegistryManager.jungleTreeBark,(rnd.nextInt(2)+1)), 1.f);
        			break;
        		}
        	}
        }else if(worldIn.getBlockState(pos).getBlock() == Blocks.log2){
        	if(!worldIn.isRemote){
        		switch(worldIn.getBlockState(pos).getBlock().getMetaFromState(worldIn.getBlockState(pos))){
        		case 0:
	        	case 4:
	        	case 8:
	        		if(!playerIn.isCreative()){
        				stack.getTagCompound().setInteger("durability",stack.getTagCompound().getInteger("durability")+1);
        			}
	        		worldIn.destroyBlock(pos, false);
        			playerIn.entityDropItem(new ItemStack(RegistryManager.acaciaTreeBark,(rnd.nextInt(2)+1)), 1.f);
        			break;
	        	case 1:
        		case 5:
        		case 9:
        			if(!playerIn.isCreative()){
        				stack.getTagCompound().setInteger("durability",stack.getTagCompound().getInteger("durability")+1);
        			}
        			worldIn.destroyBlock(pos, false);
        			playerIn.entityDropItem(new ItemStack(RegistryManager.darkOakTreeBark,(rnd.nextInt(2)+1)), 1.f);
        			break;
	        	}
        	}
        }
        
		return EnumActionResult.PASS;
    }
	
	@Override
	public int getItemStackLimit(){
		return 1;
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack){
		
		if(stack.hasTagCompound()){
			if(stack.getTagCompound().hasKey("durability")){
				return stack.getTagCompound().getInteger("durability") == 0?1.D:(double)(stack.getTagCompound().getInteger("durability"))*100/64/100;
			}else{
				return 1.D;
			}
		}else{
			return 1.D;
		}
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack){
		return this.getDurabilityForDisplay(stack) == 1.D?false:true;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(!stack.hasTagCompound()){
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setInteger("durability", 0);
		}
		
		if(stack.getTagCompound().getInteger("durability") == 64){
			EntityPlayer playerIn = (EntityPlayer) entityIn;
			if(playerIn != null){
				playerIn.inventory.deleteStack(stack);
			}
		}
	}
	
}
