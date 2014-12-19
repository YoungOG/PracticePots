package code.BreakMC.practicepots.events;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import code.BreakMC.practicepots.PracticePots;

public class StrenghtFix implements Listener {

	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player) {
			Player player = (Player) event.getDamager();
			if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
				for (PotionEffect effect : player.getActivePotionEffects()) {
					if (effect.getType().equals(PotionEffectType.INCREASE_DAMAGE)) {

						int level = effect.getAmplifier() + 1;

						double newDamage = event.getDamage(EntityDamageEvent.DamageModifier.BASE) / (level * 1.3D + 1.0D) + 2 * level;

						double damagePercent = newDamage / event.getDamage(EntityDamageEvent.DamageModifier.BASE);
						try {
							event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, event.getDamage(EntityDamageEvent.DamageModifier.ARMOR) * damagePercent);
						} catch (Exception localException) {
						}
						try {
							event.setDamage(EntityDamageEvent.DamageModifier.MAGIC, event.getDamage(EntityDamageEvent.DamageModifier.MAGIC) * damagePercent);
						} catch (Exception localException1) {
						}
						try {
							event.setDamage(EntityDamageEvent.DamageModifier.RESISTANCE, event.getDamage(EntityDamageEvent.DamageModifier.RESISTANCE) * damagePercent);
						} catch (Exception localException2) {
						}
						try {
							event.setDamage(EntityDamageEvent.DamageModifier.BLOCKING, event.getDamage(EntityDamageEvent.DamageModifier.BLOCKING) * damagePercent);
						} catch (Exception localException3) {
						}
						event.setDamage(EntityDamageEvent.DamageModifier.BASE, newDamage);
						break;
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onHungerLoss(FoodLevelChangeEvent e) {
		if (!PracticePots.getInstance().getSpawnManager().isInSpawn((Player) e.getEntity())) {
			if ((e.getFoodLevel() < ((Player)e.getEntity()).getFoodLevel()) && (new Random().nextInt(100) > 4)) {
				e.setCancelled(true);
			}
		}
	}
}
