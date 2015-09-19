package hasun.extrapotions.common.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemPotionBucket extends ItemBucket {

	public final String potionName;

	public ItemPotionBucket(Block liquidBlock, String potionName) {
		super(liquidBlock);
		this.potionName = potionName;
		setContainerItem(Items.bucket);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List listToDisplay, boolean unknown) {
		listToDisplay.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal(potionName));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconregister) {
		this.itemIcon = iconregister.registerIcon("extrapotions:potionbucket");
	}
}
