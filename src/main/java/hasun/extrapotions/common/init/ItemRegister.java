package hasun.extrapotions.common.init;

import cpw.mods.fml.common.API;
import cpw.mods.fml.common.registry.GameRegistry;
import hasun.extrapotions.common.items.ItemPotionParticleRemover;
import hasun.extrapotions.common.main.Constants;
import hasun.extrapotions.common.main.ExtraPotionsBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemRegister {
	public static Item itemPotionParticleRemover;

	public static void register() {
		itemPotionParticleRemover = new ItemPotionParticleRemover()
				.setUnlocalizedName(Constants.MODID + ".particleremover").setCreativeTab(ExtraPotionsBase.creativeTab);
		GameRegistry.registerItem(itemPotionParticleRemover, Constants.MODID + ".particleremover");
		registerRecipes();
	}

	private static void registerRecipes() {
		// particle cleaner
		GameRegistry.addShapedRecipe(new ItemStack(itemPotionParticleRemover), new Object[] { "GDG", "DPD", "GDG", 'G',
				Items.gold_ingot, 'D', Items.diamond, 'P', new ItemStack(Items.potionitem, 1, 8270) });
		
	}
}
