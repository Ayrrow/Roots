
package elucent.herbologia;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventManager {
	Random random = new Random();
	@SubscribeEvent
	public void onBlockHarvested(HarvestDropsEvent event){
		Block block = event.getState().getBlock();
		if (block == Blocks.tallgrass){
			if (random.nextInt(40) == 0){
				event.getDrops().add(new ItemStack(RegistryManager.oldRoot,1));
			}
		}
		if (block == Blocks.wheat || block == Blocks.carrots || block == Blocks.potatoes || block == Blocks.beetroots){
			if (((BlockCrops)block).func_185525_y(event.getState())){
				if (random.nextInt(30) == 0){
					event.getDrops().add(new ItemStack(RegistryManager.verdantSprig,1));
				}
			}
		}
		if (block == Blocks.nether_wart){
			if (random.nextInt(20) == 0){
				event.getDrops().add(new ItemStack(RegistryManager.infernalStem,1));
			}
		}
		if (block == Blocks.chorus_flower){
			if (random.nextInt(10) == 0){
				event.getDrops().add(new ItemStack(RegistryManager.dragonsEye,1));
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent.RightClickBlock event){
		if (PlayerManager.hasEffect(event.getEntityPlayer(), "allium") && random.nextInt(4) != 0){
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event){
		if (event.getEntityLiving().getEntityData().hasKey("HBMOD_dropItems")){
			if (!event.getEntityLiving().getEntityData().getBoolean("HBMOD_dropItems")){
				event.setCanceled(true);
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingXP(LivingExperienceDropEvent event){
		if (event.getEntityLiving().getEntityData().hasKey("HBMOD_dropItems")){
			if (!event.getEntityLiving().getEntityData().getBoolean("HBMOD_dropItems")){
				event.setCanceled(true);
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingDamage(LivingHurtEvent event){
		if (event.getEntityLiving().getEntityData().hasKey("HBMOD_vuln")){
			event.setAmount((float) (event.getAmount()*(1.0+event.getEntityLiving().getEntityData().getDouble("HBMOD_vuln"))));
			event.getEntityLiving().getEntityData().removeTag("HBMOD_vuln");
		}
	}
	
	@SubscribeEvent
	public void onTick(TickEvent.ServerTickEvent event){
		PlayerManager.updateEffects();
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onTextureStitch(TextureStitchEvent event){
		ResourceLocation magicParticleRL = new ResourceLocation("herbologia:entity/magicParticle");
		event.getMap().registerSprite(magicParticleRL);
	}
}
