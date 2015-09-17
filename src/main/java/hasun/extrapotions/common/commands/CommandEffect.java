package hasun.extrapotions.common.commands;

import hasun.extrapotions.common.main.Constants;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;

public class CommandEffect extends CommandBase{

	@Override
	public String getCommandName() {
		return "effect";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "commands."+Constants.MODID+".effect.usage";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if(args.length==2){
			//if()
		}else{
			showHelp(sender);
		}
	}
	
	private void showHelp(ICommandSender sender){
		sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("commands.extrapotions.syntaxerr")));
		sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal(getCommandUsage(sender))));
	}
	
}
