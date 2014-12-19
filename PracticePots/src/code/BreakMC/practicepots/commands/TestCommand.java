package code.BreakMC.practicepots.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TestCommand implements CommandExecutor, Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
//			for (Player all : Bukkit.getOnlinePlayers()) {
//				Bukkit.broadcastMessage(all.getName() + "§a's Ping§b: " + (getPing(all) / 2));
//			}
		}
		return false;
	}

	public int getPing(Player p) {
		return ((CraftPlayer) p).getHandle().ping;
	}
}