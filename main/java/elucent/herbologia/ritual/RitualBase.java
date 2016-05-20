package elucent.herbologia.ritual;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RitualBase {
	public ArrayList<Block> blocks = new ArrayList<Block>();
	public ArrayList<BlockPos> positions = new ArrayList<BlockPos>();
	public ArrayList<ItemStack> incenses = new ArrayList<ItemStack>();
	public ArrayList<ItemStack> ingredients = new ArrayList<ItemStack>();
	public Vec3d color = new Vec3d(255,255,255);
	public String name = "";
	public String properName = "";
	
	public RitualBase(String parName, String parProperName, double r, double g, double b){
		name = parName;
		properName = parProperName;
		color = new Vec3d(r,g,b);
	}
	
	public RitualBase addBlock(Block b, int x, int y, int z){
		blocks.add(b);
		positions.add(new BlockPos(x,y,z));
		return this;
	}
	
	public RitualBase addIngredient(ItemStack i){
		ingredients.add(i);
		return this;
	}
	
	public RitualBase addIncense(ItemStack i){
		incenses.add(i);
		return this;
	}
	
	public void doEffect(World world, BlockPos pos, List<ItemStack> inventory, List<ItemStack> incenses){
		
	}
}
