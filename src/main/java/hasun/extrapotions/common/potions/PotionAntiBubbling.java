package hasun.extrapotions.common.potions;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hasun.extrapotions.common.main.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionAntiBubbling extends Potion {

	public PotionAntiBubbling(int id, boolean isBadEffect, int liquidColor) {
		super(id, isBadEffect, liquidColor);
		setPotionName("potion.extrapotions.antibubbling");
		setIconIndex(0, 0);
	}

	@Override
	public boolean isReady(int tickLeft, int level) {
		// make sure performEffect every tick
		return true;
	}

	@Override
	public Potion setIconIndex(int par1, int par2) {
		return super.setIconIndex(par1, par2);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getStatusIconIndex() {
		Minecraft.getMinecraft().renderEngine
				.bindTexture(new ResourceLocation(Constants.MODID, "textures/potions/potions.png"));
		return super.getStatusIconIndex();
	}

	@Override
	public void performEffect(EntityLivingBase entity, int level) {
		if (!entity.worldObj.isRemote)
			// make sure potion effect does not have any cure. ex) milk
			entity.getActivePotionEffect(this).setCurativeItems(new ArrayList<ItemStack>());
		// set DataWatcher's id 7 to 0 so entity can't update particle
		entity.getDataWatcher().updateObject(7, Integer.valueOf(0));
	}
}
