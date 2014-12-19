package code.BreakMC.practicepots;

import java.util.UUID;

import org.bukkit.entity.Player;

import redis.clients.jedis.Jedis;
import code.BreakMC.practicepots.util.serialization.InventorySerialization;

public class DatabaseManager {

	public Jedis jc = new Jedis("localhost");

	public DatabaseManager() {
		jc.auth("trAdRApAw2sP834e4ReJAYemAhetrEcr");
		jc.connect();
	}
	
	public void setProt2Kit(Player p) {
		UUID id = p.getUniqueId();
		String i = InventorySerialization.serializePlayerInventoryAsString(p.getInventory());
		jc.set("{prot}" + id.toString(), i);
	}

	public String getProt2Kit(Player p) {
		return jc.exists("{prot}" + p.getUniqueId().toString()) ? jc.get("{prot}" + p.getUniqueId().toString()) : null;
	}

	public boolean hasProt2Kit(Player p) {
		UUID id = p.getUniqueId();
		if (jc.exists("{prot}" + id.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public void setNoEnchantKit(Player p) {
		UUID id = p.getUniqueId();
		String i = InventorySerialization.serializePlayerInventoryAsString(p.getInventory());
		jc.set("{noench}" + id.toString(), i);
	}

	public String getNoEnchantKit(Player p) {
		return jc.exists("{noench}" + p.getUniqueId().toString()) ? jc.get("{noench}" + p.getUniqueId().toString()) : null;
	}

	public boolean hasNoEnchantKit(Player p) {
		UUID id = p.getUniqueId();
		if (jc.exists("{noench}" + id.toString())) {
			return true;
		} else {
			return false;
		}
	}
}