package hasun.extrapotions.common.init;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import hasun.extrapotions.common.blocks.BlockPotionFluid;
import hasun.extrapotions.common.fluids.FluidPotion;
import hasun.extrapotions.common.items.ItemPotionBucket;
import hasun.extrapotions.common.main.ExtraPotionsBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class PotionFluidRegister {
	private static ArrayList<PotionFluid> potions = new ArrayList<PotionFluid>();

	public static void registerAll(boolean time, boolean debug) {
		for (Potion p : Potion.potionTypes) {
			if (p != null) {
				PotionFluid pf = new PotionFluid(p.getId(), 2000, p.getLiquidColor());
				potions.add(pf);
				registerToRegistery(pf);
			}
		}
	}

	private static void registerToRegistery(PotionFluid potionfluid) {
		String pName = Potion.potionTypes[potionfluid.potionID].getName();

		Fluid fluid = new FluidPotion(pName, potionfluid.viscosity);
		FluidRegistry.registerFluid(fluid);

		Block block = new BlockPotionFluid(fluid, pName, Material.water);
		GameRegistry.registerBlock(block, "extrapotions.potionliquid." + pName);

		Item bucket = new ItemPotionBucket(block, pName).setUnlocalizedName("extrapotions.potionbucket")
				.setCreativeTab(ExtraPotionsBase.creativeTab);
		GameRegistry.registerItem(bucket, "extrapotions.potionbucket." + pName);

		FluidContainerRegistry.registerFluidContainer(fluid, new ItemStack(bucket),
				FluidContainerRegistry.EMPTY_BUCKET);

		potionfluid.liquid = (FluidPotion) fluid;
		potionfluid.liquidBlock = block;
		potionfluid.bucket = bucket;
	}

	public static List<PotionFluid> getPotionLiquids() {
		return Collections.unmodifiableList(potions);
	}
}
