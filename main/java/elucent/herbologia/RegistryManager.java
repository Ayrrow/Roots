package elucent.herbologia;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import elucent.herbologia.block.BlockMortar;
import elucent.herbologia.item.DustPetal;
import elucent.herbologia.item.ItemPestle;
import elucent.herbologia.tileentity.TileEntityMortar;
import elucent.herbologia.tileentity.TileEntityMortarRenderer;

public class RegistryManager {
	public static Item dustPetal, pestle;
	public static Block mortar;
	
	public static void init(){
		/**
		 * REGISTERING ITEMS
		 */
		GameRegistry.registerItem(dustPetal = new DustPetal(), "dustPetal");
		GameRegistry.registerItem(pestle = new ItemPestle(), "pestle");
		
		/**
		 * REGISTERING BLOCKS
		 */
		GameRegistry.registerBlock(mortar = new BlockMortar(), "mortar");
		
		/**
		 * REGISTERING TILE ENTITIES
		 */
		GameRegistry.registerTileEntity(TileEntityMortar.class, "TileEntityMortar");
	}
	
	public static void registerRecipes(){
		
	}
	
	public static void registerItemRenderers(){
		/**
		 * REGISTERING TILE ENTITY RENDERERS
		 */
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMortar.class, new TileEntityMortarRenderer());
		
		/**
		 * REGISTERING ITEM MODELS
		 */
		((DustPetal)dustPetal).initModel();
		((ItemPestle)pestle).initModel();
		((BlockMortar)mortar).initModel();
	}
}
