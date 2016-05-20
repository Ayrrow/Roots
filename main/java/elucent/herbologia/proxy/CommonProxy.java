package elucent.herbologia.proxy;

import elucent.herbologia.RegistryManager;
import elucent.herbologia.component.ComponentManager;
import elucent.herbologia.ritual.RitualManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		RegistryManager.init();
	}
	
	public void init(FMLInitializationEvent event){
		ComponentManager.init();
		RitualManager.init();
	}
	
	public void postInit(FMLPostInitializationEvent event){
		//
	}
	
	public void spawnParticleMagicFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b){
		//
	}
	
	public void spawnParticleMagicLineFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b){
		//
	}
	
	public void spawnParticleMagicAltarLineFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b){
		//
	}
	
	public void spawnParticleMagicAltarFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b){
		//
	}
}
