package code.BreakMC.practicepots.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GamemodeCommand implements CommandExecutor, Listener {

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

		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage("§aYour game mode has been set to §bSurvival§a.");
			} else if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage("§aYour game mode has been set to §bCreative§a.");
			} else {
				p.sendMessage("§cUsage: /gamemode [survival/creative] <player>");
				return false;
			}
		} else if (args.length == 2) {
			if (Bukkit.getPlayer(args[0]) == null) {
				p.sendMessage("§6" + args[0] + " §cis not a valid player.");
				return false;
			}

			Player target = Bukkit.getPlayer(args[0]);

			if (args[1].equalsIgnoreCase("survival") || args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("0")) {
				target.setGameMode(GameMode.SURVIVAL);
				target.sendMessage("§aYour game mode has been set to §bSurvival§a.");
				p.sendMessage("§6" + target.getName() + "'s §agame mode has been set to §bSurvival§a.");
			} else if (args[1].equalsIgnoreCase("creative") || args[1].equalsIgnoreCase("c") || args[1].equalsIgnoreCase("1")) {
				target.setGameMode(GameMode.CREATIVE);
				target.sendMessage("§aYour game mode has been set to §bCreative§a.");
				p.sendMessage("§6" + target.getName() + "'s §agame mode has been set to §bCreative§a.");
			} else {
				p.sendMessage("§cUsage: /gamemode [survival/creative] <player>");
				return false;
			}
		} else {
			p.sendMessage("§cUsage: /gamemode [survival/creative] <player>");
			return false;
		}
		return false;
	}
}
