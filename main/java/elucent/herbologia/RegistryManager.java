package elucent.herbologia;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import elucent.herbologia.block.BlockImbuer;
import elucent.herbologia.block.BlockMortar;
import elucent.herbologia.block.BlockPouch;
import elucent.herbologia.item.DustPetal;
import elucent.herbologia.item.ItemMaterial;
import elucent.herbologia.item.ItemPestle;
import elucent.herbologia.item.ItemStaff;
import elucent.herbologia.tileentity.TileEntityImbuer;
import elucent.herbologia.tileentity.TileEntityImbuerRenderer;
import elucent.herbologia.tileentity.TileEntityMortar;
import elucent.herbologia.tileentity.TileEntityMortarRenderer;
import elucent.herbologia.tileentity.TileEntityPouch;

public class RegistryManager {
	public static Item dustPetal, pestle, staff, oldRoot, verdantSprig, infernalStem, dragonsEye;
	public static Block mortar, imbuer, pouch;
	
	public static void init(){
		/**
		 * REGISTERING ITEMS
		 */
		GameRegistry.registerItem(dustPetal = new DustPetal(), "dustPetal");
		GameRegistry.registerItem(pestle = new ItemPestle(), "pestle");
		GameRegistry.registerItem(staff = new ItemStaff(), "staff");
		GameRegistry.registerItem(oldRoot = new ItemMaterial("oldRoot"), "oldRoot");
		GameRegistry.registerItem(verdantSprig = new ItemMaterial("verdantSprig"), "verdantSprig");
		GameRegistry.registerItem(infernalStem = new ItemMaterial("infernalStem"), "infernalStem");
		GameRegistry.registerItem(dragonsEye = new ItemMaterial("dragonsEye"), "dragonsEye");
		
		/**
		 * REGISTERING BLOCKS
		 */
		GameRegistry.registerBlock(mortar = new BlockMortar(), "mortar");
		GameRegistry.registerBlock(imbuer = new BlockImbuer(), "imbuer");
		GameRegistry.registerBlock(pouch = new BlockPouch(), "pouch");
		
		/**
		 * REGISTERING TILE ENTITIES
		 */
		GameRegistry.registerTileEntity(TileEntityMortar.class, "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityImbuer.class, "TileEntityImbuer");
		GameRegistry.registerTileEntity(TileEntityPouch.class, "TileEntityPouch");
	}
	
	public static void registerRecipes(){
		
	}
	
	public static void registerItemRenderers(){
		/**
		 * REGISTERING TILE ENTITY RENDERERS
		 */
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMortar.class, new TileEntityMortarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityImbuer.class, new TileEntityImbuerRenderer());
		
		/**
		 * REGISTERING ITEM MODELS
		 */
		((DustPetal)dustPetal).initModel();
		((ItemPestle)pestle).initModel();
		((ItemStaff)staff).initModel();
		((ItemMaterial)oldRoot).initModel();
		((ItemMaterial)verdantSprig).initModel();
		((ItemMaterial)infernalStem).initModel();
		((ItemMaterial)dragonsEye).initModel();
		
		((BlockMortar)mortar).initModel();
		((BlockImbuer)imbuer).initModel();
		((BlockPouch)pouch).initModel();
	}
	
	public static void registerColorHandlers(){
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemStaff.ColorHandler(), staff);
	}
}
