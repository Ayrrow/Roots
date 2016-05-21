package elucent.herbologia;

import elucent.herbologia.block.BlockDruidChalice;
import elucent.herbologia.block.BlockImbuer;
import elucent.herbologia.block.BlockMortar;
import elucent.herbologia.block.BlockPouch;
import elucent.herbologia.item.DustPetal;
import elucent.herbologia.item.ItemDruidKnife;
import elucent.herbologia.item.ItemMaterial;
import elucent.herbologia.item.ItemPestle;
import elucent.herbologia.item.ItemStaff;
import elucent.herbologia.item.ItemTreeBark;
import elucent.herbologia.tileentity.TileEntityDruidChalice;
import elucent.herbologia.tileentity.TileEntityImbuer;
import elucent.herbologia.tileentity.TileEntityImbuerRenderer;
import elucent.herbologia.tileentity.TileEntityMortar;
import elucent.herbologia.tileentity.TileEntityMortarRenderer;
import elucent.herbologia.tileentity.TileEntityPouch;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryManager {
	public static Item dustPetal, pestle, staff, oldRoot, verdantSprig, infernalStem, dragonsEye,druidKnife,oakTreeBark,spruceTreeBark,birchTreeBark,jungleTreeBark,acaciaTreeBark,darkOakTreeBark;
	public static Block mortar, imbuer, pouch,druidChalice;
	
	public static void init(){
		/**
		 * REGISTERING ITEMS
		 */
		GameRegistry.registerItem(druidKnife = new ItemDruidKnife(), "druidKnife");
		GameRegistry.registerItem(dustPetal = new DustPetal(), "dustPetal");
		GameRegistry.registerItem(pestle = new ItemPestle(), "pestle");
		GameRegistry.registerItem(staff = new ItemStaff(), "staff");
		GameRegistry.registerItem(oldRoot = new ItemMaterial("oldRoot"), "oldRoot");
		GameRegistry.registerItem(verdantSprig = new ItemMaterial("verdantSprig"), "verdantSprig");
		GameRegistry.registerItem(infernalStem = new ItemMaterial("infernalStem"), "infernalStem");
		GameRegistry.registerItem(dragonsEye = new ItemMaterial("dragonsEye"), "dragonsEye");
		GameRegistry.registerItem(oakTreeBark = new ItemTreeBark("oakTreeBark"),"oakTreeBark");
		GameRegistry.registerItem(spruceTreeBark = new ItemTreeBark("spruceTreeBark"),"spruceTreeBark");
		GameRegistry.registerItem(birchTreeBark = new ItemTreeBark("birchTreeBark"),"birchTreeBark");
		GameRegistry.registerItem(jungleTreeBark = new ItemTreeBark("jungleTreeBark"),"jungleTreeBark");
		GameRegistry.registerItem(acaciaTreeBark = new ItemTreeBark("acaciaTreeBark"),"acaciaTreeBark");
		GameRegistry.registerItem(darkOakTreeBark = new ItemTreeBark("darkOakTreeBark"),"darkOakTreeBark");
		
		/**
		 * REGISTERING BLOCKS
		 */
		GameRegistry.registerBlock(mortar = new BlockMortar(), "mortar");
		GameRegistry.registerBlock(imbuer = new BlockImbuer(), "imbuer");
		GameRegistry.registerBlock(pouch = new BlockPouch(), "pouch");
		GameRegistry.registerBlock(druidChalice = new BlockDruidChalice(),"druidChalice");
		
		/**
		 * REGISTERING TILE ENTITIES
		 */
		GameRegistry.registerTileEntity(TileEntityMortar.class, "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityImbuer.class, "TileEntityImbuer");
		GameRegistry.registerTileEntity(TileEntityPouch.class, "TileEntityPouch");
		GameRegistry.registerTileEntity(TileEntityDruidChalice.class,"TileEntityDruidChalice");
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
		((ItemDruidKnife)druidKnife).initModel();
		((DustPetal)dustPetal).initModel();
		((ItemPestle)pestle).initModel();
		((ItemStaff)staff).initModel();
		((ItemMaterial)oldRoot).initModel();
		((ItemMaterial)verdantSprig).initModel();
		((ItemMaterial)infernalStem).initModel();
		((ItemMaterial)dragonsEye).initModel();
		((ItemTreeBark)oakTreeBark).initModel();
		((ItemTreeBark)spruceTreeBark).initModel();
		((ItemTreeBark)birchTreeBark).initModel();
		((ItemTreeBark)jungleTreeBark).initModel();
		((ItemTreeBark)acaciaTreeBark).initModel();
		((ItemTreeBark)darkOakTreeBark).initModel();
		
		((BlockDruidChalice)druidChalice).initModel();
		((BlockMortar)mortar).initModel();
		((BlockImbuer)imbuer).initModel();
		((BlockPouch)pouch).initModel();
	}
	
	public static void registerColorHandlers(){
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemStaff.ColorHandler(), staff);
	}
}
