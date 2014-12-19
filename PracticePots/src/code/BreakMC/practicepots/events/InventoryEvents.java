package code.BreakMC.practicepots.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import code.BreakMC.practicepots.PracticePots;
import code.BreakMC.practicepots.DatabaseManager;
import code.BreakMC.practicepots.KitManager;
import code.BreakMC.practicepots.QueueManager;
import code.BreakMC.practicepots.util.ItemUtill;
import code.BreakMC.practicepots.util.serialization.InventorySerialization;

public class InventoryEvents implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		KitManager km = PracticePots.getInstance().getKitManager();
		if (e.getInventory().equals(km.getNoEnchantsMenu()) || e.getInventory().equals(km.getProtectionIIMenu())) {
			if (item != null) {
				if (item.getType() == Material.POTION && item.hasItemMeta() && item.getItemMeta().hasLore()) {
					e.setCancelled(true);
					for (int i = 0; i < 50; i++) {
						p.getInventory().addItem(ItemUtill.createItem(Material.POTION, (short) 16421, 1, "§cInstant Health II"));
					}
				}
			}
		}
	}

	@EventHandler
	public void menuListener(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		QueueManager qm = PracticePots.getInstance().getQueueManager();
		KitManager km = PracticePots.getInstance().getKitManager();
		DatabaseManager dm = PracticePots.getInstance().getDatabaseManager();
		if (e.getInventory().equals(qm.getRankedMenu())) {
			e.setCancelled(true);
			if (item != null) {
				if (item.getType() == Material.DIAMOND_HELMET) {
					p.sendMessage("§aJoined the §bProtection II §aranked queue.");
				} else if (item.getType() == Material.DIAMOND_SWORD) {
					p.sendMessage("§aJoined the §bNo Enchants §aranked queue.");
				}
			}
		}
		else if (e.getInventory().equals(qm.getUnrankedMenu())) {
			e.setCancelled(true);
			if (item != null) {
				if (item.getType() == Material.DIAMOND_HELMET) {
					p.sendMessage("§aJoined the §bProtection II §aunranked queue.");
				} else if (item.getType() == Material.DIAMOND_SWORD) {
					p.sendMessage("§aJoined the §bNo Enchants §aunranked queue.");
				}
			}
		}
		else if (e.getInventory().equals(km.getLoadKitsMenu())) {
			e.setCancelled(true);
			if (item != null) {
				if (item.getType() == Material.DIAMOND_HELMET) {
					if (item.hasItemMeta()) {
						if (item.getItemMeta().hasDisplayName()) {
							if (item.getItemMeta().getDisplayName().contains("Protection")) {
								if (!dm.hasProt2Kit(p)) {
									p.sendMessage("§cYou do not have a Protection II kit saved.");
									return;
								}
								InventorySerialization.setPlayerInventory(p, dm.getProt2Kit(p));
								p.sendMessage("§bProtection II §akit loaded.");
								p.closeInventory();
								p.updateInventory();
							}
							else if (item.getItemMeta().getDisplayName().contains("Enchant")) {
								if (!dm.hasNoEnchantKit(p)) {
									p.sendMessage("§cYou do not have a No Enchants kit saved.");
									return;
								}
								InventorySerialization.setPlayerInventory(p, dm.getNoEnchantKit(p));
								p.sendMessage("§bNo Enchants §akit loaded.");
								p.closeInventory();
								p.updateInventory();
							}
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onQueue(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		QueueManager qm = PracticePots.getInstance().getQueueManager();
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.hasItem()) {
				ItemStack item = e.getItem();
				if (item != null) {
					if (item.getType() == Material.INK_SACK) {
						e.setCancelled(true);
						if (item.getDurability() == 8) {
							qm.showUnrankedMenu(p);
						} else if (item.getDurability() == 10) {
							qm.showRankedMenu(p);
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItemDrop().getItemStack().clone();
		if (item.getType() == Material.INK_SACK) {
			if (PracticePots.getInstance().getSpawnManager().isInSpawn(p)) {
				item.setAmount(p.getInventory().getItemInHand().getAmount() + 1);
				e.getItemDrop().remove();
				p.getInventory().setItem(p.getInventory().getHeldItemSlot(), item);
			}
		}
	}
}
