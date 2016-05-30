package elucent.roots.ritual;

import java.util.ArrayList;
import java.util.List;

import elucent.roots.RegistryManager;
import elucent.roots.Util;
import elucent.roots.ritual.rituals.RitualCrafting;
import elucent.roots.ritual.rituals.RitualImbuer;
import elucent.roots.ritual.rituals.RitualSummoning;
import elucent.roots.tileentity.TileEntityAltar;
import elucent.roots.tileentity.TileEntityBrazier;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class RitualManager {
	public static ArrayList<RitualBase> rituals = new ArrayList<RitualBase>();
	
	public static void init(){
		rituals.add(new RitualCrafting("staffCrafting", 205, 86, 0)
					.setResult(new ItemStack(RegistryManager.crystalStaff,1))
					.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
					.addIncense(new ItemStack(Blocks.COAL_BLOCK,1))
					.addIncense(new ItemStack(RegistryManager.acaciaTreeBark,1))
					.addIncense(new ItemStack(RegistryManager.verdantSprig,1))
					.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
					.addIngredient(new ItemStack(Blocks.DIAMOND_BLOCK,1))
					.addIngredient(new ItemStack(Items.STICK,1))
					.addIngredient(new ItemStack(Items.BLAZE_POWDER,1)));
		rituals.add(new RitualCrafting("sylvanHoodCrafting", 62, 138, 62)
				.setResult(new ItemStack(RegistryManager.druidRobesHead,1))
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
				.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
				.addIncense(new ItemStack(Items.GOLDEN_APPLE,1))
				.addIncense(new ItemStack(Blocks.RED_FLOWER,1,0))
				.addIngredient(new ItemStack(Items.DIAMOND,1))
				.addIngredient(new ItemStack(Items.LEATHER_HELMET,1))
				.addIngredient(new ItemStack(Blocks.VINE,1)));
		rituals.add(new RitualCrafting("sylvanChestCrafting", 62, 138, 62)
				.setResult(new ItemStack(RegistryManager.druidRobesChest,1))
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
				.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
				.addIncense(new ItemStack(Items.GOLDEN_APPLE,1))
				.addIncense(new ItemStack(Blocks.RED_FLOWER,1,0))
				.addIngredient(new ItemStack(Items.DIAMOND,1))
				.addIngredient(new ItemStack(Items.LEATHER_CHESTPLATE,1))
				.addIngredient(new ItemStack(Blocks.VINE,1)));
		rituals.add(new RitualCrafting("sylvanLegsCrafting", 62, 138, 62)
				.setResult(new ItemStack(RegistryManager.druidRobesLegs,1))
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
				.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
				.addIncense(new ItemStack(Items.GOLDEN_APPLE,1))
				.addIncense(new ItemStack(Blocks.RED_FLOWER,1,0))
				.addIngredient(new ItemStack(Items.DIAMOND,1))
				.addIngredient(new ItemStack(Items.LEATHER_LEGGINGS,1))
				.addIngredient(new ItemStack(Blocks.VINE,1)));
		rituals.add(new RitualCrafting("sylvanBootsCrafting", 62, 138, 62)
				.setResult(new ItemStack(RegistryManager.druidRobesBoots,1))
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
				.addIncense(new ItemStack(RegistryManager.birchTreeBark,1))
				.addIncense(new ItemStack(Items.GOLDEN_APPLE,1))
				.addIncense(new ItemStack(Blocks.RED_FLOWER,1,0))
				.addIngredient(new ItemStack(Items.DIAMOND,1))
				.addIngredient(new ItemStack(Items.LEATHER_BOOTS,1))
				.addIngredient(new ItemStack(Blocks.VINE,1)));
		rituals.add(new RitualCrafting("wildwoodHeadCrafting", 145, 115, 65)
				.setResult(new ItemStack(RegistryManager.druidArmorHead,1))
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
				.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
				.addIncense(new ItemStack(Blocks.WHEAT,1))
				.addIncense(new ItemStack(Blocks.SAPLING,1,0))
				.addIngredient(new ItemStack(Items.DIAMOND,1))
				.addIngredient(new ItemStack(Items.IRON_HELMET,1))
				.addIngredient(new ItemStack(Blocks.PLANKS,1)));
		rituals.add(new RitualCrafting("wildwoodChestCrafting", 145, 115, 65)
				.setResult(new ItemStack(RegistryManager.druidArmorChest,1))
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
				.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
				.addIncense(new ItemStack(Blocks.WHEAT,1))
				.addIncense(new ItemStack(Blocks.SAPLING,1,0))
				.addIngredient(new ItemStack(Items.DIAMOND,1))
				.addIngredient(new ItemStack(Items.IRON_CHESTPLATE,1))
				.addIngredient(new ItemStack(Blocks.PLANKS,1)));
		rituals.add(new RitualCrafting("wildwoodLegsCrafting", 145, 115, 65)
				.setResult(new ItemStack(RegistryManager.druidArmorLegs,1))
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
				.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
				.addIncense(new ItemStack(Blocks.WHEAT,1))
				.addIncense(new ItemStack(Blocks.SAPLING,1,0))
				.addIngredient(new ItemStack(Items.DIAMOND,1))
				.addIngredient(new ItemStack(Items.IRON_LEGGINGS,1))
				.addIngredient(new ItemStack(Blocks.PLANKS,1)));
		rituals.add(new RitualCrafting("wildwoodBootsCrafting", 145, 115, 65)
				.setResult(new ItemStack(RegistryManager.druidArmorBoots,1))
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
				.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
				.addIncense(new ItemStack(Blocks.WHEAT,1))
				.addIncense(new ItemStack(Blocks.SAPLING,1,0))
				.addIngredient(new ItemStack(Items.DIAMOND,1))
				.addIngredient(new ItemStack(Items.IRON_BOOTS,1))
				.addIngredient(new ItemStack(Blocks.PLANKS,1)));
		rituals.add(new RitualCrafting("livingPickaxeCrafting", 146, 214, 43)
					.setResult(new ItemStack(RegistryManager.livingPickaxe,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIngredient(new ItemStack(Items.WOODEN_PICKAXE,1))
					.addIngredient(new ItemStack(RegistryManager.verdantSprig,1))
					.addIngredient(new ItemStack(Items.GOLD_INGOT,1)));
		rituals.add(new RitualCrafting("livingAxeCrafting", 146, 214, 43)
					.setResult(new ItemStack(RegistryManager.livingAxe,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIngredient(new ItemStack(Items.WOODEN_AXE,1))
					.addIngredient(new ItemStack(RegistryManager.verdantSprig,1))
					.addIngredient(new ItemStack(Items.GOLD_INGOT,1)));
		rituals.add(new RitualCrafting("livingSwordCrafting", 146, 214, 43)
					.setResult(new ItemStack(RegistryManager.livingSword,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIngredient(new ItemStack(Items.WOODEN_SWORD,1))
					.addIngredient(new ItemStack(RegistryManager.verdantSprig,1))
					.addIngredient(new ItemStack(Items.GOLD_INGOT,1)));
		rituals.add(new RitualCrafting("livingHoeCrafting", 146, 214, 43)
					.setResult(new ItemStack(RegistryManager.livingHoe,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIngredient(new ItemStack(Items.WOODEN_HOE,1))
					.addIngredient(new ItemStack(RegistryManager.verdantSprig,1))
					.addIngredient(new ItemStack(Items.GOLD_INGOT,1)));
		rituals.add(new RitualCrafting("livingShovelCrafting", 146, 214, 43)
					.setResult(new ItemStack(RegistryManager.livingShovel,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIncense(new ItemStack(RegistryManager.oakTreeBark,1))
					.addIngredient(new ItemStack(Items.WOODEN_SHOVEL,1))
					.addIngredient(new ItemStack(RegistryManager.verdantSprig,1))
					.addIngredient(new ItemStack(Items.GOLD_INGOT,1)));
		rituals.add(new RitualImbuer()
					.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
					.addIngredient(new ItemStack(RegistryManager.crystalStaff,1))
					.addIngredient(new ItemStack(RegistryManager.verdantSprig,1)));
		rituals.add(new RitualSummoning("cowSummoning",199,105,193)
					.setResult(EntityCow.class)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
					.addIncense(new ItemStack(Items.WHEAT_SEEDS,1))
					.addIncense(new ItemStack(Items.NETHER_WART,1))
					.addIngredient(new ItemStack(Items.BEEF,1))
					.addIngredient(new ItemStack(Items.LEATHER,1))
					.addIngredient(new ItemStack(Items.BONE,1)));
		rituals.add(new RitualSummoning("pigSummoning",199,105,193)
					.setResult(EntityPig.class)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
					.addIncense(new ItemStack(Items.WHEAT_SEEDS,1))
					.addIncense(new ItemStack(Items.NETHER_WART,1))
					.addIngredient(new ItemStack(Items.PORKCHOP,1))
					.addIngredient(new ItemStack(Items.PORKCHOP,1))
					.addIngredient(new ItemStack(Items.BONE,1)));
		rituals.add(new RitualSummoning("sheepSummoning",199,105,193)
					.setResult(EntitySheep.class)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
					.addIncense(new ItemStack(Items.WHEAT_SEEDS,1))
					.addIncense(new ItemStack(Items.NETHER_WART,1))
					.addIngredient(new ItemStack(Items.MUTTON,1))
					.addIngredient(new ItemStack(Blocks.WOOL,1))
					.addIngredient(new ItemStack(Items.BONE,1)));
		rituals.add(new RitualSummoning("chickenSummoning",199,105,193)
					.setResult(EntityChicken.class)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
					.addIncense(new ItemStack(Items.WHEAT_SEEDS,1))
					.addIncense(new ItemStack(Items.NETHER_WART,1))
					.addIngredient(new ItemStack(Items.CHICKEN,1))
					.addIngredient(new ItemStack(Items.FEATHER,1))
					.addIngredient(new ItemStack(Items.BONE,1)));
		rituals.add(new RitualSummoning("rabbitSummoning",199,105,193)
					.setResult(EntityRabbit.class)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
					.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
					.addIncense(new ItemStack(Items.WHEAT_SEEDS,1))
					.addIncense(new ItemStack(Items.NETHER_WART,1))
					.addIngredient(new ItemStack(Items.RABBIT,1))
					.addIngredient(new ItemStack(Items.RABBIT_HIDE,1))
					.addIngredient(new ItemStack(Items.BONE,1)));
		rituals.add(new RitualSummoning("zombieSummoning",58,2,84)
				.setResult(EntityZombie.class)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(Items.COAL,1))
				.addIncense(new ItemStack(Items.NETHER_WART,1))
				.addIngredient(new ItemStack(Items.ROTTEN_FLESH,1))
				.addIngredient(new ItemStack(Items.ROTTEN_FLESH,1))
				.addIngredient(new ItemStack(Items.BONE,1)));
	rituals.add(new RitualSummoning("skeletonSummoning",58,2,84)
				.setResult(EntitySkeleton.class)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(Items.COAL,1))
				.addIncense(new ItemStack(Items.NETHER_WART,1))
				.addIngredient(new ItemStack(Items.ARROW,1))
				.addIngredient(new ItemStack(Items.BONE,1))
				.addIngredient(new ItemStack(Items.BONE,1)));
	rituals.add(new RitualSummoning("spiderSummoning",58,2,84)
				.setResult(EntitySpider.class)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(Items.COAL,1))
				.addIncense(new ItemStack(Items.NETHER_WART,1))
				.addIngredient(new ItemStack(Items.STRING,1))
				.addIngredient(new ItemStack(Items.SPIDER_EYE,1))
				.addIngredient(new ItemStack(Items.BONE,1)));
	rituals.add(new RitualSummoning("caveSpiderSummoning",58,2,84)
			.setResult(EntityCaveSpider.class)
			.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
			.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
			.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
			.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
			.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
			.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
			.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
			.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
			.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
			.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
			.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
			.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
			.addIncense(new ItemStack(Items.COAL,1))
			.addIncense(new ItemStack(Items.NETHER_WART,1))
			.addIngredient(new ItemStack(Items.STRING,1))
			.addIngredient(new ItemStack(Items.FERMENTED_SPIDER_EYE,1))
			.addIngredient(new ItemStack(Items.BONE,1)));
	rituals.add(new RitualSummoning("slimeSummoning",58,2,84)
			.setResult(EntitySlime.class)
			.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
			.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
			.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
			.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
			.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
			.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
			.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
			.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
			.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
			.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
			.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
			.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
			.addIncense(new ItemStack(Items.COAL,1))
			.addIncense(new ItemStack(Items.NETHER_WART,1))
			.addIngredient(new ItemStack(Items.SLIME_BALL,1))
			.addIngredient(new ItemStack(Items.SLIME_BALL,1))
			.addIngredient(new ItemStack(Items.SLIME_BALL,1)));
	rituals.add(new RitualSummoning("creeperSummoning",58,2,84)
				.setResult(EntityCreeper.class)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(Items.COAL,1))
				.addIncense(new ItemStack(Items.NETHER_WART,1))
				.addIngredient(new ItemStack(Items.GUNPOWDER,1))
				.addIngredient(new ItemStack(Items.GUNPOWDER,1))
				.addIngredient(new ItemStack(Items.BONE,1)));
	rituals.add(new RitualSummoning("endermanSummoning",58,2,84)
				.setResult(EntityEnderman.class)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, -3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, -3, 0, 0)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, 3)
				.addBlock(RegistryManager.standingStoneT1, 0, 0, -3)
				.addBlock(RegistryManager.standingStoneT2, 5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, -5, 1, 0)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, 5)
				.addBlock(RegistryManager.standingStoneT2, 0, 1, -5)
				.addIncense(new ItemStack(Items.COAL,1))
				.addIncense(new ItemStack(Items.NETHER_WART,1))
				.addIngredient(new ItemStack(Items.ENDER_PEARL,1))
				.addIngredient(new ItemStack(Items.ENDER_PEARL,1))
				.addIngredient(new ItemStack(Items.BONE,1)));
	}
	
	public static RitualBase getRitualFromName(String name){
		for (int i = 0; i < rituals.size(); i ++){
			if (rituals.get(i).name == name){
				return rituals.get(i);
			}
		}
		return null;
	}
	
	public static ArrayList<ItemStack> getIncenses(World world, BlockPos pos){
		ArrayList<ItemStack> test = new ArrayList<ItemStack>();
		for (int i = -4; i < 5; i ++){
			for (int j = -4; j < 5; j ++){
				if (world.getBlockState(pos.add(i,0,j)).getBlock() == RegistryManager.brazier){
					if (world.getTileEntity(pos.add(i,0,j)) != null){
						TileEntityBrazier teb = (TileEntityBrazier)world.getTileEntity(pos.add(i,0,j));
						if (teb.burning){
							test.add(teb.heldItem);
						}
					}
				}
			}
		}
		return test;
	}
}