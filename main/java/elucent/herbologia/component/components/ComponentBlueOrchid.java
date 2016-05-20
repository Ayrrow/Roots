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
import net.minecraft.block.BlockFlower.EnumFlowerType;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class ComponentBlueOrchid extends ComponentBase{
	Random random = new Random();
	public ComponentBlueOrchid(){
		super("blueorchid","Earthen Roots",Blocks.red_flower,8);	
	}
	
	public void destroyBlockSafe(World world, BlockPos pos, int potency){
		if (world.getBlockState(pos).getBlock().getHarvestLevel(world.getBlockState(pos)) <= 2+potency && world.getBlockState(pos).getBlock().getBlockHardness(world.getBlockState(pos), world, pos) != -1){
			world.destroyBlock(pos, true);
		}
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){	
			if (caster instanceof EntityPlayer && !world.isRemote){
				BlockPos pos = ((EntityPlayer)caster).rayTrace(4+2*size, 0).getBlockPos();
				ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(pos.getX()-size,pos.getY()-size,pos.getZ()-size,pos.getX()+size,pos.getY()+size,pos.getZ()+size));
				for (int i = 0; i < targets.size(); i ++){
					if (targets.get(i).getUniqueID() != caster.getUniqueID()){
						targets.get(i).moveEntity(0, 3, 0);
						targets.get(i).motionY = 0.65+random.nextDouble()+0.25*potency;
					}
				}
				IBlockState state = world.getBlockState(pos);
				Block block = world.getBlockState(pos).getBlock();
				if (block == Blocks.stone || block == Blocks.dirt || block == Blocks.grass || block == Blocks.sand || block == Blocks.gravel){
					if (block == Blocks.grass){
						state = Blocks.dirt.getDefaultState();
						world.setBlockState(pos, state);
					}
					world.setBlockState(pos.up(), state);
					if (random.nextInt(3) == 0){
						world.setBlockState(pos.up().west().north(), state);
					}
					if (random.nextInt(3) == 0){
						world.setBlockState(pos.up().east().south(), state);
					}
					if (random.nextInt(3) == 0){
						world.setBlockState(pos.up().north().east(), state);
					}
					if (random.nextInt(3) == 0){
						world.setBlockState(pos.up().south().west(), state);
					}
					if (random.nextInt(1) == 0){
						world.setBlockState(pos.up().west(), state);
					}
					if (random.nextInt(1) == 0){
						world.setBlockState(pos.up().east(), state);
					}
					if (random.nextInt(1) == 0){
						world.setBlockState(pos.up().north(), state);
					}
					if (random.nextInt(1) == 0){
						world.setBlockState(pos.up().south(), state);
					}
					world.setBlockState(pos.up().up(), state);
					if (random.nextInt(3) == 0){
						world.setBlockState(pos.up().up().west(), state);
					}
					if (random.nextInt(3) == 0){
						world.setBlockState(pos.up().up().east(), state);
					}
					if (random.nextInt(3) == 0){
						world.setBlockState(pos.up().up().north(), state);
					}
					if (random.nextInt(3) == 0){
						world.setBlockState(pos.up().up().south(), state);
					}
					world.setBlockState(pos.up().up().up(), state);
				}
			}
		}
	}
}