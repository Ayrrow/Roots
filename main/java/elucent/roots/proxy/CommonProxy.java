package elucent.roots.proxy;

import elucent.roots.RegistryManager;
import elucent.roots.Util;
import elucent.roots.component.ComponentManager;
import elucent.roots.ritual.RitualManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		RegistryManager.init();
		RegistryManager.registerRecipes();
	}
	
	public void init(FMLInitializationEvent event){
		ComponentManager.init();
		RitualManager.init();
	}
	
	public void postInit(FMLPostInitializationEvent event){
		Util.initOres();
		Util.initNaturalBlocks();
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
