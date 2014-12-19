package code.BreakMC.practicepots.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import code.BreakMC.practicepots.PracticePots;

public class ClearCommand implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return false;
		}

		Player p = (Player) sender;

		if (!p.hasPermission("avalon.gamemode")) {
			p.sendMessage("§fUnknown command. Type \"/help\" for help.");
			return false;
		}

		p.sendMessage("§aYour inventory has been cleared.");
		PracticePots.getInstance().getSpawnManager().clearInventory(p);
		return false;
	}
}
