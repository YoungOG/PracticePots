package code.BreakMC.practicepots.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class SaveProt2 extends MapRenderer {

	public void render(MapView map, MapCanvas canvas, Player p) {
		try {
			BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/spii.png"));
			canvas.drawImage(0, 0, image);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
