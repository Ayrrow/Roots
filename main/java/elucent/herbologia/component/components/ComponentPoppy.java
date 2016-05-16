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
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class ComponentPoppy extends ComponentBase{
	Random random = new Random();
	public ComponentPoppy(){
		super("poppy","Insanity",Blocks.red_flower,0,3);	
	}
	
	@Override
	public void doEffect(World world, Entity caster, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.SPELL){
			ArrayList<EntityMob> targets = (ArrayList<EntityMob>) world.getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB(x-size,y-size,z-size,x+size,y+size,z+size));
			for (int i = 0; i < targets.size(); i ++){
				int j = random.nextInt(targets.size());
				if (j != i && random.nextInt(8-2*(int)potency) == 0){
					targets.get(i).setAttackTarget(targets.get(j));
				}
			}
		}
		if (type == EnumCastType.INCENSE){
			if (random.nextInt(8-2*(int)potency) == 0){
				switch (random.nextInt(4)){
				case 0:
					world.playSound((EntityPlayer)null, x+(random.nextDouble()-0.5)*(1.0+size)*11.0, y+(random.nextDouble()-0.5)*(1.0+size)*11.0, z+(random.nextDouble()-0.5)*(1.0+size)*11.0, SoundEvents.entity_skeleton_ambient, SoundCategory.HOSTILE, 0.3f, 1.0f);
				case 1:
					world.playSound((EntityPlayer)null, x+(random.nextDouble()-0.5)*(1.0+size)*11.0, y+(random.nextDouble()-0.5)*(1.0+size)*11.0, z+(random.nextDouble()-0.5)*(1.0+size)*11.0, SoundEvents.entity_zombie_ambient, SoundCategory.HOSTILE, 0.3f, 1.0f);
				case 2:
					world.playSound((EntityPlayer)null, x+(random.nextDouble()-0.5)*(1.0+size)*11.0, y+(random.nextDouble()-0.5)*(1.0+size)*11.0, z+(random.nextDouble()-0.5)*(1.0+size)*11.0, SoundEvents.entity_creeper_hurt, SoundCategory.HOSTILE, 0.3f, 1.0f);
				case 3:
					world.playSound((EntityPlayer)null, x+(random.nextDouble()-0.5)*(1.0+size)*11.0, y+(random.nextDouble()-0.5)*(1.0+size)*11.0, z+(random.nextDouble()-0.5)*(1.0+size)*11.0, SoundEvents.entity_spider_ambient, SoundCategory.HOSTILE, 0.3f, 1.0f);
				}
			}
		}
	}
	
	@Override
	public void doEffect(World world, EnumCastType type, double x, double y, double z, double potency, double duration, double size){
		if (type == EnumCastType.INCENSE){
			if (random.nextInt(8-2*(int)potency) == 0){
				switch (random.nextInt(4)){
				case 0:
					world.playSound((EntityPlayer)null, x+(random.nextDouble()-0.5)*(1.0+size)*11.0, y+(random.nextDouble()-0.5)*(1.0+size)*11.0, z+(random.nextDouble()-0.5)*(1.0+size)*11.0, SoundEvents.entity_skeleton_ambient, SoundCategory.HOSTILE, 0.3f, 1.0f);
				case 1:
					world.playSound((EntityPlayer)null, x+(random.nextDouble()-0.5)*(1.0+size)*11.0, y+(random.nextDouble()-0.5)*(1.0+size)*11.0, z+(random.nextDouble()-0.5)*(1.0+size)*11.0, SoundEvents.entity_zombie_ambient, SoundCategory.HOSTILE, 0.3f, 1.0f);
				case 2:
					world.playSound((EntityPlayer)null, x+(random.nextDouble()-0.5)*(1.0+size)*11.0, y+(random.nextDouble()-0.5)*(1.0+size)*11.0, z+(random.nextDouble()-0.5)*(1.0+size)*11.0, SoundEvents.entity_creeper_hurt, SoundCategory.HOSTILE, 0.3f, 1.0f);
				case 3:
					world.playSound((EntityPlayer)null, x+(random.nextDouble()-0.5)*(1.0+size)*11.0, y+(random.nextDouble()-0.5)*(1.0+size)*11.0, z+(random.nextDouble()-0.5)*(1.0+size)*11.0, SoundEvents.entity_spider_ambient, SoundCategory.HOSTILE, 0.3f, 1.0f);
				}
			}
		}
	}
}
