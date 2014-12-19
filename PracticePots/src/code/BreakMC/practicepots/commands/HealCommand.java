package code.BreakMC.practicepots.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class HealCommand implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return false;
		}

		Player p = (Player) sender;

		if (!p.hasPermission("avalon.heal")) {
			p.sendMessage("§fUnknown command. Type \"/help\" for help.");
			return false;
		}

		if (args.length == 0) {
			p.setHealth((double) 20.0);
			p.setFoodLevel(20);
			p.sendMessage("§aYou have been healed.");
		} else if (args.length == 1) {
			if (Bukkit.getPlayer(args[0]) == null) {
				p.sendMessage("§cThat is not a valid player.");
				return false;
			}

			Player target = Bukkit.getPlayer(args[0]);

			target.setFoodLevel(20);
			target.setHealth((double) 20.0);
			target.sendMessage("§aYou have been healed.");
			p.sendMessage("§aYou have healed §6" + target.getName() + "§a.");
		} else {
			p.sendMessage("§cUsage: /heal <player>");
			return false;
		}
		return false;
	}
}
