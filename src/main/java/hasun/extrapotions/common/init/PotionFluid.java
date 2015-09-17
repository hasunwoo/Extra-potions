package hasun.extrapotions.common.init;

import hasun.extrapotions.common.fluids.FluidPotion;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class PotionFluid {
	public final int potionID;
	public final int viscosity;
	public final int liquidColor;
	public FluidPotion liquid;
	public Item bucket;
	public Block liquidBlock;

	public PotionFluid(int potionID, int viscosity, int liquidColor) {
		this.potionID = potionID;
		this.viscosity = viscosity;
		this.liquidColor = liquidColor;
	}
}
