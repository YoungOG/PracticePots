package code.BreakMC.practicepots;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import code.BreakMC.practicepots.util.ItemUtill;

public class KitManager {

	Inventory protectionIIMenu;
	Inventory noEnchantsMenu;
	Inventory loadkitsMenu;

	ArrayList<Material> whitelistedMaterials = new ArrayList<Material>();
	
	public KitManager() {
		whitelistedMaterials.add(Material.DIAMOND_HELMET);
		whitelistedMaterials.add(Material.DIAMOND_CHESTPLATE);
		whitelistedMaterials.add(Material.DIAMOND_LEGGINGS);
		whitelistedMaterials.add(Material.DIAMOND_BOOTS);
		whitelistedMaterials.add(Material.DIAMOND_SWORD);
		whitelistedMaterials.add(Material.POTION);
		whitelistedMaterials.add(Material.BAKED_POTATO);
		whitelistedMaterials.add(Material.COOKED_BEEF);
		whitelistedMaterials.add(Material.GOLDEN_CARROT);
		whitelistedMaterials.add(Material.ENDER_PEARL);
		whitelistedMaterials.add(Material.MILK_BUCKET);
		whitelistedMaterials.add(Material.AIR);
	}

	public void showProtectionIIMenu(Player p) {
		protectionIIMenu = Bukkit.createInventory(p, 27, "Protection II");

		final ItemStack helm = ItemUtill.createItem(Material.DIAMOND_HELMET, "§bDiamond Helmet");
		helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		helm.addEnchantment(Enchantment.DURABILITY, 3);

		final ItemStack chest = ItemUtill.createItem(Material.DIAMOND_CHESTPLATE, "§bDiamond Chestplate");
		chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		chest.addEnchantment(Enchantment.DURABILITY, 3);

		final ItemStack leg = ItemUtill.createItem(Material.DIAMOND_LEGGINGS, "§bDiamond Leggings");
		leg.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		leg.addEnchantment(Enchantment.DURABILITY, 3);

		final ItemStack boot = ItemUtill.createItem(Material.DIAMOND_BOOTS, "§bDiamond Boots");
		boot.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		boot.addEnchantment(Enchantment.DURABILITY, 3);

		final ItemStack sword = ItemUtill.createItem(Material.DIAMOND_SWORD, "§bDiamond Sword");
		sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);

		Bukkit.getScheduler().scheduleSyncRepeatingTask(PracticePots.getInstance(), new Runnable() {
			public void run() {
				
				// Armor
				protectionIIMenu.setItem(11, helm);
				protectionIIMenu.setItem(12, chest);
				protectionIIMenu.setItem(13, leg);
				protectionIIMenu.setItem(14, boot);
				protectionIIMenu.setItem(15, sword);
		
				// Potions
				protectionIIMenu.setItem(1, ItemUtill.createItem(Material.POTION, (short) 16421, "§cInstant Health II"));
				protectionIIMenu.setItem(7, ItemUtill.createItem(Material.POTION, (short) 16388, "§2Poison I"));
				protectionIIMenu.setItem(10, ItemUtill.createItem(Material.POTION, (short) 16421, 1, "§cInstant Health II", "§a* Fill Inventory *"));
				protectionIIMenu.setItem(16, ItemUtill.createItem(Material.POTION, (short) 16426, "§5Slowness I"));
				protectionIIMenu.setItem(21, ItemUtill.createItem(Material.POTION, (short) 8226, "§bSpeed II"));
				protectionIIMenu.setItem(22, ItemUtill.createItem(Material.POTION, (short) 8259, "§6Fire Resistance"));
				protectionIIMenu.setItem(23, ItemUtill.createItem(Material.POTION, (short) 8265, "§5Strength I"));
				
				// Food, Enderpearls, Milk
				protectionIIMenu.setItem(3, ItemUtill.createItem(Material.BAKED_POTATO, 64, "§rBaked Potato"));
				protectionIIMenu.setItem(4, ItemUtill.createItem(Material.COOKED_BEEF, 64, "§rSteak"));
				protectionIIMenu.setItem(5, ItemUtill.createItem(Material.GOLDEN_CARROT, 64, "§rGolden Carrot"));
				protectionIIMenu.setItem(19, ItemUtill.createItem(Material.ENDER_PEARL, 16, "§3Ender Pearl"));
				protectionIIMenu.setItem(25, ItemUtill.createItem(Material.MILK_BUCKET, "§rMilk"));
			}
		}, 0L, 5);
		
