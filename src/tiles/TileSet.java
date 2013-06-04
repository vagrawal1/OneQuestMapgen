package tiles;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;

public final class TileSet {
	
	ConcurrentHashMap<String, BufferedImage[]> container = new ConcurrentHashMap<String, BufferedImage[]>(11);
	BufferedImage[] grasslands = new BufferedImage[11];
	
	public TileSet(){
		
		boolean toAdd = true;
		
		try {	
			grasslands[0] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/GrassBlank_zpse99de845.png"));
			grasslands[1] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/4WayTile_zps49ebbeea.png"));
			grasslands[2] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/LineHorizontal_zpsc7bd45d5.png"));
			grasslands[3] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/LineVertical_zps9719b63f.png"));
			grasslands[4] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/TShapeTop_zpsa4b2aaa1.png"));
			grasslands[5] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/TShapeBottom_zpsab2eebae.png"));
			grasslands[6] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/TShapeLeft_zpsa475a904.png"));
			grasslands[7] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/TShapeRight_zps12dd3e4b.png"));
			grasslands[8] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/TopEnd_zps4b695dbe.png"));	
			grasslands[9] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/BottomEnd_zpscd0bb870.png"));
			grasslands[10] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/LeftEnd_zps27be6c45.png"));
			grasslands[11] = ImageIO.read(new URL("http://i675.photobucket.com/albums/vv118/va023/OneQuest/RightEnd_zpsd12f9608.png"));			
		}
	
		catch (Exception e) {
			System.out.println("Unable to load resources for Grasslands");
		}

		for (int i = 0; i < grasslands.length; i++)
			if (grasslands[i].getWidth() != grasslands[i].getHeight()) {
				System.out.println("Error, tiles are not square. Grasslands has not been added.");
				toAdd = false;
			}

		if (toAdd) {
			container.put("grasslands".toLowerCase(), grasslands);
		}
	}

	public BufferedImage[] get(String s) {
		return container.get(s.toLowerCase());
	}
}
