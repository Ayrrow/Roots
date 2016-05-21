package elucent.herbologia.component.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import elucent.herbologia.PlayerManager;
import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.ComponentEffect;
import elucent.herbologia.component.EnumCastType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
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


public class ComponentAllium extends ComponentBase{
	Random random = new Random();
	public ComponentAllium(){
		super("allium","Allium's Chaos",Blocks.red_flower,2);	
	}
	
	public void destroyBlockSafe(World world, BlockPos pos, int potency){
		if (world.getBlockState(pos).getBlock().getHarvestLevel(world.getBlockState(pos)) <= 2+potency && world.getBlockState(pos).getBlock().getBlockHardness(world.getBlockState(pos), world, pos) != -1){
			world.destroyBlock(pos, true);
		}
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).getUniqueID() != caster.getUniqueID()){
					targets.get(i).attackEntityFrom(DamageSource.generic, (int)(3+2*potency));
					targets.get(i).setLastAttacker(caster);
					targets.get(i).setRevengeTarget((EntityLivingBase)caster);
					List<ItemStack> equipment = Lists.newArrayList(targets.get(i).getEquipmentAndArmor());
					for (int j = 0; j < equipment.size(); j ++){
						if (equipment.get(j) != null){
							if (equipment.get(j).isItemStackDamageable()){
								equipment.get(j).damageItem((int)(random.nextInt(16+8*(int)potency)+8+4*potency), targets.get(i));
							}
						}
					}
				}
			}
		}
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityPlayer> targets = (ArrayList<EntityPlayer>) world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(x-11.0-6.0*size,y-11.0-6.0*size,z-11.0-6.0*size,x+11.0+6.0*size,y+11.0+6.0*size,z+11.0+6.0*size));
			for (int i = 0; i < targets.size(); i ++){
				if (random.nextInt(10) == 0){
					PlayerManager.addEffect(new ComponentEffect("allium",40,targets.get(i)));
				}
			}
		}
	}
	
	@Override
	public void doEffect(World world, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityPlayer> targets = (ArrayList<EntityPlayer>) world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(x-11.0-6.0*size,y-11.0-6.0*size,z-11.0-6.0*size,x+11.0+6.0*size,y+11.0+6.0*size,z+11.0+6.0*size));
			for (int i = 0; i < targets.size(); i ++){
				PlayerManager.addEffect(new ComponentEffect(this.getName(), 22, targets.get(i)));
			}
		}
	}
}
