package elucent.herbologia.component.components;

import java.util.ArrayList;
import java.util.Random;

import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.EnumCastType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class ComponentPeony extends ComponentBase{
	Random rnd = new Random();
	public ComponentPeony(){
		super("peony", "Peony's Caress", Blocks.double_plant,5);
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){
			((EntityLivingBase) caster).heal((float)(3+(potency==0?1:potency*1)));
		}
		if (type == EnumCastType.HEX){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-1.5*size,y-1.5*size,z-1.5*size,x+1.5*size,y+1.5*size,z+1.5*size));
			if(rnd.nextDouble() <= 0.25){
				for (int i = 0; i < targets.size(); i ++){
					targets.get(i).attackEntityFrom(DamageSource.cactus, (int)(potency==0?3:potency*3));
					targets.get(i).setLastAttacker(caster);
					targets.get(i).setRevengeTarget((EntityLivingBase)caster);
				}
			}
		}
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-1.5*size,y-1.5*size,z-1.5*size,x+1.5*size,y+1.5*size,z+1.5*size));
			for (int i = 0; i < targets.size(); i ++){
				if(rnd.nextDouble() <= 0.25 && targets.get(i) instanceof EntityPlayer){
					targets.get(i).heal((float)(3+(potency==0?1:potency*1)));
				}
			}
		}
	}	
	
	public void doEffect(World world, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-1.5*size,y-1.5*size,z-1.5*size,x+1.5*size,y+1.5*size,z+1.5*size));
			for (int i = 0; i < targets.size(); i ++){
				if(rnd.nextDouble() <= 0.25 && targets.get(i) instanceof EntityPlayer){
					targets.get(i).heal((float)(3+(potency==0?1:potency*1)));
				}
			}
		}
	}
}