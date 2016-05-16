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


public class ComponentWhiteTulip extends ComponentBase{
	Random random = new Random();
	public ComponentWhiteTulip(){
		super("whitetulip","Blistering Cold",Blocks.red_flower,6,3);	
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).getUniqueID() != caster.getUniqueID()){
					targets.get(i).attackEntityFrom(DamageSource.generic, (int)(5+3*potency));
					targets.get(i).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("slowness"),200+100*(int)potency,(int)potency));
					targets.get(i).setLastAttacker(caster);
					targets.get(i).setRevengeTarget((EntityLivingBase)caster);
				}
			}
		}
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-5.5-3.0*size,y-5.5-3.0*size,z-5.5-3.0*size,x+5.5+3.0*size,y+5.5+3.0*size,z+5.5+3.0*size));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).getUniqueID() != caster.getUniqueID()){
					targets.get(i).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("slowness"),40,(int)potency));
				}
			}
		}
	}
	
	@Override
	public void doEffect(World world, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-5.5-3.0*size,y-5.5-3.0*size,z-5.5-3.0*size,x+5.5+3.0*size,y+5.5+3.0*size,z+5.5+3.0*size));
			for (int i = 0; i < targets.size(); i ++){
				targets.get(i).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("slowness"),40,(int)potency));
			}
		}
	}
}
