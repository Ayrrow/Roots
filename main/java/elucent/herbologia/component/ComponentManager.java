package elucent.herbologia.component;

import java.util.ArrayList;

import com.mojang.realmsclient.gui.ChatFormatting;

import elucent.herbologia.component.components.ComponentAllium;
import elucent.herbologia.component.components.ComponentAzureBluet;
import elucent.herbologia.component.components.ComponentChorus;
import elucent.herbologia.component.components.ComponentDandelion;
import elucent.herbologia.component.components.ComponentLilac;
import elucent.herbologia.component.components.ComponentNetherWart;
import elucent.herbologia.component.components.ComponentPeony;
import elucent.herbologia.component.components.ComponentRose;
import elucent.herbologia.component.components.ComponentSunflower;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ComponentManager {
	public static ArrayList<ComponentBase> components = new ArrayList<ComponentBase>();
	
	public static void init(){
		components.add(new ComponentRose().setPrimaryColor(192, 0, 72).setSecondaryColor(0, 200, 48).setTextColor(ChatFormatting.GREEN));
		components.add(new ComponentDandelion().setPrimaryColor(255,217,102).setSecondaryColor(240,159,10).setTextColor(ChatFormatting.YELLOW));
		components.add(new ComponentChorus().setPrimaryColor(95,57,95).setSecondaryColor(225,215,225).setTextColor(ChatFormatting.DARK_PURPLE));
		components.add(new ComponentNetherWart().setPrimaryColor(255,76,36).setSecondaryColor(255,174,0).setTextColor(ChatFormatting.GOLD));
		components.add(new ComponentPeony().setPrimaryColor(255,102,178).setSecondaryColor(255,51,153).setTextColor(ChatFormatting.DARK_PURPLE));
		components.add(new ComponentSunflower().setPrimaryColor(255,255,128).setSecondaryColor(255,255,255).setTextColor(ChatFormatting.WHITE));
		components.add(new ComponentLilac().setPrimaryColor(112,80,112).setSecondaryColor(0,112,24).setTextColor(ChatFormatting.GREEN));
		components.add(new ComponentAzureBluet().setPrimaryColor(240,240,255).setSecondaryColor(86,86,96).setTextColor(ChatFormatting.GRAY));
		components.add(new ComponentAllium().setPrimaryColor(129,109,65).setSecondaryColor(153,51,0).setTextColor(ChatFormatting.DARK_PURPLE));
		
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
