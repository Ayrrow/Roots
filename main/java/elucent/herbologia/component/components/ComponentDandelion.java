package elucent.herbologia.component.components;

import java.util.ArrayList;
import java.util.Random;

import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.EnumCastType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;


public class ComponentDandelion extends ComponentBase{
	Random rnd = new Random();
	public ComponentDandelion(){
		super("dandelion","Dandelion's Swiftness",Blocks.yellow_flower);
		
	}
	
	/*
	
	TODO: Make a decent blast effect
	
	*/
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		
		if (type == EnumCastType.SPELL){	
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for(int i = 0; i < targets.size();i++){
				targets.get(i).motionY = 1.D;
			}
		}
		if (type == EnumCastType.HEX){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for (int i = 0; i < targets.size(); i ++){
				targets.get(i).motionX = rnd.nextDouble()*(0.5+(0.25*potency));
				targets.get(i).motionY = rnd.nextDouble()*(0.5+(0.25*potency));
				targets.get(i).motionZ = rnd.nextDouble()*(0.5+(0.25*potency));
			}
		}
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for (int i = 0; i < targets.size(); i ++){
				targets.get(i).addPotionEffect(new PotionEffect(Potion.potionRegistry.getObject(new ResourceLocation("minecraft:speed")),2,(int)potency));
				targets.get(i).addPotionEffect(new PotionEffect(Potion.potionRegistry.getObject(new ResourceLocation("minecraft:jump_boost")),2,(int)potency));
			}
		}
	}
}
