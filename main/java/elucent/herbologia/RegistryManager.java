package elucent.herbologia;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import elucent.herbologia.block.BlockImbuer;
import elucent.herbologia.block.BlockMortar;
import elucent.herbologia.item.DustPetal;
import elucent.herbologia.item.ItemMaterial;
import elucent.herbologia.item.ItemPestle;
import elucent.herbologia.item.ItemStaff;
import elucent.herbologia.tileentity.TileEntityImbuer;
import elucent.herbologia.tileentity.TileEntityImbuerRenderer;
import elucent.herbologia.tileentity.TileEntityMortar;
import elucent.herbologia.tileentity.TileEntityMortarRenderer;

public class RegistryManager {
	public static Item dustPetal, pestle, staff, dustVerdant, dustCerulean, dustChthonic;
	public static Block mortar, imbuer;
	
	public static void init(){
		/**
		 * REGISTERING ITEMS
		 */
		GameRegistry.registerItem(dustPetal = new DustPetal(), "dustPetal");
		GameRegistry.registerItem(pestle = new ItemPestle(), "pestle");
		GameRegistry.registerItem(staff = new ItemStaff(), "staff");
		GameRegistry.registerItem(dustVerdant = new ItemMaterial("dustVerdant"), "dustVerdant");
		GameRegistry.registerItem(dustCerulean = new ItemMaterial("dustCerulean"), "dustCerulean");
		GameRegistry.registerItem(dustChthonic = new ItemMaterial("dustChthonic"), "dustChthonic");
		
		/**
		 * REGISTERING BLOCKS
		 */
		GameRegistry.registerBlock(mortar = new BlockMortar(), "mortar");
		GameRegistry.registerBlock(imbuer = new BlockImbuer(), "imbuer");
		
		/**
		 * REGISTERING TILE ENTITIES
		 */
		GameRegistry.registerTileEntity(TileEntityMortar.class, "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityImbuer.class, "TileEntityImbuer");
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
		((ItemMaterial)dustVerdant).initModel();
		((ItemMaterial)dustCerulean).initModel();
		((ItemMaterial)dustChthonic).initModel();
		
		((BlockMortar)mortar).initModel();
		((BlockImbuer)imbuer).initModel();
	}
	
	public static void registerColorHandlers(){
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemStaff.ColorHandler(), staff);
	}
}
