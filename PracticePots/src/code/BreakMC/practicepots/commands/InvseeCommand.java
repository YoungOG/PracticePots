package code.BreakMC.practicepots.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import code.BreakMC.practicepots.PracticePots;
import code.BreakMC.practicepots.util.ItemUtill;

public class InvseeCommand implements CommandExecutor, Listener {

	public HashMap<UUID, Integer> TID = new HashMap<UUID, Integer>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cOnly players can use this command.");
			return false;
		}

		Player p = (Player) sender;

		if (!p.hasPermission("avalon.invsee")) {
			p.sendMessage("§fUnknown command. Type \"/help\" for help.");
			return false;
		}

		if (args.length == 1) {
			if (Bukkit.getPlayer(args[0]) == null) {
				p.sendMessage("That is not a valid player.");
				return false;
			}

			startInvsee(p, Bukkit.getPlayer(args[0]));
		} else {
			p.sendMessage("§cUsage: /invsee <player>");
			return false;
		}
		return false;
	}

	public void startInvsee(final Player p, final Player target) {
		final Inventory inv = Bukkit.createInventory(p, 45, "§6§l" + target.getName());
		final int id = Bukkit.getScheduler().scheduleSyncRepeatingTask(PracticePots.getInstance(), new Runnable() {
			public void run() {
				if (target != null) {
					inv.setContents(target.getInventory().getContents());

					inv.setItem(36, target.getInventory().getHelmet());
					inv.setItem(37, target.getInventory().getChestplate());
					inv.setItem(38, target.getInventory().getLeggings());
					inv.setItem(39, target.getInventory().getBoots());

//					inv.setItem(42, ItemUtill.createItem(Material.SPECKLED_MELON, (int) ((double) target.getHealth()), "§cHealth", "§b" + Math.floor(target.getHealth())));
					inv.setItem(43, ItemUtill.createItem(Material.COOKED_BEEF, target.getFoodLevel(), "§6Hunger", "§b" + target.getFoodLevel()));

					ItemStack powder = ItemUtill.createItem(Material.NETHER_STALK, "§aPotion Effects");
					ItemMeta im = powder.getItemMeta();
					ArrayList<String> lore = new ArrayList<String>();
					if (p.getActivePotionEffects().size() > 0) {
						for (PotionEffect pe : p.getActivePotionEffects()) {
							lore.add("§b" + ItemUtill.getPotionName(pe.getType()) + " " + ItemUtill.getPotionAmplifier(pe) + "§7: " + convertSecondsToMinutes(ItemUtill.getPotionDuration(pe)));
						}
					} else {
						lore.add("§bNone");
					}
					im.setLore(lore);
					powder.setItemMeta(im);

					inv.setItem(44, powder);
				}
			}
		}, 0L, 3);
		p.openInventory(inv);
		TID.put(p.getUniqueId(), id);
	}

	public void stopScheduler(Player p) {
		if (TID.containsKey(p.getUniqueId())) {
			int id = TID.get(p.getUniqueId());
			Bukkit.getScheduler().cancelTask(id);
			TID.remove(p.getUniqueId());
		}
	}

	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		if (TID.containsKey(e.getPlayer().getUniqueId())) {
			stopScheduler((Player) e.getPlayer());
		}
	}

	public static String convertSecondsToMinutes(int time) {
		int minutes = time / 60;
		int seconds = time % 60;
		String disMinu = "" + minutes;
		String disSec = (seconds < 10 ? "0" : "") + seconds;
		String formattedTime = disMinu + ":" + disSec;
		return formattedTime;
	}
}
