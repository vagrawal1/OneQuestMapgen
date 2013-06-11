package tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;

@SuppressWarnings("serial")
public class SaveButton extends Square {
	
	BufferedImage[] tiles;
	int tileValue = 0;
    private Object lock = new Object();
	
	public SaveButton (int x, int y, int size, BufferedImage[] tileSet){
		super(x,y,size);
		tiles = tileSet;
	}

	public void render(Graphics g) {
        // Dunno if it's multithreaded
        synchronized (lock) {
            g.setColor(new Color (255,0,0));
            g.fillRect(getX(),getY(),10,10);
        }
	}

	public void onClicked(Graphics g, ArrayList<ArrayList<Tile>> map) {
		
		try {
            DataOutputStream dos = new DataOutputStream(new GZIPOutputStream(new FileOutputStream("map.q")));
            // Map version
            dos.writeByte(3);

            dos.writeShort(map.size());
            dos.writeShort(map.get(0).size());

            for (int i = 0; i < map.size(); i++) {
                for (int k = 0; k < map.get(0).size(); k++) {
                    dos.writeByte((byte) map.get(i).get(k).tileValue);
                }
            }

            dos.flush();
            dos.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
		g.drawImage(tiles[tileValue], getX(), getY(), getDimension(), getDimension(), null);
	}
}
