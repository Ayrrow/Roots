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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;


public class ComponentDandelion extends ComponentBase{
	Random rnd = new Random();
	public ComponentDandelion(){
		super("dandelion","Dandelion Winds",Blocks.yellow_flower,2);
		
	}
	
	/*
	
	TODO: Make a decent blast effect
	
	*/
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){	
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for(int i = 0; i < targets.size();i++){
				if(targets.get(i).getUniqueID() != caster.getUniqueID()){
					targets.get(i).motionX = caster.getLookVec().xCoord;
					targets.get(i).motionY = (float)(potency==0?1.0:1.0+0.5*potency);
					targets.get(i).motionZ = caster.getLookVec().zCoord;
				}
			}
		}
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityPlayer> targets = (ArrayList<EntityPlayer>) world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(x-5.5-3.0*size,y-5.5-3.0*size,z-5.5-3.0*size,x+5.5+3.0*size,y+5.5+3.0*size,z+5.5+3.0*size));
			for (int i = 0; i < targets.size(); i ++){
				targets.get(i).addPotionEffect(new PotionEffect(Potion.potionRegistry.getObject(new ResourceLocation("minecraft:speed")),40,(int)potency));
				targets.get(i).addPotionEffect(new PotionEffect(Potion.potionRegistry.getObject(new ResourceLocation("minecraft:jump_boost")),40,(int)potency));
			}
		}
	}
	
	@Override
	public void doEffect(World world, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityPlayer> targets = (ArrayList<EntityPlayer>) world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(x-5.5-3.0*size,y-5.5-3.0*size,z-5.5-3.0*size,x+5.5+3.0*size,y+5.5+3.0*size,z+5.5+3.0*size));
			for (int i = 0; i < targets.size(); i ++){
				targets.get(i).addPotionEffect(new PotionEffect(Potion.potionRegistry.getObject(new ResourceLocation("minecraft:speed")),40,(int)potency));
				targets.get(i).addPotionEffect(new PotionEffect(Potion.potionRegistry.getObject(new ResourceLocation("minecraft:jump_boost")),40,(int)potency));
			}
		}
	}
}