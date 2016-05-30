package elucent.roots.component.components;

import java.util.ArrayList;
import java.util.Random;

import elucent.roots.component.ComponentBase;
import elucent.roots.component.EnumCastType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;


public class ComponentNetherWart extends ComponentBase{
	Random random = new Random();
	public ComponentNetherWart(){
		super("netherwart","Inferno",Items.NETHER_WART,5);	
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
			ArrayList<EntityItem> items = (ArrayList<EntityItem>) world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x-size*0.5,y-size*0.5,z-size*0.5,x+size*0.5,y+size*0.5,z+size*0.5));
			for (int i = 0; i < targets.size(); i ++){
				if (FurnaceRecipes.instance().getSmeltingResult(targets.get(i).getActiveItemStack()) != null){
					if (random.nextInt(8-(int)potency*2) == 0){
						ItemStack result = FurnaceRecipes.instance().getSmeltingResult(targets.get(i).getActiveItemStack());
						world.spawnEntityInWorld(new EntityItem(world,targets.get(i).posX,targets.get(i).posY,targets.get(i).posZ,new ItemStack(result.getItem(),1,result.getItemDamage())));
						targets.get(i).getActiveItemStack().stackSize --;
					}
				}
			}
		}
	}
}
