package code.BreakMC.practicepots;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import code.BreakMC.practicepots.util.ItemUtill;

public class QueueManager {

	Inventory rankedMenu;
	Inventory unrankedMenu;

	public QueueManager() {}

	public void addToRankedQueue(Player p) {
		
	}
	
	public void addToUnRankedQueue(Player p) {
		
	}

	public void showRankedMenu(Player p) {
		rankedMenu = Bukkit.createInventory(p, 9, "§b§lKit Selection");

		rankedMenu.setItem(3, ItemUtill.createItem(Material.DIAMOND_HELMET, 1, "§bProtection II", "§aIn Queue§e: null", "§dElo§5: null"));
		rankedMenu.setItem(5, ItemUtill.createItem(Material.DIAMOND_SWORD, 1, "§bNo Enchants", "§aIn Queue§e: null", "§dElo§5: null"));

		rankedMenu.setItem(0, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		rankedMenu.setItem(1, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		rankedMenu.setItem(2, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		rankedMenu.setItem(4, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		rankedMenu.setItem(6, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		rankedMenu.setItem(7, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		rankedMenu.setItem(8, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));

		p.openInventory(rankedMenu);
	}

	public void showUnrankedMenu(Player p) {
		unrankedMenu = Bukkit.createInventory(p, 9, "§b§lKit Selection");

		unrankedMenu.setItem(3, ItemUtill.createItem(Material.DIAMOND_HELMET, 1, "§bProtection II", "§aIn Queue§e: null"));
		unrankedMenu.setItem(5, ItemUtill.createItem(Material.DIAMOND_SWORD, 1, "§bNo Enchants", "§aIn Queue§e: null"));

		unrankedMenu.setItem(0, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		unrankedMenu.setItem(1, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		unrankedMenu.setItem(2, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		unrankedMenu.setItem(4, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		unrankedMenu.setItem(6, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		unrankedMenu.setItem(7, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		unrankedMenu.setItem(8, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));

		p.openInventory(unrankedMenu);
	}

	public Inventory getRankedMenu() {
		return rankedMenu;
	}

	public Inventory getUnrankedMenu() {
		return unrankedMenu;
	}
}
