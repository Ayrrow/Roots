package elucent.herbologia;

import elucent.herbologia.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Herbologia.MODID, name = Herbologia.NAME, version = Herbologia.VERSION)
public class Herbologia
{
	public static final String NAME = "Herbologia";
    public static final String MODID = "herbologia";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "elucent.herbologia.proxy.ClientProxy", serverSide = "elucent.herbologia.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(new EventManager());
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	proxy.init(event);
    }
}
