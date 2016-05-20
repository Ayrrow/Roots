package elucent.herbologia.ritual;

import java.util.ArrayList;
import java.util.List;

import elucent.herbologia.RegistryManager;
import elucent.herbologia.Util;
import elucent.herbologia.ritual.rituals.RitualBloomery;
import elucent.herbologia.ritual.rituals.RitualImbuer;
import elucent.herbologia.tileentity.TileEntityBrazier;
import elucent.herbologia.tileentity.TileEntityAltar;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RitualManager {
	public static ArrayList<RitualBase> rituals = new ArrayList<RitualBase>();
	
	public static void init(){
		rituals.add(new RitualBloomery()
					.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
					.addIncense(new ItemStack(Blocks.coal_block,1))
					.addIncense(new ItemStack(RegistryManager.acaciaTreeBark,1))
					.addIncense(new ItemStack(RegistryManager.verdantSprig,1))
					.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
					.addIngredient(new ItemStack(Blocks.diamond_block,1))
					.addIngredient(new ItemStack(Items.stick,1))
					.addIngredient(new ItemStack(Items.blaze_powder,1)));
		rituals.add(new RitualImbuer()
					.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
					.addIngredient(new ItemStack(RegistryManager.crystalStaff,1))
					.addIngredient(new ItemStack(RegistryManager.verdantSprig,1)));
	}
	
	public static RitualBase getRitualFromName(String name){
		for (int i = 0; i < rituals.size(); i ++){
			if (rituals.get(i).name == name){
				return rituals.get(i);
			}
		}
		return null;
	}
	
	public static ArrayList<ItemStack> getIncenses(World world, BlockPos pos){
		ArrayList<ItemStack> test = new ArrayList<ItemStack>();
		for (int i = -4; i < 5; i ++){
			for (int j = -4; j < 5; j ++){
				if (world.getBlockState(pos.add(i,0,j)).getBlock() == RegistryManager.brazier){
					if (world.getTileEntity(pos.add(i,0,j)) != null){
						TileEntityBrazier teb = (TileEntityBrazier)world.getTileEntity(pos.add(i,0,j));
						if (teb.burning){
							test.add(teb.heldItem);
						}
					}
				}
			}
		}
		return test;
	}
	
	public static boolean matches(World world, BlockPos pos, RitualBase ritual){
		for (int i = 0; i < ritual.positions.size(); i ++){
			if (world.getBlockState(pos.add(ritual.positions.get(i).getX(),ritual.positions.get(i).getY(),ritual.positions.get(i).getZ())).getBlock() != ritual.blocks.get(i)){
				return false;
			}
		}
		ArrayList<ItemStack> test = new ArrayList<ItemStack>();
		for (int i = -4; i < 5; i ++){
			for (int j = -4; j < 5; j ++){
				if (world.getBlockState(pos.add(i,0,j)).getBlock() == RegistryManager.brazier){
					if (world.getTileEntity(pos.add(i,0,j)) != null){
						TileEntityBrazier teb = (TileEntityBrazier)world.getTileEntity(pos.add(i,0,j));
						if (teb.burning){
							test.add(teb.heldItem);
						}
					}
				}
			}
		}
		return Util.itemListsMatch(ritual.incenses, test) && Util.itemListsMatchWithSize(ritual.ingredients,((TileEntityAltar)world.getTileEntity(pos)).inventory);
	}
}
