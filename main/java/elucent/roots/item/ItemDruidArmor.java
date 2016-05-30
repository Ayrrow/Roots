package elucent.roots.item;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Multimap;

import elucent.roots.RegistryManager;
import elucent.roots.Roots;
import elucent.roots.model.ModelDruidArmor;
import elucent.roots.model.ModelDruidRobes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDruidArmor extends ItemArmor {
	
	Random rnd = new Random();
	
	public ItemDruidArmor(int reduction, EntityEquipmentSlot slot){
		super(RegistryManager.druidArmorMaterial, reduction, slot);
		if (slot == EntityEquipmentSlot.HEAD){
			setUnlocalizedName("druidArmorHead");
		}
		if (slot == EntityEquipmentSlot.CHEST){
			setUnlocalizedName("druidArmorChest");
		}
		if (slot == EntityEquipmentSlot.LEGS){
			setUnlocalizedName("druidArmorLegs");
		}
		if (slot == EntityEquipmentSlot.FEET){
			setUnlocalizedName("druidArmorBoots");
		}
		setCreativeTab(Roots.tab);
	}
	
	@Override
	public Multimap getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack){
        Multimap multimap = super.getAttributeModifiers(slot, stack);
        if (stack.getItem() == RegistryManager.druidArmorHead && slot == EntityEquipmentSlot.HEAD){
        	multimap.put(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), new AttributeModifier(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), 4.0, 0));
        }
        if (stack.getItem() == RegistryManager.druidArmorChest && slot == EntityEquipmentSlot.CHEST){
        	multimap.put(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), new AttributeModifier(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), 4.0, 0));
        }
        if (stack.getItem() == RegistryManager.druidArmorLegs && slot == EntityEquipmentSlot.LEGS){
        	multimap.put(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), new AttributeModifier(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), 4.0, 0));
        }
        if (stack.getItem() == RegistryManager.druidArmorBoots && slot == EntityEquipmentSlot.FEET){
        	multimap.put(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), new AttributeModifier(SharedMonsterAttributes.MAX_HEALTH.getAttributeUnlocalizedName(), 4.0, 0));
        }
        return multimap;
    }
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced){
		if (!stack.hasTagCompound()){
			NBTTagCompound attribute = new NBTTagCompound();
			if (stack.getItem() == RegistryManager.druidArmorHead){
				attribute.setString("Slot", EntityEquipmentSlot.HEAD.getName());
			}
			if (stack.getItem() == RegistryManager.druidArmorChest){
				attribute.setString("Slot", EntityEquipmentSlot.CHEST.getName());
			}
			if (stack.getItem() == RegistryManager.druidArmorLegs){
				attribute.setString("Slot", EntityEquipmentSlot.LEGS.getName());
			}
			if (stack.getItem() == RegistryManager.druidArmorBoots){
				attribute.setString("Slot", EntityEquipmentSlot.FEET.getName());
			}
			attribute.setString("AttributeName", "generic.maxHealth");
			attribute.setString("Name","Health boost");
			attribute.setDouble("Amount",4.0);
			attribute.setInteger("operation", 0);
			attribute.setInteger("UUIDLeast", 1);
			attribute.setInteger("UUIDMost", 1);
			NBTTagList modifiers = new NBTTagList();
			modifiers.appendTag(attribute);
			NBTTagCompound itemTag = new NBTTagCompound();
			itemTag.setTag("AttributeModifiers", modifiers);
			stack.setTagCompound(itemTag);
		}
		EntityEquipmentSlot slot = null;
		if (stack.getItem() == RegistryManager.druidArmorHead){
			slot = EntityEquipmentSlot.HEAD;
		}
		if (stack.getItem() == RegistryManager.druidArmorChest){
			slot = EntityEquipmentSlot.CHEST;
		}
		if (stack.getItem() == RegistryManager.druidArmorLegs){
			slot = EntityEquipmentSlot.LEGS;
		}
		if (stack.getItem() == RegistryManager.druidArmorBoots){
			slot = EntityEquipmentSlot.FEET;
		}
		tooltip.add("");
		tooltip.add(TextFormatting.GRAY+"When equipped:");
		tooltip.add(TextFormatting.BLUE+" +"+this.getArmorMaterial().getDamageReductionAmount(slot) + " Armor");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type){
		return "roots:textures/models/armor/druidArmor.png";
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default){
		return new ModelDruidArmor(slot);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		if (stack.isItemDamaged() && rnd.nextInt(40) == 0){
			stack.setItemDamage(stack.getItemDamage()-1);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
	}
}
