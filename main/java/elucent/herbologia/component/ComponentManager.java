package elucent.herbologia.component;

import java.util.ArrayList;

import com.mojang.realmsclient.gui.ChatFormatting;

import elucent.herbologia.component.components.ComponentRose;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ComponentManager {
	public static ArrayList<ComponentBase> components = new ArrayList<ComponentBase>();
	
	public static void init(){
		components.add(new ComponentRose().setPrimaryColor(192, 0, 72).setSecondaryColor(0, 200, 48).setTextColor(ChatFormatting.GREEN));
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
