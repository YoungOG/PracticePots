package code.BreakMC.practicepots;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import code.BreakMC.practicepots.commands.ClearCommand;
import code.BreakMC.practicepots.commands.FeedCommand;
import code.BreakMC.practicepots.commands.FlyCommand;
import code.BreakMC.practicepots.commands.GamemodeCommand;
import code.BreakMC.practicepots.commands.HealCommand;
import code.BreakMC.practicepots.commands.InvseeCommand;
import code.BreakMC.practicepots.commands.LagCommand;
import code.BreakMC.practicepots.commands.SpawnCommand;
import code.BreakMC.practicepots.commands.SpeedCommand;
import code.BreakMC.practicepots.commands.TestCommand;
import code.BreakMC.practicepots.events.DeathEvents;
import code.BreakMC.practicepots.events.InventoryEvents;
import code.BreakMC.practicepots.events.ItemDropEvents;
import code.BreakMC.practicepots.events.ItemFrameListener;
import code.BreakMC.practicepots.events.JoinEvent;
import code.BreakMC.practicepots.events.PlayerEvents;
import code.BreakMC.practicepots.events.PortalEvents;
import code.BreakMC.practicepots.events.SpawnEvents;
import code.BreakMC.practicepots.events.StrenghtFix;
import code.BreakMC.practicepots.events.WorldEvents;
import code.BreakMC.practicepots.util.CreateNoEnch;
import code.BreakMC.practicepots.util.CreateProt2;
import code.BreakMC.practicepots.util.Lag;
import code.BreakMC.practicepots.util.SaveNoEnch;
import code.BreakMC.practicepots.util.SaveProt2;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class PracticePots extends JavaPlugin {

	private static PracticePots instance;
	private DatabaseManager dm;
	private KitManager km;
	private SpawnManager sm;
	private QueueManager qm;
	private FFAManager fm;
	
	private boolean isLocked = true;

	public void onEnable() {
		instance = this;

		dm = new DatabaseManager();
		km = new KitManager();
		sm = new SpawnManager();
		qm = new QueueManager();
		fm = new FFAManager();
		
		getServer().getPluginManager().registerEvents(new ItemFrameListener(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);
		getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
		getServer().getPluginManager().registerEvents(new InvseeCommand(), this);
		getServer().getPluginManager().registerEvents(new DeathEvents(), this);
		getServer().getPluginManager().registerEvents(new ItemDropEvents(), this);
		getServer().getPluginManager().registerEvents(new PortalEvents(), this);
		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
		getServer().getPluginManager().registerEvents(new StrenghtFix(), this);
		getServer().getPluginManager().registerEvents(new WorldEvents(), this);
		getServer().getPluginManager().registerEvents(new SpawnEvents(), this);

		getCommand("test").setExecutor(new TestCommand());
		getCommand("invsee").setExecutor(new InvseeCommand());
		getCommand("gamemode").setExecutor(new GamemodeCommand());
		getCommand("clear").setExecutor(new ClearCommand());
		getCommand("speed").setExecutor(new SpeedCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("feed").setExecutor(new FeedCommand());
		getCommand("lag").setExecutor(new LagCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		
		setupFrames();
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
		
		Bukkit.getScheduler().runTaskLater(this, new Runnable() {
			public void run() {
				isLocked = false;
			}
		}, 5*20);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				if (Bukkit.getWorld("world").getTime() >= 13000) {
					Bukkit.getWorld("world").setTime(0);
				}
			}
		}, 0, 5*20);
	}
	
	public void setupFrames() {
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				Location loc1 = new Location(Bukkit.getWorld("world"), 502.5, 9.5, 545.9375);
				Location loc2 = new Location(Bukkit.getWorld("world"), 501.5, 9.5, 545.9375);
				Location loc3 = new Location(Bukkit.getWorld("world"), 499.5, 9.5, 545.9375);
				Location loc4 = new Location(Bukkit.getWorld("world"), 498.5, 9.5, 545.9375);
				for (Entity ents : loc1.getChunk().getEntities()) {
					if (ents.getLocation().equals(loc1)) {
						if (ents instanceof ItemFrame) {
							ItemFrame itemf = (ItemFrame) ents;
							if (itemf.getItem().getType() == Material.MAP) {
								
								MapView map = Bukkit.getMap(itemf.getItem().getDurability());
								
								for (MapRenderer mr : map.getRenderers()) {
									map.removeRenderer(mr);
								}
								
								map.addRenderer(new CreateProt2());
							}
						}
					}
					else if (ents.getLocation().equals(loc2)) {
						if (ents instanceof ItemFrame) {
							ItemFrame itemf = (ItemFrame) ents;
							if (itemf.getItem().getType() == Material.MAP) {
								
								MapView map = Bukkit.getMap(itemf.getItem().getDurability());
								
								for (MapRenderer mr : map.getRenderers()) {
									map.removeRenderer(mr);
								}
								
								map.addRenderer(new SaveProt2());
							}
						}
					}
					else if (ents.getLocation().equals(loc3)) {
						if (ents instanceof ItemFrame) {
							ItemFrame itemf = (ItemFrame) ents;
							if (itemf.getItem().getType() == Material.MAP) {
								
								MapView map = Bukkit.getMap(itemf.getItem().getDurability());
								
								for (MapRenderer mr : map.getRenderers()) {
									map.removeRenderer(mr);
								}
								
								map.addRenderer(new CreateNoEnch());
							}
						}
					}
					else if (ents.getLocation().equals(loc4)) {
						if (ents instanceof ItemFrame) {
							ItemFrame itemf = (ItemFrame) ents;
							if (itemf.getItem().getType() == Material.MAP) {
								
								MapView map = Bukkit.getMap(itemf.getItem().getDurability());
								
								for (MapRenderer mr : map.getRenderers()) {
									map.removeRenderer(mr);
								}
								
								map.addRenderer(new SaveNoEnch());
							}
						}
					}
				}
			}
		}, 3*20);
	}

	public static PracticePots getInstance() {
		return instance;
	}

	public DatabaseManager getDatabaseManager() {
		return dm;
	}

	public KitManager getKitManager() {
		return km;
	}

	public SpawnManager getSpawnManager() {
		return sm;
	}

	public QueueManager getQueueManager() {
		return qm;
	}

	public FFAManager getFFAManager() {
		return fm;
	}
	
	public Boolean isServerLocked() {
		return isLocked;
	}
	
	public WorldGuardPlugin getWorldGuard() {
		Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
		if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))) {
			Bukkit.getPluginManager().disablePlugin(this);
			return null;
        }
        return (WorldGuardPlugin)plugin;
    }
}
