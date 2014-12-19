package code.BreakMC.practicepots;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import code.BreakMC.practicepots.util.ItemUtill;

public class FFAManager {

	Inventory endFFA;

	public FFAManager() {
	}

	public void showEndFFAMenu(Player p) {
		endFFA = Bukkit.createInventory(p, 9, "§b§lINVENTORY NAME");

		endFFA.setItem(5, ItemUtill.createItem(Material.ENCHANTMENT_TABLE, 1, "§bNo Enchants", "§7Fight at End FFA with the No Enchants kit."));

		endFFA.setItem(0, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		endFFA.setItem(1, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		endFFA.setItem(2, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		endFFA.setItem(4, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		endFFA.setItem(6, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		endFFA.setItem(7, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		endFFA.setItem(8, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));

		p.openInventory(endFFA);
	}

	public Inventory getEndFFAMenu() {
		return endFFA;
	}
}
