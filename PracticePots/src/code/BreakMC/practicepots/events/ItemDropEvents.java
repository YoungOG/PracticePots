package code.BreakMC.practicepots.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import code.BreakMC.practicepots.PracticePots;

public class ItemDropEvents implements Listener {

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		final Item i = e.getItemDrop();
		if (i != null) {
			if (!PracticePots.getInstance().getSpawnManager().isInSpawn(e.getPlayer()) || !PracticePots.getInstance().getSpawnManager().isInKitArea(e.getPlayer())) {
				Bukkit.getScheduler().scheduleSyncDelayedTask(PracticePots.getInstance(), new Runnable() {
					public void run() {
						i.remove();
					}
				}, 5 * 20);
			}
		}
	}
}
