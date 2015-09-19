package hasun.extrapotions.common.creativetabs;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import hasun.extrapotions.common.init.ItemRegister;
import hasun.extrapotions.common.init.PotionFluid;
import hasun.extrapotions.common.init.PotionFluidRegister;
import hasun.extrapotions.common.main.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ExtraPotionsCreativeTab extends CreativeTabs {
	public ExtraPotionsCreativeTab() {
		super(Constants.MODID);
		setBackgroundImageName("item_search.png");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return ItemRegister.itemPotionParticleRemover;
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

	@Override
	public void displayAllReleventItems(List listToDisplay) {
		addItem(ItemRegister.itemPotionParticleRemover, listToDisplay);
		// potion buckets
		List<PotionFluid> pf = PotionFluidRegister.getPotionLiquids();
		for (PotionFluid p : pf) {
			Item bucket = p.bucket;
			if (bucket != null)
				addItem(bucket, listToDisplay);
		}

	}

	private void addItem(Item item, List list) {
		item.getSubItems(item, this, list);
	}

	@Override
	public int getSearchbarWidth() {
		return 60;
	}
}
