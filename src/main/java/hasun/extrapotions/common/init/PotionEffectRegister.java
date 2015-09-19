package hasun.extrapotions.common.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import hasun.extrapotions.common.main.ExtraPotionsBase;
import hasun.extrapotions.common.potions.PotionAntiBubbling;
import net.minecraft.potion.Potion;

public class PotionEffectRegister {
	public static Potion antibubble;

	public static void register() {
		if (Potion.potionTypes.length < 256) {
			extendPotionSlot();
		}
		antibubble = new PotionAntiBubbling(79, false, 0);
	}

	private static void extendPotionSlot() {
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
					potionTypes = (Potion[]) f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}
			} catch (Exception e) {
				ExtraPotionsBase.LOGGER.error(e);
			}
		}
	}
}
