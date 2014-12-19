package code.BreakMC.practicepots;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;

import code.BreakMC.practicepots.util.ItemUtill;

public class SpawnManager {

	Location spawn = new Location(Bukkit.getWorld("world"), 500.5, 10.0, 500.5);
	Location spawnC1 = new Location(Bukkit.getWorld("world"), 448.5, 0.0, 552.5);
	Location spawnC2 = new Location(Bukkit.getWorld("world"), 552.5, 256.0, 443.5);
	
	Location kitAreaC1 = new Location(Bukkit.getWorld("world"), 495.5, 0, 539.5);
	Location kitAreaC2 = new Location(Bukkit.getWorld("world"), 505.5, 256, 547.5);
	
	ArrayList<UUID> inKitSelection = new ArrayList<UUID>();
	
	public SpawnManager() {}

	public void setSpawnInventory(Player p) {
		clearInventory(p);
		managePlayer(p);

		p.getInventory().setItem(7, ItemUtill.createItem(Material.INK_SACK, (short) 8, 1, "§aUnranked 1v1 Queue", "§7Right-Click to choose kit"));
		p.getInventory().setItem(8, ItemUtill.createItem(Material.INK_SACK, (short) 10, 1, "§bRanked 1v1 Queue", "§7Right-Click to choose kit"));

		p.updateInventory();
	}

	public void clearInventory(Player p) {
		PlayerInventory inv = p.getInventory();

		inv.clear();
		inv.setHelmet(null);
		inv.setChestplate(null);
		inv.setLeggings(null);
		inv.setBoots(null);

		p.updateInventory();
	}

	public void managePlayer(Player p) {
		for (PotionEffect pe : p.getActivePotionEffects()) {
			p.removePotionEffect(pe.getType());
		}

		p.setHealth(20.0);
		p.setFoodLevel(20);
		p.setFireTicks(0);
		p.setFallDistance(0.0F);
		p.setWalkSpeed(0.2F);
		p.setGameMode(GameMode.SURVIVAL);
		p.setExp(0.0F);
		p.setLevel(0);
	}
	
	public void teleport(Player p, Location l) {
		l.getChunk().load();
		p.teleport(l);
	}
	
	public Location getSpawn() {
		return spawn;
	}
	
	public List<UUID> getInKitSelection() {
		return inKitSelection;
	}
	
	public boolean isInSpawn(Player p) {
		int x1 = Math.min(spawnC1.getBlockX(), spawnC2.getBlockX());
		int z1 = Math.min(spawnC1.getBlockZ(), spawnC2.getBlockZ());
		int x2 = Math.max(spawnC1.getBlockX(), spawnC2.getBlockX());
		int z2 = Math.max(spawnC1.getBlockZ(), spawnC2.getBlockZ());
			
		return p.getLocation().getX() >= x1 && p.getLocation().getX() <= x2 && p.getLocation().getZ() >= z1 && p.getLocation().getZ() <= z2;
	}
	
	public boolean isInKitArea(Player p) {
		int x1 = Math.min(kitAreaC1.getBlockX(), kitAreaC2.getBlockX());
		int z1 = Math.min(kitAreaC1.getBlockZ(), kitAreaC2.getBlockZ());
		int x2 = Math.max(kitAreaC1.getBlockX(), kitAreaC2.getBlockX());
		int z2 = Math.max(kitAreaC1.getBlockZ(), kitAreaC2.getBlockZ());
			
		return p.getLocation().getX() >= x1 && p.getLocation().getX() <= x2 && p.getLocation().getZ() >= z1 && p.getLocation().getZ() <= z2;
	}
}
