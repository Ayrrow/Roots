package elucent.herbologia.component.components;

import java.util.ArrayList;
import java.util.UUID;

import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.EnumCastType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class ComponentRose extends ComponentBase {
	public ComponentRose(){
		super("rosebush", "Rose's Thorns", Blocks.double_plant,4);
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).getUniqueID() != caster.getUniqueID()){
					targets.get(i).attackEntityFrom(DamageSource.cactus, (int)(9+3*potency));
					targets.get(i).setLastAttacker(caster);
					targets.get(i).setRevengeTarget((EntityLivingBase)caster);
				}
			}
		}
		if (type == EnumCastType.HEX){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-1.5*size,y-1.5*size,z-1.5*size,x+1.5*size,y+1.5*size,z+1.5*size));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).getUniqueID() != caster.getUniqueID()){
					targets.get(i).attackEntityFrom(DamageSource.cactus, (int)(3+2*potency));
				}
			}
		}
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityMob> targets = (ArrayList<EntityMob>) world.getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB(x-1.5*size,y-1.5*size,z-1.5*size,x+1.5*size,y+1.5*size,z+1.5*size));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).getUniqueID() != caster.getUniqueID()){
					targets.get(i).attackEntityFrom(DamageSource.cactus, (int)(3+2*potency));
				}
			}
		}
	}
}
