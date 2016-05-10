package elucent.herbologia.component.components;

import java.util.ArrayList;
import java.util.Random;

import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.EnumCastType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class ComponentAzureBluet extends ComponentBase{
	Random random = new Random();
	public ComponentAzureBluet(){
		super("azurebluet","Shatter",Blocks.red_flower,3);	
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
				BlockPos pos = ((EntityPlayer)caster).rayTrace(size, 0).getBlockPos();
				destroyBlockSafe(world, pos, (int)potency);
				if (random.nextBoolean()){
					destroyBlockSafe(world, pos.up(), (int)potency);
				}
				if (random.nextBoolean()){
					destroyBlockSafe(world, pos.down(), (int)potency);
				}
				if (random.nextBoolean()){
					destroyBlockSafe(world, pos.east(), (int)potency);
				}
				if (random.nextBoolean()){
					destroyBlockSafe(world, pos.west(), (int)potency);
				}
				if (random.nextBoolean()){
					destroyBlockSafe(world, pos.north(), (int)potency);
				}
				if (random.nextBoolean()){
					destroyBlockSafe(world, pos.south(), (int)potency);
				}
			}
		}
		if (type == EnumCastType.HEX){		
			//TODO: ADD RANDOM INSTANT BREAK
		}
		if (type == EnumCastType.INCENSE){
			//TODO: ADD RANDOM INSTANT BREAK
		}
	}
}
