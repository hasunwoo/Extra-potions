package hasun.extrapotions.common.fluids;

import net.minecraftforge.fluids.Fluid;

public class FluidPotion extends Fluid{

	public FluidPotion(String potionName, int viscosity) {
		super("extrapotionspotionliquid."+potionName);
	}
}
