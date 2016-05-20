package elucent.herbologia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Util {
	public static Random random = new Random();
	public static ArrayList<IBlockState> oreList = new ArrayList<IBlockState>();
	
	public static void initOres(){
		oreList.add(Blocks.iron_ore.getDefaultState());
		oreList.add(Blocks.gold_ore.getDefaultState());
		oreList.add(Blocks.diamond_ore.getDefaultState());
		oreList.add(Blocks.redstone_ore.getDefaultState());
		oreList.add(Blocks.lapis_ore.getDefaultState());
		oreList.add(Blocks.coal_ore.getDefaultState());
	}
	
	public static boolean containsItem(List<ItemStack> list, Item item){
		for (int i = 0; i < list.size(); i ++){
			if (list.get(i) != null){
				if (list.get(i).getItem() == item){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean containsItem(List<ItemStack> list, Block item){
		for (int i = 0; i < list.size(); i ++){
			if (list.get(i) != null){
				if (Block.getBlockFromItem(list.get(i).getItem()) == item){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean containsItem(List<ItemStack> list, Item item, int meta){
		for (int i = 0; i < list.size(); i ++){
			if (list.get(i) != null){
				if (list.get(i).getItem() == item && list.get(i).getMetadata() == meta){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean containsItem(List<ItemStack> list, Block item, int meta){
		for (int i = 0; i < list.size(); i ++){
			if (list.get(i) != null){
				if (Block.getBlockFromItem(list.get(i).getItem()) == item && list.get(i).getMetadata() == meta){
					return true;
				}
			}
		}
		return false;
	}
	
	public static IBlockState getRandomOre(){
		return oreList.get(random.nextInt(oreList.size()));
	}
	
	public static int intColor(int r, int g, int b){
		return (r*65536 + g*256 + b);
	}

	public static boolean isNaturalBlock(Block block) {
		return block == Blocks.dirt || block == Blocks.grass || block == Blocks.grass_path || block == Blocks.mossy_cobblestone || block == Blocks.water || block == Blocks.flowing_water || block == Blocks.log || block == Blocks.log2;
	}
	
	public static boolean itemListsMatchWithSize(List<ItemStack> i1, List<ItemStack> i2){
		ArrayList<ItemStack> recipe = new ArrayList<ItemStack>();
		ArrayList<ItemStack> available = new ArrayList<ItemStack>();
		recipe.addAll(i1);
		available.addAll(i2);
		for (int i = 0; i < recipe.size(); i ++){
			if (recipe.get(i) == null){
				recipe.remove(i);
				i --;
			}
		}
		for (int i = 0; i < available.size(); i ++){
			if (available.get(i) == null){
				available.remove(i);
				i --;
			}
		}
		if (available.size() == recipe.size()){
			for (int j = 0; j < available.size(); j ++){
				boolean endIteration = false;
				for (int i = 0; i < recipe.size() && !endIteration; i ++){
					if (available.get(j).getItem() == recipe.get(i).getItem() && available.get(j).getItemDamage() == recipe.get(i).getItemDamage()){
						recipe.remove(i);
						endIteration = true;
					}
				}
			}
		}
		return recipe.size() == 0;
	}
	
	public static boolean itemListsMatch(List<ItemStack> i1, List<ItemStack> i2){
		ArrayList<ItemStack> recipe = new ArrayList<ItemStack>();
		ArrayList<ItemStack> available = new ArrayList<ItemStack>();
		recipe.addAll(i1);
		available.addAll(i2);
		for (int i = 0; i < recipe.size(); i ++){
			if (recipe.get(i) == null){
				recipe.remove(i);
				i --;
			}
		}
		for (int i = 0; i < available.size(); i ++){
			if (available.get(i) == null){
				available.remove(i);
				i --;
			}
		}
		if (available.size() >= recipe.size()){
			for (int j = 0; j < available.size(); j ++){
				boolean endIteration = false;
				for (int i = 0; i < recipe.size() && !endIteration; i ++){
					if (available.get(j).getItem() == recipe.get(i).getItem() && available.get(j).getItemDamage() == recipe.get(i).getItemDamage()){
						recipe.remove(i);
						endIteration = true;
					}
				}
			}
		}
		return recipe.size() == 0;
	}
}
