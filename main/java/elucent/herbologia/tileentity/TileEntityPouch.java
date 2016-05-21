package elucent.herbologia.tileentity;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import elucent.herbologia.Herbologia;
import elucent.herbologia.RegistryManager;
import elucent.herbologia.Util;
import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.ComponentManager;
import elucent.herbologia.component.EnumCastType;
import elucent.herbologia.item.DustPetal;
import elucent.herbologia.item.ItemStaff;
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TileEntityPouch extends TEBase implements ITickable {
	public ItemStack dust = null;
	public int remainingTicks = 0;
	public boolean burning = false;
	private long uuidLeast = 0;
	private long uuidMost = 0;
	public UUID casterId = new UUID(uuidLeast,uuidMost);
	ComponentBase comp = null;
	EntityPlayer player = null;
	Random random = new Random();
	
	public TileEntityPouch(){
		super();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
		if (tag.hasKey("burning")){
			burning = tag.getBoolean("burning");
		}
		if (tag.hasKey("ticks")){
			remainingTicks = tag.getInteger("ticks");
		}
		if (tag.hasKey("uuid_1")){
			uuidMost = tag.getLong("uuid_1");
		}
		if (tag.hasKey("uuid_2")){
			uuidLeast = tag.getLong("uuid_2");
		}
		casterId = new UUID(uuidLeast,uuidMost);
		if (tag.hasKey("dust")){
			dust = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("dust"));
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag){
		super.writeToNBT(tag);
		tag.setBoolean("burning", burning);
		tag.setInteger("ticks",remainingTicks);
		tag.setLong("uuid_1", casterId.getMostSignificantBits());
		tag.setLong("uuid_2", casterId.getLeastSignificantBits());
		if (dust != null){
			tag.setTag("dust",dust.writeToNBT(new NBTTagCompound()));
		}
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player){
		this.invalidate();
	}
	
	public boolean activate(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if (heldItem == null){
			burning = false;
			markDirty();
			return true;
		}
		else if (heldItem.getItem() == Items.flint_and_steel){
			if (dust != null){
				burning = true;
			}
			markDirty();
			return true;
		}
		else if (heldItem.getItem() == RegistryManager.dustPetal){
			if (dust == null){
				NBTTagCompound tag = new NBTTagCompound();
				heldItem.writeToNBT(tag);
				dust = ItemStack.loadItemStackFromNBT(tag);
				heldItem.stackSize --;
				markDirty();
				if (dust.hasTagCompound()){
					remainingTicks = 72000 + 72000*dust.getTagCompound().getInteger("duration");
				}
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public void update() {
		if (burning){
			remainingTicks --;
			if (remainingTicks != 0 && remainingTicks % 5 == 0){
				getWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, getPos().getX()+0.5, getPos().getY()+0.5, getPos().getZ()+0.5, (random.nextDouble()-0.5)*0.05, (random.nextDouble())*0.05, (random.nextDouble()-0.5)*0.05, 0);
			}
			if (remainingTicks != 0 && remainingTicks % 20 == 0){
				EntityPlayer player = getWorld().getPlayerEntityByUUID(casterId);
				if (player != null){
					ComponentBase comp = ComponentManager.getComponentFromName(dust.getTagCompound().getString("effect"));
					comp.doEffect(getWorld(), player, EnumCastType.INCENSE, getPos().getX()+0.5, getPos().getY()+0.5, getPos().getZ()+0.5, dust.getTagCompound().getInteger("potency"), dust.getTagCompound().getInteger("duration"), dust.getTagCompound().getInteger("size"));
				}
				else {
					ComponentBase comp = ComponentManager.getComponentFromName(dust.getTagCompound().getString("effect"));
					comp.doEffect(getWorld(), EnumCastType.INCENSE, getPos().getX()+0.5, getPos().getY()+0.5, getPos().getZ()+0.5, dust.getTagCompound().getInteger("potency"), dust.getTagCompound().getInteger("duration"), 1.0+dust.getTagCompound().getInteger("size"));
				}
				getWorld().spawnParticle(EnumParticleTypes.FLAME, getPos().getX()+0.5, getPos().getY()+0.5, getPos().getZ()+0.5,0,0,0, 0);
			}
			if (remainingTicks == 0){
				for (int i = 0; i < 20; i ++){
					getWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, getPos().getX()+0.5, getPos().getY()+0.5, getPos().getZ()+0.5, (random.nextDouble()-0.5)*0.05, (random.nextDouble())*0.05, (random.nextDouble()-0.5)*0.05, 0);
				}
				getWorld().setBlockToAir(getPos());
			}
		}
	}
}
