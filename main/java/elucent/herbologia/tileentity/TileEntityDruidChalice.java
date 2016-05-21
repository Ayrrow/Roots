package elucent.herbologia.tileentity;

import elucent.herbologia.druidChalice.druidChaliceEffect;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityDruidChalice extends TEBase{
	
	public boolean empty = true;
	public druidChaliceEffect currentEffect = null;
	public ItemStack containedItem = null;
	
	public TileEntityDruidChalice(){
		super();
	}
	
	@Override
	public boolean activate(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(heldItem != null & empty){
			containedItem = heldItem;
			heldItem.stackSize --;
			empty = false;
		}
		return true;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state, EntityPlayer player){
		if(!empty & !world.isRemote){
			player.entityDropItem(containedItem, 0);
		}
		this.invalidate();
	}
	
}
