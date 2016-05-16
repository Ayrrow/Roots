package elucent.herbologia.component.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import elucent.herbologia.PlayerManager;
import elucent.herbologia.Util;
import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.ComponentEffect;
import elucent.herbologia.component.EnumCastType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockFlower.EnumFlowerType;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class ComponentLilyPad extends ComponentBase{
	Random random = new Random();
	public ComponentLilyPad(){
		super("lilypad","Aqueous Burst",Blocks.waterlily,2);	
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){	
			if (caster instanceof EntityPlayer && !world.isRemote){
				BlockPos pos = ((EntityPlayer)caster).rayTrace(4+2*size, 0).getBlockPos();
				if (world.getBlockState(pos.up()).getBlock() == Blocks.air || world.getBlockState(pos.up()).getBlock() == Blocks.tallgrass || world.getBlockState(pos.up()).getBlock() == Blocks.flowing_water){
					world.setBlockState(pos.up(), Blocks.flowing_water.getDefaultState().withProperty(BlockLiquid.LEVEL, 15),3);
					world.setBlockState(pos.up().west(), Blocks.flowing_water.getDefaultState().withProperty(BlockLiquid.LEVEL, 15),3);
					world.setBlockState(pos.up().east(), Blocks.flowing_water.getDefaultState().withProperty(BlockLiquid.LEVEL, 15),3);
					world.setBlockState(pos.up().north(), Blocks.flowing_water.getDefaultState().withProperty(BlockLiquid.LEVEL, 15),3);
					world.setBlockState(pos.up().south(), Blocks.flowing_water.getDefaultState().withProperty(BlockLiquid.LEVEL, 15),3);
				}
			}
		}
	}
}
