package hasun.extrapotions.common.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hasun.extrapotions.common.init.PotionEffectRegister;
import hasun.extrapotions.common.main.Constants;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPotionParticleRemover extends Item {
	@SideOnly(Side.CLIENT)
	private IIcon iconActive;
	@SideOnly(Side.CLIENT)
	private IIcon iconInactive;

	public ItemPotionParticleRemover() {
		super();
		setNoRepair();
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int unknown1, boolean unknown2) {
		if (!world.isRemote) {
			if (itemstack.getItemDamage()==1) {
				((EntityLivingBase) entity)
						.addPotionEffect(new PotionEffect(PotionEffectRegister.antibubble.getId(), 20 * 3));
			}
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			if (player.isSneaking()) {
				if(itemstack.getItemDamage()==0){
					itemstack.setItemDamage(1);
				}else{
					itemstack.setItemDamage(0);
				}
			}
		}
		return itemstack;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		return par1ItemStack.getItemDamage()==1;
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List listToDisplay, boolean unknown) {
		listToDisplay.add(StatCollector.translateToLocal("item.extrapotions.particleremover.tooltip.info"));
		String unlocalized = "item.extrapotions.particleremover.tooltip.";
		listToDisplay.add(itemstack.getItemDamage()==1
				? EnumChatFormatting.GREEN + StatCollector.translateToLocal(unlocalized + "active")
				: EnumChatFormatting.DARK_RED + StatCollector.translateToLocal(unlocalized + "inactive"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconregister) {
		itemIcon = iconregister.registerIcon(Constants.MODID + ":particleremover-inactive");
		iconActive = iconregister.registerIcon(Constants.MODID + ":particleremover-active");
		iconInactive = iconregister.registerIcon(Constants.MODID + ":particleremover-inactive");
	}

	@Override
	public IIcon getIconFromDamage(int metadata) {
		return metadata == 1 ? iconActive : iconInactive;
	}

	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		return stack.getItemDamage() == 1 ? iconActive : iconInactive;
	}
	
	
}
