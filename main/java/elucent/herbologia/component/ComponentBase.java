package elucent.herbologia.component;

import java.util.List;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ComponentBase {
	String name = "";
	String effectName = "";
	ItemStack itemSource = null;
	
	public ComponentBase(String name, String effectName, ItemStack item){
		this.name = name;
		this.effectName = effectName;
		itemSource = item;
	}

	public ComponentBase(String name, String effectName, Item item){
		this.name = name;
		this.effectName = effectName;
		itemSource = new ItemStack(item);
	}

	public ComponentBase(String name, String effectName, Block item){
		this.name = name;
		this.effectName = effectName;
		itemSource = new ItemStack(item);
	}

	public ComponentBase(String name, String effectName, Item item, int meta){
		this.name = name;
		this.effectName = effectName;
		itemSource = new ItemStack(item,1,meta);
	}

	public ComponentBase(String name, String effectName, Block item, int meta){
		this.name = name;
		this.effectName = effectName;
		itemSource = new ItemStack(item,1,meta);
	}
	
	public String getName(){
		return name;
	}
	
	public String getEffectName(){
		return effectName;
	}
	
	public ItemStack getItem(){
		return itemSource;
	}
	
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		
	}
}
