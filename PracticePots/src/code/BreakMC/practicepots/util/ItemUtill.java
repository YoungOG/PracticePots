package code.BreakMC.practicepots.util;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItemUtill {

	public static ItemStack createItem(Material material, String displayname) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayname);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack createItem(Material material, int amount, String displayname) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayname);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack createItem(Material material, short data, String displayname) {
		ItemStack item = new ItemStack(material);
		item.setDurability(data);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayname);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack createItem(Material material, String displayname, String... lore) {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayname);
		ArrayList<String> Lore = new ArrayList<String>();
		for (String loreString : lore)
			Lore.add(loreString);
		meta.setLore(Lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack createItem(Material material, int amount, String displayname, String... lore) {
		ItemStack item = new ItemStack(material, amount);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayname);
		ArrayList<String> Lore = new ArrayList<String>();
		for (String loreString : lore)
			Lore.add(loreString);
		meta.setLore(Lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack createItem(Material material, short data, int amount, String displayname, String... lore) {
		ItemStack item = new ItemStack(material, amount);
		item.setDurability(data);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(displayname);
		ArrayList<String> Lore = new ArrayList<String>();
		for (String loreString : lore)
			Lore.add(loreString);
		meta.setLore(Lore);
		item.setItemMeta(meta);
		return item;
	}

	public static String getPotionName(PotionEffectType pet) {
		if (pet.equals(PotionEffectType.SPEED)) {
			return "Speed";
		} else if (pet.equals(PotionEffectType.SLOW)) {
			return "Slowness";
		} else if (pet.equals(PotionEffectType.FAST_DIGGING)) {
			return "Haste";
		} else if (pet.equals(PotionEffectType.SLOW_DIGGING)) {
			return "Fatigue";
		} else if (pet.equals(PotionEffectType.INCREASE_DAMAGE)) {
			return "Strenght";
		} else if (pet.equals(PotionEffectType.JUMP)) {
			return "Jump Boost";
		} else if (pet.equals(PotionEffectType.CONFUSION)) {
			return "Confusion";
		} else if (pet.equals(PotionEffectType.REGENERATION)) {
			return "Regeneration";
		} else if (pet.equals(PotionEffectType.DAMAGE_RESISTANCE)) {
			return "Resistance";
		} else if (pet.equals(PotionEffectType.FIRE_RESISTANCE)) {
			return "Fire Resistance";
		} else if (pet.equals(PotionEffectType.WATER_BREATHING)) {
			return "Water Breathing";
		} else if (pet.equals(PotionEffectType.INVISIBILITY)) {
			return "Invisibility";
		} else if (pet.equals(PotionEffectType.BLINDNESS)) {
			return "Blindness";
		} else if (pet.equals(PotionEffectType.NIGHT_VISION)) {
			return "Night Vision";
		} else if (pet.equals(PotionEffectType.HUNGER)) {
			return "Hunger";
		} else if (pet.equals(PotionEffectType.WEAKNESS)) {
			return "Weakness";
		} else if (pet.equals(PotionEffectType.POISON)) {
			return "Poison";
		} else if (pet.equals(PotionEffectType.WITHER)) {
			return "Wither";
		} else {
			return null;
		}
	}

	public static String getPotionAmplifier(PotionEffect pe) {
		if (pe.getAmplifier() == 0) {
			return "I";
		} else if (pe.getAmplifier() == 1) {
			return "II";
		} else if (pe.getAmplifier() == 2) {
			return "III";
		} else if (pe.getAmplifier() == 3) {
			return "IV";
		} else if (pe.getAmplifier() == 4) {
			return "V";
		} else {
			return null;
		}
	}

	public static int getPotionDuration(PotionEffect pe) {
		return pe.getDuration() / 20;
	}
}