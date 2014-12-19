package code.BreakMC.practicepots.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import code.BreakMC.practicepots.util.Lag;

public class LagCommand implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return false;
		}

		Player p = (Player) sender;
	
		double tps = Lag.getTPS();
		double lag = Math.round((1.0D - tps / 20.0D) * 100.0D);
		
		p.sendMessage("§cServer Performance: " + getTPSColor() + (String.format("%.2f", tps)) + " §7[" + getLagColor() + (String.format("%.2f", lag)) + "% §cLag§7]");
		
		if (p.hasPermission("avalon.lag")) {
			float used = (float)(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
			used /= (float)Runtime.getRuntime().totalMemory();
			used *= 100.0F;
			float free = (float)Runtime.getRuntime().freeMemory();
			free /= (float)Runtime.getRuntime().totalMemory();
			free *= 100.0F;
			
			p.sendMessage("§cWorld: §b" + Bukkit.getWorld("world").getLoadedChunks().length + " §cChunks, §b" + Bukkit.getWorld("world").getEntities().size() + " §cEntities");
			p.sendMessage("§cMemory Usage: §b" + (String.format("%.2f", used)));
			p.sendMessage("§cMemory Free: §b" + (String.format("%.2f", free)));
		}
		return false;
	}
	
	private ChatColor getTPSColor() {
		double tps = Lag.getTPS();
		if (tps >= 16) {
			return ChatColor.GREEN;
		}
		else if (tps >= 11) {
			return ChatColor.YELLOW;
		}
		else if (tps >= 6) {
			return ChatColor.GOLD;
		}
		else if (tps >= 1) {
			return ChatColor.DARK_RED;
		}
		return ChatColor.GREEN;
	}
	
	private ChatColor getLagColor() {
		double tps = Lag.getTPS();
		double lag = Math.round((1.0D - tps / 20.0D) * 100.0D);
		if (lag <= 25) {
			return ChatColor.GREEN;
		}
		else if (lag <= 50) {
			return ChatColor.YELLOW;
		}
		else if (lag <= 75) {
			return ChatColor.GOLD;
		}
		else if (lag <= 100) {
			return ChatColor.DARK_RED;
		}
		return ChatColor.GREEN;
	}
}
