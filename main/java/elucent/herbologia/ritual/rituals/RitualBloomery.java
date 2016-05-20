package elucent.herbologia.ritual.rituals;

import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import elucent.herbologia.RegistryManager;
import elucent.herbologia.Util;
import elucent.herbologia.ritual.RitualBase;

public class RitualBloomery extends RitualBase {

	public RitualBloomery() {
		super("bloomery", "Crystal Bloomery", 255, 189, 46);
	}
	
	@Override
	public void doEffect(World world, BlockPos pos, List<ItemStack> inventory, List<ItemStack> incenses){
		if (Util.containsItem(inventory, Blocks.diamond_block) && Util.containsItem(inventory, Items.stick) && Util.containsItem(inventory, Items.blaze_powder)){
			ItemStack toSpawn = new ItemStack(RegistryManager.crystalStaff, 1);
			if (!world.isRemote){
				world.spawnEntityInWorld(new EntityItem(world,pos.getX()+0.5,pos.getY()+1.5,pos.getZ()+0.5,toSpawn));
			}
			inventory.clear();
			world.getTileEntity(pos).markDirty();
		}
	}
}
