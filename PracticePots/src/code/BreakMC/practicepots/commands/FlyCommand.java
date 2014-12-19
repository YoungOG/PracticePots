package code.BreakMC.practicepots.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class FlyCommand implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return false;
		}

		Player p = (Player) sender;

		if (!p.hasPermission("avalon.fly")) {
			p.sendMessage("§fUnknown command. Type \"/help\" for help.");
			return false;
		}

		if (args.length == 0) {
			if (p.getAllowFlight()) {
				p.setAllowFlight(false);
				p.sendMessage("§aYou have set your flying mode to§b: False");
			} else {
				p.setAllowFlight(true);
				p.sendMessage("§aYou have set your flying mode to§b: True");
			}
		} else if (args.length == 1) {
			if (Bukkit.getPlayer(args[0]) == null) {
				p.sendMessage("§cThat is not a valid player.");
				return false;
			}

			Player target = Bukkit.getPlayer(args[0]);

			if (target.getAllowFlight()) {
				target.setAllowFlight(false);
				target.sendMessage("§6" + p.getName() + " §ahas set your flying mode to§b: False");
				p.sendMessage("§aYou have set §6" + target.getName() + "'s §aflying mode to§b: False");
			} else {
				target.setAllowFlight(true);
				target.sendMessage("§6" + p.getName() + " §ahas set your flying mode to§b: True");
				p.sendMessage("§aYou have set §6" + target.getName() + "'s §aflying mode to§b: True");
			}
		} else {
			p.sendMessage("§cUsage: /fly <player>");
			return false;
		}
		return false;
	}
}
