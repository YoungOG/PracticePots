package code.BreakMC.practicepots.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import code.BreakMC.practicepots.PracticePots;

public class DeathEvents implements Listener {

	@EventHandler
	public void onDeath(final PlayerDeathEvent e) {
		if (e.getEntity().getName().equalsIgnoreCase("EnvyPvP")) {
			e.getEntity().sendMessage("§aHACK ez pinger");
		}
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		respawnPlayer(e.getPlayer());
	}

	public void respawnPlayer(final Player p) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(PracticePots.getInstance(), new Runnable() {
			public void run() {
				PracticePots.getInstance().getSpawnManager().setSpawnInventory(p);
				PracticePots.getInstance().getSpawnManager().teleport(p, PracticePots.getInstance().getSpawnManager().getSpawn());
			}
		}, 3L);
	}
}
