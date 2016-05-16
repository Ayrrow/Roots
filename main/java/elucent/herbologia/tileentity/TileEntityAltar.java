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

public class TileEntityAltar extends TEBase implements ITickable {
	public ItemStack dust = null;
	public int remainingTicks = 0;
	public boolean burning = false;
	Random random = new Random();
	
	public TileEntityAltar(){
		super();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag){
		super.readFromNBT(tag);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag){
		super.writeToNBT(tag);
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player){
		this.invalidate();
	}
	
	public boolean activate(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		return false;
	}

	@Override
	public void update() {
	}
}
