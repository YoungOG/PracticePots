package code.BreakMC.practicepots.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import code.BreakMC.practicepots.PracticePots;
import code.BreakMC.practicepots.SpawnManager;

public class SpawnEvents implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (PracticePots.getInstance().getSpawnManager().isInSpawn(p)) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			Player v = (Player) e.getEntity();
			if (PracticePots.getInstance().getSpawnManager().isInSpawn(v)) {
				e.setCancelled(true);
			}
		}
		if (e.getDamager() instanceof Player) {
			Player d = (Player) e.getDamager();
			if (PracticePots.getInstance().getSpawnManager().isInSpawn(d)) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (PracticePots.getInstance().getSpawnManager().isInSpawn(p) && (PracticePots.getInstance().getSpawnManager().isInKitArea(p))) {
			e.getItemDrop().remove();
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		SpawnManager sm = PracticePots.getInstance().getSpawnManager();
		if (p.getWorld().equals(Bukkit.getWorld("world"))) {
			if (sm.isInKitArea(p)) {
				if (!sm.getInKitSelection().contains(p.getUniqueId())) {
					sm.getInKitSelection().add(p.getUniqueId());
					p.sendMessage("§aYou have entered the Kit Creation area.");
					sm.clearInventory(p);
				}
			}
			if (!sm.isInKitArea(p)) {
				if (sm.getInKitSelection().contains(p.getUniqueId())) {
					sm.getInKitSelection().remove(p.getUniqueId());
					p.sendMessage("§cYou have left the Kit Creation area.");
					sm.setSpawnInventory(p);
				}
			}
		}
	}
	
	@EventHandler
	public void onLaunch(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getAction() == Action.PHYSICAL) {
			if (e.hasBlock()) {
				if (e.getClickedBlock().getType() == Material.GOLD_PLATE) {
                    p.setVelocity(p.getLocation().getDirection().multiply(3));
                    p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
				}
			}
		}
	}
	
	@EventHandler
	public void onFoodLoss(FoodLevelChangeEvent e) {
		Player p = (Player) e.getEntity();
		if (PracticePots.getInstance().getSpawnManager().isInSpawn(p)) {
			e.setCancelled(true);
		}
	}
}
