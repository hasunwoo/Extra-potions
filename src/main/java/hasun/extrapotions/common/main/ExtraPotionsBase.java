package hasun.extrapotions.common.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import hasun.extrapotions.common.creativetabs.ExtraPotionsCreativeTab;
import hasun.extrapotions.common.events.PotionBucketEventHandler;
import hasun.extrapotions.common.init.PotionFluidRegister;
import hasun.extrapotions.common.init.ItemRegister;
import hasun.extrapotions.common.init.PotionEffectRegister;
import hasun.extrapotions.common.utils.IProxy;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Constants.MODID, version = Constants.VERSION, useMetadata = true, canBeDeactivated = false)
public class ExtraPotionsBase {
	public static final Logger LOGGER = LogManager.getLogger("ExtraPotions");

	@Mod.Instance(Constants.MODID)
	public static ExtraPotionsBase instance;

	@SidedProxy(clientSide = "hasun.extrapotions.client.init.ClientProxy", serverSide = "hasun.extrapotions.common.init.CommonProxy")
	public static IProxy proxy;

	public static ExtraPotionsCreativeTab creativeTab;

	@Mod.EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		ExtraPotionsConfig.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		creativeTab = new ExtraPotionsCreativeTab();
		PotionEffectRegister.register();
		ItemRegister.register();
		proxy.init();
	}

	@Mod.EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		PotionFluidRegister.registerAll(true, true);
		MinecraftForge.EVENT_BUS.register(new PotionBucketEventHandler());
	}

}
