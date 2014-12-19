package code.BreakMC.practicepots.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import code.BreakMC.practicepots.PracticePots;
import code.BreakMC.practicepots.FFAManager;

public class PortalEvents implements Listener {

	@EventHandler
	public void portalEvent(PlayerPortalEvent e) {
		Player p = e.getPlayer();
		FFAManager fm = PracticePots.getInstance().getFFAManager();
		e.setCancelled(true);
		if (e.getCause() == TeleportCause.END_PORTAL) {
			fm.showEndFFAMenu(p);
			return;
		} else if (e.getCause() == TeleportCause.NETHER_PORTAL) {

		}
	}
}