		p.openInventory(protectionIIMenu);
	}

	public void showNoEnchantsMenu(Player p) {
		noEnchantsMenu = Bukkit.createInventory(p, 27, "No Enchants");
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(PracticePots.getInstance(), new Runnable() {
			public void run() {
				
				// Armor
				noEnchantsMenu.setItem(11, ItemUtill.createItem(Material.DIAMOND_HELMET, "§bDiamond Helmet"));
				noEnchantsMenu.setItem(12, ItemUtill.createItem(Material.DIAMOND_CHESTPLATE, "§bDiamond Chestplate"));
				noEnchantsMenu.setItem(13, ItemUtill.createItem(Material.DIAMOND_LEGGINGS, "§bDiamond Leggings"));
				noEnchantsMenu.setItem(14, ItemUtill.createItem(Material.DIAMOND_BOOTS, "§bDiamond Boots"));
				noEnchantsMenu.setItem(15, ItemUtill.createItem(Material.DIAMOND_SWORD, "§bDiamond Sword"));
				
				// Potions
				noEnchantsMenu.setItem(1, ItemUtill.createItem(Material.POTION, (short) 16421, "§cInstant Health II"));
				noEnchantsMenu.setItem(7, ItemUtill.createItem(Material.POTION, (short) 16388, "§2Poison I"));
				noEnchantsMenu.setItem(10, ItemUtill.createItem(Material.POTION, (short) 16421, 1, "§cInstant Health II", "§a* Fill Inventory *"));
				noEnchantsMenu.setItem(16, ItemUtill.createItem(Material.POTION, (short) 16426, "§5Slowness I"));
				noEnchantsMenu.setItem(21, ItemUtill.createItem(Material.POTION, (short) 8226, "§bSpeed II"));
				noEnchantsMenu.setItem(23, ItemUtill.createItem(Material.POTION, (short) 8259, "§6Fire Resistance"));

				// Food, Enderpearls, Milk
				noEnchantsMenu.setItem(3, ItemUtill.createItem(Material.BAKED_POTATO, 64, "§rBaked Potato"));
				noEnchantsMenu.setItem(4, ItemUtill.createItem(Material.COOKED_BEEF, 64, "§rSteak"));
				noEnchantsMenu.setItem(5, ItemUtill.createItem(Material.GOLDEN_CARROT, 64, "§rGolden Carrot"));
				noEnchantsMenu.setItem(19, ItemUtill.createItem(Material.ENDER_PEARL, 16, "§3Ender Pearl"));
				noEnchantsMenu.setItem(25, ItemUtill.createItem(Material.MILK_BUCKET, "§rMilk"));
			}
		}, 0L, 5);	
		
		p.openInventory(noEnchantsMenu);
	}
	
	public void showLoadKitsMenu(Player p) {
		loadkitsMenu = Bukkit.createInventory(p, 27, "§cLoad kit");
		
		// Kits
		loadkitsMenu.setItem(12, ItemUtill.createItem(Material.DIAMOND_HELMET, "§bProtection II"));
		loadkitsMenu.setItem(14, ItemUtill.createItem(Material.DIAMOND_HELMET, "§bNo Enchants"));
		
		// Panes
		loadkitsMenu.setItem(0, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(1, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(2, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(3, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(4, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(5, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(6, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(7, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(8, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(9, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(10, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(11, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(13, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(15, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(16, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(17, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(18, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(19, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(20, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(21, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(22, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(23, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(24, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(25, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		loadkitsMenu.setItem(26, ItemUtill.createItem(Material.STAINED_GLASS_PANE, (short) 15, 1, " "));
		
		p.openInventory(loadkitsMenu);
	}
	
	public void saveProtectionIIKit(Player p) {
		boolean hasIllegalItems = false;
		DatabaseManager dm = PracticePots.getInstance().getDatabaseManager();
		
		for (int i = 0; i <= p.getInventory().getSize(); i++) {
			ItemStack item = p.getInventory().getItem(i);
			if (item == null) continue;
				if (!whitelistedMaterials.contains(item.getType())) {
					p.getInventory().remove(item);
					hasIllegalItems = true;
				}
				if (item.getType() == Material.POTION) {
					if (item.getDurability() != 16421
							&& item.getDurability() != 16388
							&& item.getDurability() != 16426
							&& item.getDurability() != 8226
							&& item.getDurability() != 8259
							&& item.getDurability() != 8265) {
						p.getInventory().remove(item);
						hasIllegalItems = true;
					}
				}
			}
			
		if (hasIllegalItems)
			p.sendMessage("§cIllegal Items detected. They have been removed.");
		
		p.updateInventory();
			
		dm.setProt2Kit(p);
			
		p.sendMessage("§bProtection II §akit has been saved.");
		return;
	}

	public void saveNoEnchantsKit(Player p) {
		boolean hasIllegalItems = false;
		boolean hasIllegalEnchantments = false;
		DatabaseManager dm = PracticePots.getInstance().getDatabaseManager();
		
		for (int i = 0; i <= p.getInventory().getSize(); i++) {
			ItemStack item = p.getInventory().getItem(i);
			if (item == null) continue;
			if (!whitelistedMaterials.contains(item.getType())) {
				p.getInventory().remove(item);
				hasIllegalItems = true;
			}
			if (item.hasItemMeta()) {
				if (item.getItemMeta().hasEnchants()) {
					hasIllegalEnchantments = true;
					for (Enchantment ench : item.getEnchantments().keySet()) {
						item.removeEnchantment(ench);
					}
				}
			}
			if (item.getType() == Material.POTION) {
				if (item.getDurability() != 16421
						&& item.getDurability() != 16421
						&& item.getDurability() != 16388
						&& item.getDurability() != 16426
						&& item.getDurability() != 8226
						&& item.getDurability() != 8259) {
					p.getInventory().remove(item);
					hasIllegalItems = true;
				}
			}
		}
	
		if (hasIllegalItems)
			p.sendMessage("§cIllegal Items detected. They have been removed.");
		if (hasIllegalEnchantments)
			p.sendMessage("§cIllegal Enchantments detected. They have been removed.");
		
		p.updateInventory();
		
		dm.setNoEnchantKit(p);
		
		p.sendMessage("§bNo Enchants §akit has been saved.");
		return;
	}

	public Inventory getProtectionIIMenu() {
		return protectionIIMenu;
	}

	public Inventory getNoEnchantsMenu() {
		return noEnchantsMenu;
	}
	
	public Inventory getLoadKitsMenu() {
		return loadkitsMenu;
	}
}