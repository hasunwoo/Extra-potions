package hasun.extrapotions.common.events;

import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import hasun.extrapotions.common.init.PotionFluid;
import hasun.extrapotions.common.init.PotionFluidRegister;
import hasun.extrapotions.common.items.ItemPotionBucket;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class PotionBucketEventHandler {
	private HashMap<Block,Item> map = new HashMap<Block,Item>();
	
	public PotionBucketEventHandler() {
		List<PotionFluid> pf = PotionFluidRegister.getPotionLiquids();
		for(PotionFluid p : pf){
			Item bucket = p.bucket;
			Block block = p.liquidBlock;
			map.put(block, bucket);
		}
	}
	
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event) {
		ItemStack result = tryFill(event.world, event.target);
		if (result != null) {
			event.result = result;
			event.setResult(Result.ALLOW);
		}
	}

	private ItemStack tryFill(World world, MovingObjectPosition mop) {
		Block b = world.getBlock(mop.blockX, mop.blockY, mop.blockZ);
		if (b != null && hasBucket(b)) {
			world.setBlockToAir(mop.blockX, mop.blockY, mop.blockZ);
			Item replaced = map.get(b);
			return new ItemStack(replaced);
		} else {
			return null;
		}
	}
	
	private boolean hasBucket(Block b){
		if(map.containsKey(b)){
			Item bucket = map.get(b);
			if((bucket!=null) && (bucket instanceof ItemPotionBucket)){
				return true;
			}
		}
		return false;
	}
}
