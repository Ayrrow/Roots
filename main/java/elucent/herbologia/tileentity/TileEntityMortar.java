package elucent.herbologia.tileentity;

import java.util.ArrayList;

import elucent.herbologia.RegistryManager;
import elucent.herbologia.Util;
import elucent.herbologia.component.ComponentManager;
import elucent.herbologia.item.DustPetal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TileEntityMortar extends TEBase {
	public ItemStack effectItem = null;
	public ArrayList<ItemStack> modifiers = new ArrayList<ItemStack>();
	
	public TileEntityMortar(){
		super();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		modifiers = new ArrayList<ItemStack>();
		if (tag.hasKey("effectItem")){
			effectItem = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("effectItem"));
		}
		if (tag.hasKey("modifiers")){
			NBTTagList list = tag.getTagList("modifiers", Constants.NBT.TAG_COMPOUND);
			System.out.println("Loading taglist: " + list.toString());
			for (int i = 0; i < list.tagCount(); i ++){
				modifiers.add(ItemStack.loadItemStackFromNBT(list.getCompoundTagAt(i)));
				System.out.println("  - Added item: " + modifiers.get(modifiers.size()-1).toString());
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag){
		super.writeToNBT(tag);
		if (effectItem != null){
			tag.setTag("effectItem",effectItem.writeToNBT(new NBTTagCompound()));
		}
		if (modifiers.size() > 0){
			NBTTagList list = new NBTTagList();
			for (int i = 0; i < modifiers.size(); i ++){;
				list.appendTag(modifiers.get(i).writeToNBT(new NBTTagCompound()));
			}
			System.out.println("Taglist: " + list.toString());
			tag.setTag("modifiers",list);
		}
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player){
		if (effectItem != null){
			if (!world.isRemote){
				world.spawnEntityInWorld(new EntityItem(world,pos.getX()+0.5,pos.getY()+0.5,pos.getZ()+0.5,effectItem));
			}
		}
		for (int i = 0; i < modifiers.size(); i ++){
			if (!world.isRemote){
				world.spawnEntityInWorld(new EntityItem(world,pos.getX()+0.5,pos.getY()+0.5,pos.getZ()+0.5,modifiers.get(i)));
			}
		}
		this.invalidate();
	}
	
	public boolean activate(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if (heldItem == null){
			if (modifiers.size() > 0){
				if (!world.isRemote){
					world.spawnEntityInWorld(new EntityItem(world, pos.getX()+0.5, pos.getY()+1.0, pos.getZ()+0.5, modifiers.remove(modifiers.size()-1)));
				}
				else {
					modifiers.remove(modifiers.size()-1);
				}
				markDirty();
				return true;
			}
			else if (effectItem != null){
				if (!world.isRemote){
					world.spawnEntityInWorld(new EntityItem(world, pos.getX()+0.5, pos.getY()+1.0, pos.getZ()+0.5, effectItem));
				}
				effectItem = null;
				markDirty();
				return true;
			}
		}
		else if (heldItem.getItem() == RegistryManager.pestle){
			if (effectItem != null){
				ItemStack dust = new ItemStack(RegistryManager.dustPetal,1,0);
				modifiers.add(effectItem);
				DustPetal.createData(dust, modifiers);
				if (!world.isRemote){
					world.spawnEntityInWorld(new EntityItem(world,pos.getX()+0.5,pos.getY()+1.0,pos.getZ()+0.5,dust));
				}
				modifiers.clear();
				effectItem = null;
				markDirty();
				return true;
			}
		}
		else {
			if (effectItem == null){
				if (ComponentManager.isValidEffectItem(heldItem)){
					if (Util.containsItem(modifiers, RegistryManager.oldRoot) ||
						Util.containsItem(modifiers, RegistryManager.verdantSprig) ||
						Util.containsItem(modifiers, RegistryManager.infernalStem) ||
						Util.containsItem(modifiers, RegistryManager.dragonsEye)){
						effectItem = new ItemStack(heldItem.getItem(),1,heldItem.getMetadata());
						heldItem.stackSize --;
						markDirty();
						return true;
					}
				}
			}
			if (heldItem.getItem() == RegistryManager.oldRoot || heldItem.getItem() == RegistryManager.verdantSprig || heldItem.getItem() == RegistryManager.infernalStem || heldItem.getItem() == RegistryManager.dragonsEye || heldItem.getItem() == Items.redstone || heldItem.getItem() == Items.glowstone_dust || heldItem.getItem() == Items.gunpowder){
				if (Util.containsItem(modifiers, RegistryManager.verdantSprig) && modifiers.size() < 2 || 
					Util.containsItem(modifiers, RegistryManager.infernalStem) && modifiers.size() < 3 || 
					Util.containsItem(modifiers, RegistryManager.dragonsEye) && modifiers.size() < 4 ||
					heldItem.getItem() == RegistryManager.oldRoot || heldItem.getItem() == RegistryManager.verdantSprig || heldItem.getItem() == RegistryManager.infernalStem || heldItem.getItem() == RegistryManager.dragonsEye){
					modifiers.add(new ItemStack(heldItem.getItem(),1,heldItem.getMetadata()));
					heldItem.stackSize --;
					markDirty();
					return true;
				}
			}
		}
		return false;
	}
}
