package elucent.herbologia.druidChalice;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;

public class druidChaliceEffect {

	//The name the player will see for this effect
	private String name = "";
	//Is this an advanced beverage?
	private boolean advanced = false;
	//Order in ingredients matter!
	private ArrayList<ItemStack> ingredients = null;
	
	//getters
	public String getName(){ return name;}
	public boolean getAdvanced(){return advanced;}
	public int getIngredientCount(){ return ingredients.size();}
	
	
}
