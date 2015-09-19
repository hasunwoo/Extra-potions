package hasun.extrapotions.common.main;

import java.io.File;

import org.apache.logging.log4j.Level;

import hasun.extrapotions.common.init.PotionEffectRegister;
import net.minecraftforge.common.config.Configuration;

public class ExtraPotionsConfig {
	public static Configuration config;

	public static void init() {
		config = new Configuration(new File("./config/extrapotions.cfg"));
		try {
			config.load();
			readConfig();
		} catch (Exception e) {
			ExtraPotionsBase.LOGGER.log(Level.FATAL, "Problem Occured druing config load", e);
		} finally {
			config.save();
		}
	}

	public static void readConfig() {
		PotionEffectRegister.antibubble_ID = config.getInt("potion.extrapotions.antibubbling", "Potion ID", 70, 0, 256,
				"");
	}
}
