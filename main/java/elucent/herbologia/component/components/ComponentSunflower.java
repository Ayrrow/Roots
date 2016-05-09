package elucent.herbologia.component.components;

import java.util.ArrayList;
import java.util.Random;

import elucent.herbologia.component.ComponentBase;
import elucent.herbologia.component.EnumCastType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.block.Block;
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
import net.minecraft.world.World;


public class ComponentSunflower extends ComponentBase{
	Random random = new Random();
	public ComponentSunflower(){
		super("sunflower","Daylight",Blocks.double_plant,0);	
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){	
			ArrayList<EntityLivingBase> targets = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).isEntityUndead()){
					targets.get(i).attackEntityFrom(DamageSource.inFire, (int)(11+4*potency));
					targets.get(i).setFire((int) (7+4*potency));
					targets.get(i).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:weakness"), 15, 2+(int)potency));
					targets.get(i).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:slowness"), 15, 2+(int)potency));
					targets.get(i).setLastAttacker(caster);
					targets.get(i).setRevengeTarget((EntityLivingBase)caster);
				}
			}
		}
		if (type == EnumCastType.HEX){
			BlockPos pos = new BlockPos(x+(random.nextInt((int)size)-(int)(size-2)),y+(random.nextInt((int)size)-(int)(size-2)),z+(random.nextInt((int)size)-(int)(size-2)));
			if (world.getBlockState(pos).getBlock().getLightValue(world.getBlockState(pos)) > 0){
				((Block)world.getBlockState(pos).getBlock()).breakBlock(world, pos, world.getBlockState(pos));
			}
		}
		if (type == EnumCastType.INCENSE){
			ArrayList<EntityMob> targets = (ArrayList<EntityMob>) world.getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB(x-1.5*size,y-1.5*size,z-1.5*size,x+1.5*size,y+1.5*size,z+1.5*size));
			for (int i = 0; i < targets.size(); i ++){
				if (targets.get(i).isEntityUndead()){
					targets.get(i).setFire((int) (5+5*potency));
				}
			}
		}
	}
}