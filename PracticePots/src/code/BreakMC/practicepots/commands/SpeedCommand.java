package code.BreakMC.practicepots.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SpeedCommand implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return false;
		}

		Player p = (Player) sender;

		if (!p.hasPermission("avalon.speed")) {
			p.sendMessage("§fUnknown command. Type \"/help\" for help.");
			return false;
		}

		if (args.length == 1) {
			if (p.isFlying()) {
				p.setFlySpeed(Float.parseFloat(args[0]));
				p.sendMessage("§aFly speed set to §b" + Float.parseFloat(args[0]));
			} else {
				p.setWalkSpeed(Float.parseFloat(args[0]));
				p.sendMessage("§bWalk speed set to §b" + Float.parseFloat(args[0]));
			}
		}
		return false;
	}
}
