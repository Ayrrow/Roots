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
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;


public class ComponentNetherWart extends ComponentBase{
	Random random = new Random();
	public ComponentNetherWart(){
		super("netherwart","Inferno",Items.nether_wart);	
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){	
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).getUniqueID() != caster.getUniqueID()){
					targets.get(i).attackEntityFrom(DamageSource.inFire, (int)(5+2*potency));
					targets.get(i).setFire((int) (4+3*potency));
					targets.get(i).setLastAttacker(caster);
					targets.get(i).setRevengeTarget((EntityLivingBase)caster);
				}
			}
		}

		if (type == EnumCastType.INCENSE){
			ArrayList<EntityMob> targets = (ArrayList<EntityMob>) world.getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB(x-5.5-3.0*size,y-5.5-3.0*size,z-5.5-3.0*size,x+5.5+3.0*size,y+5.5+3.0*size,z+5.5+3.0*size));
			if (random.nextInt(4) == 0){
				int i = random.nextInt(targets.size());
				targets.get(i).setFire((int) (4+3*potency));
			}
		}
	}
	
	@Override
	public void doEffect(World world, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityMob> targets = (ArrayList<EntityMob>) world.getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB(x-5.5-3.0*size,y-5.5-3.0*size,z-5.5-3.0*size,x+5.5+3.0*size,y+5.5+3.0*size,z+5.5+3.0*size));
			if (random.nextInt(4) == 0){
				int i = random.nextInt(targets.size());
				targets.get(i).setFire((int) (4+3*potency));
			}
		}
	}
}
