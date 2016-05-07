package elucent.herbologia.proxy;

import elucent.herbologia.RegistryManager;
import elucent.herbologia.entity.fx.EntityFXMagic;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		super.preInit(event);
	}
	
	public void init(FMLInitializationEvent event){
		super.init(event);
		RegistryManager.registerItemRenderers();
	}
	
	public void postInit(FMLPostInitializationEvent event){
		super.postInit(event);
	}
	
	@Override
	public void spawnParticleMagicFX(World world, double x, double y, double z, double vx, double vy, double vz, double r, double g, double b){
		EntityFXMagic particle = new EntityFXMagic(world,x,y,z,vx,vy,vz,r,g,b);
		Minecraft.getMinecraft().effectRenderer.addEffect(particle);
	}
}
