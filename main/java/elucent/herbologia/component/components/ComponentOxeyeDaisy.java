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
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class ComponentOxeyeDaisy extends ComponentBase{
	Random random = new Random();
	public ComponentOxeyeDaisy(){
		super("oxeyedaisy","Acceleration",Blocks.red_flower,8,8);	
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){	
			if (caster instanceof EntityPlayer && !world.isRemote){
				BlockPos pos = ((EntityPlayer)caster).rayTrace(4+2*size, 0).getBlockPos();
				world.setWorldTime(world.getWorldTime()+100);
				if (world.getTileEntity(pos) != null){
					if (world.getTileEntity(pos) instanceof ITickable){
						for (int i = 0; i < 20; i ++){
							((ITickable)world.getTileEntity(pos)).update();
						}
					}
				}
			}
		}
		if (type == EnumCastType.INCENSE){
			if (random.nextInt(100-25*(int)potency) == 0){
				BlockPos pos = new BlockPos(x+(random.nextDouble()-0.5)*(11.0+6.0*size),0,z+(random.nextDouble()-0.5)*(11.0+6.0*size));
				pos.add(0, random.nextInt(world.getHeight(pos).getY()), 0);
				if (world.getBlockState(pos).getBlock() == Blocks.stone){
					world.setBlockState(pos,Blocks.emerald_block.getDefaultState());
				}
			}
		}
	}
	
	@Override
	public void doEffect(World world, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (random.nextInt(100-25*(int)potency) == 0){
			BlockPos pos = new BlockPos(x+(random.nextDouble()-0.5)*(11.0+6.0*size),0,z+(random.nextDouble()-0.5)*(11.0+6.0*size));
			pos = pos.add(0, random.nextInt(world.getTopSolidOrLiquidBlock(pos).getY()), 0);
			if (world.getBlockState(pos).getBlock() == Blocks.stone){
				world.setBlockState(pos,Blocks.emerald_block.getDefaultState());
			}
		}
	}
}
