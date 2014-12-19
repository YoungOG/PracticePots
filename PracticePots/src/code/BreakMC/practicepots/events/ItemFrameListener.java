package code.BreakMC.practicepots.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import code.BreakMC.practicepots.PracticePots;
import code.BreakMC.practicepots.KitManager;
import code.BreakMC.practicepots.SpawnManager;

public class ItemFrameListener implements Listener {

	@EventHandler
	public void onClick(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		Entity frame = e.getRightClicked();
		KitManager km = PracticePots.getInstance().getKitManager();
		SpawnManager sm = PracticePots.getInstance().getSpawnManager();
		Location createProtII = new Location(Bukkit.getWorld("world"), 502.5, 9.5, 545.9375);
		Location saveProtII = new Location(Bukkit.getWorld("world"), 501.5, 9.5, 545.9375);
		Location loadNoEnchant = new Location(Bukkit.getWorld("world"), 499.5, 9.5, 545.9375);
		Location saveNoEnchant = new Location(Bukkit.getWorld("world"), 498.5, 9.5, 545.9375);
		Location clearInventory = new Location(Bukkit.getWorld("world"), 500.5, 10.5, 545.9375);
		if (frame instanceof ItemFrame) {
			ItemFrame itemframe = (ItemFrame) frame;
			if (itemframe.getItem().getType() == Material.MAP) {
				Bukkit.broadcastMessage("Location: " + frame.getLocation());
				e.setCancelled(true);
				if (PracticePots.getInstance().getSpawnManager().isInKitArea(p)) {
					if (frame.getLocation().equals(createProtII)) {
						km.showProtectionIIMenu(p);
					}
					else if (frame.getLocation().equals(saveProtII)) {
						km.saveProtectionIIKit(p);
					}
					else if (frame.getLocation().equals(loadNoEnchant)) {
						km.showNoEnchantsMenu(p);
					}
					else if (frame.getLocation().equals(saveNoEnchant)) {
						km.saveNoEnchantsKit(p);
					}
					else if (frame.getLocation().equals(clearInventory)) {
						sm.clearInventory(p);
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Location loadKit = new Location(Bukkit.getWorld("world"), 500.0, 9.0, 546.0);
		if (e.hasBlock()) {
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getClickedBlock().getType() == Material.CHEST) {
					if (PracticePots.getInstance().getSpawnManager().isInKitArea(p)) {
						if (e.getClickedBlock().getLocation().equals(loadKit)) {
							PracticePots.getInstance().getKitManager().showLoadKitsMenu(p);
						}
					}
				}
			}
		}
	}
}
