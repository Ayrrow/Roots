package elucent.herbologia.component;

import java.util.ArrayList;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import elucent.herbologia.RegistryManager;
import elucent.herbologia.component.components.ComponentAllium;
import elucent.herbologia.component.components.ComponentAzureBluet;
import elucent.herbologia.component.components.ComponentBlueOrchid;
import elucent.herbologia.component.components.ComponentChorus;
import elucent.herbologia.component.components.ComponentDandelion;
import elucent.herbologia.component.components.ComponentLilac;
import elucent.herbologia.component.components.ComponentLilyPad;
import elucent.herbologia.component.components.ComponentNetherWart;
import elucent.herbologia.component.components.ComponentOrangeTulip;
import elucent.herbologia.component.components.ComponentOxeyeDaisy;
import elucent.herbologia.component.components.ComponentPeony;
import elucent.herbologia.component.components.ComponentPinkTulip;
import elucent.herbologia.component.components.ComponentPoisonousPotato;
import elucent.herbologia.component.components.ComponentPoppy;
import elucent.herbologia.component.components.ComponentRedTulip;
import elucent.herbologia.component.components.ComponentRose;
import elucent.herbologia.component.components.ComponentSunflower;
import elucent.herbologia.component.components.ComponentWhiteTulip;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ComponentManager {
	public static ArrayList<ComponentBase> components = new ArrayList<ComponentBase>();
	public static ArrayList<ComponentRecipe> recipes = new ArrayList<ComponentRecipe>();
	
	public static void init(){
		components.add(new ComponentRose().setPrimaryColor(192, 0, 72).setSecondaryColor(0, 200, 48).setTextColor(ChatFormatting.GREEN));
		components.add(new ComponentDandelion().setPrimaryColor(255,217,102).setSecondaryColor(240,159,10).setTextColor(ChatFormatting.YELLOW));
		components.add(new ComponentChorus().setPrimaryColor(95,57,95).setSecondaryColor(225,215,225).setTextColor(ChatFormatting.DARK_PURPLE));
		components.add(new ComponentNetherWart().setPrimaryColor(255,76,36).setSecondaryColor(255,174,0).setTextColor(ChatFormatting.GOLD));
		components.add(new ComponentPeony().setPrimaryColor(255,102,178).setSecondaryColor(255,51,153).setTextColor(ChatFormatting.DARK_PURPLE));
		components.add(new ComponentSunflower().setPrimaryColor(255,255,128).setSecondaryColor(255,255,255).setTextColor(ChatFormatting.WHITE));
		components.add(new ComponentLilac().setPrimaryColor(112,80,112).setSecondaryColor(0,112,24).setTextColor(ChatFormatting.GREEN));
		components.add(new ComponentAzureBluet().setPrimaryColor(240,240,255).setSecondaryColor(86,86,96).setTextColor(ChatFormatting.GRAY));
		components.add(new ComponentAllium().setPrimaryColor(255,202,255).setSecondaryColor(51,30,50).setTextColor(ChatFormatting.DARK_PURPLE));
		components.add(new ComponentWhiteTulip().setPrimaryColor(255,255,255).setSecondaryColor(136,252,255).setTextColor(ChatFormatting.AQUA));
		components.add(new ComponentRedTulip().setPrimaryColor(128,16,16).setSecondaryColor(128,16,64).setTextColor(ChatFormatting.DARK_RED));
		components.add(new ComponentPoppy().setPrimaryColor(255,0,0).setSecondaryColor(50,50,50).setTextColor(ChatFormatting.RED));
		components.add(new ComponentBlueOrchid().setPrimaryColor(135,157,255).setSecondaryColor(170,170,175).setTextColor(ChatFormatting.GRAY));
		components.add(new ComponentPoisonousPotato().setPrimaryColor(172,255,81).setSecondaryColor(81,181,255).setTextColor(ChatFormatting.YELLOW));
		components.add(new ComponentOrangeTulip().setPrimaryColor(255,181,70).setSecondaryColor(255,255,0).setTextColor(ChatFormatting.GOLD));
		components.add(new ComponentPinkTulip().setPrimaryColor(255,0,51).setSecondaryColor(255,0,249).setTextColor(ChatFormatting.LIGHT_PURPLE));
		components.add(new ComponentOxeyeDaisy().setPrimaryColor(255,254,206).setSecondaryColor(52,0,74).setTextColor(ChatFormatting.WHITE));
		components.add(new ComponentLilyPad().setPrimaryColor(36,255,167).setSecondaryColor(8,0,255).setTextColor(ChatFormatting.BLUE));
		
		recipes.add(new ComponentRecipe("rosebush")
					.addIngredient(new ItemStack(Blocks.double_plant,1,4))
					.addIngredient(new ItemStack(Items.fermented_spider_eye,1))
					.addIngredient(new ItemStack(Items.bone,1)));
		recipes.add(new ComponentRecipe("dandelion")
					.addIngredient(new ItemStack(Blocks.yellow_flower,1))
					.addIngredient(new ItemStack(Items.string,1))
					.addIngredient(new ItemStack(Items.feather,1,1)));
		recipes.add(new ComponentRecipe("chorus")
					.addIngredient(new ItemStack(Items.chorus_fruit,1))
					.addIngredient(new ItemStack(Items.ender_pearl,1))
					.addIngredient(new ItemStack(Items.dye,1,5))
					.addIngredient(new ItemStack(Items.chorus_fruit_popped,1)));
		recipes.add(new ComponentRecipe("netherwart")
					.addIngredient(new ItemStack(Items.nether_wart,1,0))
					.addIngredient(new ItemStack(Items.blaze_powder,1,0))
					.addIngredient(new ItemStack(Items.coal,1,0))
					.addIngredient(new ItemStack(Items.coal,1,1)));
		recipes.add(new ComponentRecipe("peony")
					.addIngredient(new ItemStack(Blocks.double_plant,1,5))
					.addIngredient(new ItemStack(Items.melon,1))
					.addIngredient(new ItemStack(Items.dye,1,1)));
		recipes.add(new ComponentRecipe("sunflower")
					.addIngredient(new ItemStack(Blocks.double_plant,1,0))
					.addIngredient(new ItemStack(Blocks.lit_pumpkin,1))
					.addIngredient(new ItemStack(Items.dye,1,15)));
		recipes.add(new ComponentRecipe("azurebluet")
					.addIngredient(new ItemStack(Blocks.red_flower,1,3))
					.addIngredient(new ItemStack(Items.iron_ingot,1))
					.addIngredient(new ItemStack(Blocks.sapling,1,1)));
		recipes.add(new ComponentRecipe("allium")
					.addIngredient(new ItemStack(Blocks.red_flower,1,2))
					.addIngredient(new ItemStack(Blocks.soul_sand,1))
					.addIngredient(new ItemStack(Blocks.brown_mushroom,1)));
		recipes.add(new ComponentRecipe("lilac")
					.addIngredient(new ItemStack(Blocks.double_plant,1,1))
					.addIngredient(new ItemStack(Items.wheat,1))
					.addIngredient(new ItemStack(Items.beetroot,1))
					.addIngredient(new ItemStack(Blocks.vine,1)));
		recipes.add(new ComponentRecipe("whitetulip")
					.addIngredient(new ItemStack(Blocks.red_flower,1,6))
					.addIngredient(new ItemStack(Items.snowball,1))
					.addIngredient(new ItemStack(Blocks.sapling,1,2)));
		recipes.add(new ComponentRecipe("redtulip")
					.addIngredient(new ItemStack(Blocks.red_flower,1,4))
					.addIngredient(new ItemStack(Blocks.nether_brick_fence,1))
					.addIngredient(new ItemStack(Items.quartz,1))
					.addIngredient(new ItemStack(Blocks.sand,1,1)));
		recipes.add(new ComponentRecipe("blueorchid")
					.addIngredient(new ItemStack(Blocks.red_flower,1,1))
					.addIngredient(new ItemStack(Items.prismarine_shard,1))
					.addIngredient(new ItemStack(Items.dye,1,4))
					.addIngredient(new ItemStack(Blocks.vine,1)));
		recipes.add(new ComponentRecipe("poppy")
					.addIngredient(new ItemStack(Blocks.red_flower,1,0))
					.addIngredient(new ItemStack(Blocks.red_mushroom,1))
					.addIngredient(new ItemStack(Items.beef,1,4)));
		recipes.add(new ComponentRecipe("poisonouspotato")
					.addIngredient(new ItemStack(Items.poisonous_potato,1,0))
					.addIngredient(new ItemStack(Blocks.glass,1))
					.addIngredient(new ItemStack(Blocks.glowstone,1))
					.addIngredient(new ItemStack(Items.reeds,1)));
		recipes.add(new ComponentRecipe("orangetulip")
					.addIngredient(new ItemStack(Blocks.red_flower,1,5))
					.addIngredient(new ItemStack(Blocks.sponge,1))
					.addIngredient(new ItemStack(Items.leather,1)));
		recipes.add(new ComponentRecipe("pinktulip")
					.addIngredient(new ItemStack(Blocks.red_flower,1,7))
					.addIngredient(new ItemStack(Items.melon_seeds,1))
					.addIngredient(new ItemStack(Items.porkchop,1))
					.addIngredient(new ItemStack(Blocks.stone,1,1)));
		recipes.add(new ComponentRecipe("oxeyedaisy")
					.addIngredient(new ItemStack(Blocks.red_flower,1,8))
					.addIngredient(new ItemStack(Blocks.end_stone,1))
					.addIngredient(new ItemStack(Items.gold_ingot,1))
					.addIngredient(new ItemStack(Items.sugar,1)));
		recipes.add(new ComponentRecipe("lilypad")
					.addIngredient(new ItemStack(Blocks.waterlily,1))
					.addIngredient(new ItemStack(Blocks.sponge,1,1))
					.addIngredient(new ItemStack(Items.beetroot,1)));
		recipes.add(new ComponentRecipe("apple")
					.addIngredient(new ItemStack(Items.apple,1))
					.addIngredient(new ItemStack(Items.speckled_melon,1))
					.addIngredient(new ItemStack(Items.golden_apple,1)));
	}
	
	public static boolean isValidEffectItem(ItemStack stack){
		for (int i = 0; i < components.size(); i ++){
			if (components.get(i).getItem() != null && stack != null){
				if (components.get(i).getItem().getItem() == stack.getItem()
					&& components.get(i).getItem().getMetadata() == stack.getMetadata()){
					return true;
				}
			}
		}
		return false;
	}
	
	public static ComponentRecipe getRecipe(List<ItemStack> items){
		for (int i = 0; i < recipes.size(); i ++){
			if (recipes.get(i).matches(items)){
				return recipes.get(i);
			}
		}
		return null;
	}
	
	public static ItemStack getItemFromComponent(ComponentBase component){
		for (int i = 0; i < components.size(); i ++){
			if (components.get(i).getName() == component.getName()){
				return components.get(i).itemSource;
			}
		}
		return null;
	}
	
	public static ComponentBase getComponentFromName(String name){
		for (int i = 0; i < components.size(); i ++){
			if (components.get(i).getName().equals(name)){
				return components.get(i);
			}
		}
		return null;
	}
	
	public static ComponentBase getComponentFromItem(ItemStack stack){
		for (int i = 0; i < components.size(); i ++){
			if (components.get(i).getItem() != null && stack != null){
				if (components.get(i).getItem().getItem() == stack.getItem()
					&& components.get(i).getItem().getMetadata() == stack.getMetadata()){
					return components.get(i);
				}
			}
		}
		return null;
	}
}
