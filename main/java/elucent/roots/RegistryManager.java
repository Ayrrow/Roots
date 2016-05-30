package elucent.roots;

import elucent.roots.block.BlockAltar;
import elucent.roots.block.BlockBrazier;
import elucent.roots.block.BlockDruidChalice;
import elucent.roots.block.BlockImbuer;
import elucent.roots.block.BlockMortar;
import elucent.roots.block.BlockStandingStoneT1;
import elucent.roots.block.BlockStandingStoneT2;
import elucent.roots.item.DustPetal;
import elucent.roots.item.ItemCrystalStaff;
import elucent.roots.item.ItemDruidArmor;
import elucent.roots.item.ItemDruidKnife;
import elucent.roots.item.ItemDruidRobes;
import elucent.roots.item.ItemLivingAxe;
import elucent.roots.item.ItemLivingHoe;
import elucent.roots.item.ItemLivingPickaxe;
import elucent.roots.item.ItemLivingShovel;
import elucent.roots.item.ItemLivingSword;
import elucent.roots.item.ItemMaterial;
import elucent.roots.item.ItemPestle;
import elucent.roots.item.ItemStaff;
import elucent.roots.item.ItemTreeBark;
import elucent.roots.tileentity.TileEntityAltar;
import elucent.roots.tileentity.TileEntityAltarRenderer;
import elucent.roots.tileentity.TileEntityBrazier;
import elucent.roots.tileentity.TileEntityBrazierRenderer;
import elucent.roots.tileentity.TileEntityDruidChalice;
import elucent.roots.tileentity.TileEntityImbuer;
import elucent.roots.tileentity.TileEntityImbuerRenderer;
import elucent.roots.tileentity.TileEntityMortar;
import elucent.roots.tileentity.TileEntityMortarRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RegistryManager {
	public static Item druidArmorHead, druidArmorChest, druidArmorLegs, druidArmorBoots, druidRobesHead, druidRobesChest, druidRobesLegs, druidRobesBoots, livingPickaxe, livingSword, livingHoe, livingAxe, livingShovel, dustPetal, pestle, staff, oldRoot, crystalStaff, verdantSprig, infernalStem, dragonsEye,druidKnife,oakTreeBark,spruceTreeBark,birchTreeBark,jungleTreeBark,acaciaTreeBark,darkOakTreeBark;
	public static Block mortar, imbuer, altar, druidChalice, standingStoneT1, standingStoneT2, brazier;
	
	public static ToolMaterial livingMaterial = EnumHelper.addToolMaterial("livingMaterial", 2, 192, 6.0f, 2.0f, 18);
	public static ArmorMaterial druidRobesMaterial = EnumHelper.addArmorMaterial("druidRobes", "roots:druidRobes", 10, new int[]{1,5,6,2}, 20, null, 0);
	public static ArmorMaterial druidArmorMaterial = EnumHelper.addArmorMaterial("druidArmor", "roots:druidArmor", 15, new int[]{2,5,7,3}, 10, null, 1.0f);
	
	public static void init(){
		/**
		 * REGISTERING ITEMS
		 */
		GameRegistry.registerItem(druidKnife = new ItemDruidKnife(), "druidKnife");
		GameRegistry.registerItem(dustPetal = new DustPetal(), "dustPetal");
		GameRegistry.registerItem(pestle = new ItemPestle(), "pestle");
		GameRegistry.registerItem(staff = new ItemStaff(), "staff");
		GameRegistry.registerItem(crystalStaff = new ItemCrystalStaff(), "crystalStaff");
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
		GameRegistry.registerItem(livingPickaxe = new ItemLivingPickaxe(),"livingPickaxe");
		GameRegistry.registerItem(livingAxe = new ItemLivingAxe(),"livingAxe");
		GameRegistry.registerItem(livingSword = new ItemLivingSword(),"livingSword");
		GameRegistry.registerItem(livingHoe = new ItemLivingHoe(),"livingHoe");
		GameRegistry.registerItem(livingShovel = new ItemLivingShovel(),"livingShovel");
		GameRegistry.registerItem(druidRobesHead = new ItemDruidRobes(2, EntityEquipmentSlot.HEAD),"druidRobesHead");
		GameRegistry.registerItem(druidRobesChest = new ItemDruidRobes(6, EntityEquipmentSlot.CHEST),"druidRobesChest");
		GameRegistry.registerItem(druidRobesLegs = new ItemDruidRobes(5, EntityEquipmentSlot.LEGS),"druidRobesLegs");
		GameRegistry.registerItem(druidRobesBoots = new ItemDruidRobes(1, EntityEquipmentSlot.FEET),"druidRobesBoots");
		GameRegistry.registerItem(druidArmorHead = new ItemDruidArmor(3, EntityEquipmentSlot.HEAD),"druidArmorHead");
		GameRegistry.registerItem(druidArmorChest = new ItemDruidArmor(7, EntityEquipmentSlot.CHEST),"druidArmorChest");
		GameRegistry.registerItem(druidArmorLegs = new ItemDruidArmor(6, EntityEquipmentSlot.LEGS),"druidArmorLegs");
		GameRegistry.registerItem(druidArmorBoots = new ItemDruidArmor(2, EntityEquipmentSlot.FEET),"druidArmorBoots");
		
		/**
		 * REGISTERING BLOCKS
		 */
		GameRegistry.registerBlock(mortar = new BlockMortar(), "mortar");
		GameRegistry.registerBlock(altar = new BlockAltar(), "altar");
		GameRegistry.registerBlock(brazier = new BlockBrazier(), "brazier");
		GameRegistry.registerBlock(imbuer = new BlockImbuer(), "imbuer");
		GameRegistry.registerBlock(druidChalice = new BlockDruidChalice(),"druidChalice");
		GameRegistry.registerBlock(standingStoneT1 = new BlockStandingStoneT1(),"standingStoneT1");
		GameRegistry.registerBlock(standingStoneT2 = new BlockStandingStoneT2(),"standingStoneT2");
		
		/**
		 * REGISTERING TILE ENTITIES
		 */
		GameRegistry.registerTileEntity(TileEntityMortar.class, "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityImbuer.class, "TileEntityImbuer");
		GameRegistry.registerTileEntity(TileEntityAltar.class, "TileEntityAltar");
		GameRegistry.registerTileEntity(TileEntityDruidChalice.class,"TileEntityDruidChalice");
		GameRegistry.registerTileEntity(TileEntityBrazier.class,"TileEntityBrazier");
	}
	
	public static void registerRecipes(){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.pestle,1),true,new Object[]{"X  "," XX", " XX", 'X', new ItemStack(Blocks.STONE,1,3)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.pestle,1),true,new Object[]{"  X","XX ", "XX ", 'X', new ItemStack(Blocks.STONE,1,3)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.mortar,1),true,new Object[]{"X X","X X", " X ", 'X', "stone"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.imbuer,1),true,new Object[]{"X X", "LSL", 'X', "stickWood", 'L', "logWood", 'S', new ItemStack(Blocks.STONEBRICK,1,3)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.standingStoneT1,1), true, new Object[]{"SBS","BLB","SBS",'S',"stone",'B',new ItemStack(Blocks.STONEBRICK,1,3),'L',"blockLapis"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.standingStoneT2,1), true, new Object[]{"SNS","NDN","SNS",'S',"stone",'N',"ingotBrickNether",'D',"gemDiamond"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.brazier,1), true, new Object[]{"SXS","ICI","I I",'I',"ingotIron",'S',"string",'C',Items.CAULDRON,'X',"stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.altar,1), true, new Object[]{"BFB","SGS"," C ",'S',"stone",'F',new ItemStack(Blocks.RED_FLOWER,1,0),'B',RegistryManager.verdantSprig,'G',"blockGold",'C',new ItemStack(Blocks.STONEBRICK,1,3)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RegistryManager.druidKnife,1), true, new Object[]{" VV","VPV","SV ",'S',"stickWood",'V',"treeLeaves",'P',"plankWood"}));
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemRenderers(){
		/**
		 * REGISTERING TILE ENTITY RENDERERS
		 */
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMortar.class, new TileEntityMortarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new TileEntityAltarRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityImbuer.class, new TileEntityImbuerRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBrazier.class, new TileEntityBrazierRenderer());
		
		/**
		 * REGISTERING ITEM MODELS
		 */
		((ItemDruidKnife)druidKnife).initModel();
		((DustPetal)dustPetal).initModel();
		((ItemPestle)pestle).initModel();
		((ItemStaff)staff).initModel();
		((ItemCrystalStaff)crystalStaff).initModel();
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
		((ItemLivingPickaxe)livingPickaxe).initModel();
		((ItemLivingAxe)livingAxe).initModel();
		((ItemLivingSword)livingSword).initModel();
		((ItemLivingHoe)livingHoe).initModel();
		((ItemLivingShovel)livingShovel).initModel();
		((ItemDruidRobes)druidRobesHead).initModel();
		((ItemDruidRobes)druidRobesChest).initModel();
		((ItemDruidRobes)druidRobesLegs).initModel();
		((ItemDruidRobes)druidRobesBoots).initModel();
		((ItemDruidArmor)druidArmorHead).initModel();
		((ItemDruidArmor)druidArmorChest).initModel();
		((ItemDruidArmor)druidArmorLegs).initModel();
		((ItemDruidArmor)druidArmorBoots).initModel();
		
		((BlockDruidChalice)druidChalice).initModel();
		((BlockMortar)mortar).initModel();
		((BlockAltar)altar).initModel();
		((BlockBrazier)brazier).initModel();
		((BlockImbuer)imbuer).initModel();
		((BlockStandingStoneT1)standingStoneT1).initModel();
		((BlockStandingStoneT2)standingStoneT2).initModel();
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerColorHandlers(){
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemStaff.ColorHandler(), staff);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemCrystalStaff.ColorHandler(), crystalStaff);
	}
}
