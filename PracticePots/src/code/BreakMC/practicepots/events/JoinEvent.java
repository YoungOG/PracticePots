package code.BreakMC.practicepots.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.map.MapView;

import code.BreakMC.practicepots.PracticePots;
import code.BreakMC.practicepots.SpawnManager;
import code.BreakMC.practicepots.util.Title;

public class JoinEvent implements Listener {

	@EventHandler
	public void onPlayerJoinLocked(PlayerLoginEvent e) {
		if (PracticePots.getInstance().isServerLocked()) {
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cThe server is still loading...");
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		Bukkit.getScheduler().scheduleSyncDelayedTask(PracticePots.getInstance(), new Runnable() {
			public void run() {
				SpawnManager sm = PracticePots.getInstance().getSpawnManager();
				sm.setSpawnInventory(p);
				sm.teleport(p, sm.getSpawn());
				
				for (Entity ents : Bukkit.getWorld("world").getEntities()) {
					if (ents instanceof ItemFrame) {
						ItemFrame itemf = (ItemFrame) ents;
						if (itemf.getItem().getType() == Material.MAP) {
							MapView map = Bukkit.getMap(itemf.getItem().getDurability());
							p.sendMap(map);
						}
					}
				}
				
				Title.sendTimings(p, 20, 3*20, 20);
				Title.sendTitle(p, "§aWelcome To");
				Title.sendSubTitle(p, "§b§lAvulon Pots");
			}
		}, 5);
	}
}
