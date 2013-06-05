package tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SaveButton extends Square {
	
	BufferedImage[] tiles;
	int tileValue = 0;
	
	public SaveButton (int x, int y, int size, BufferedImage[] tileSet){
		super(x,y,size);
		tiles = tileSet;
	}

	public void render(Graphics g) {
		g.setColor(new Color (255,0,0));
		g.fillRect(getX(),getY(),10,10);		
	}

	public void onClicked(Graphics g, ArrayList<ArrayList<Tile>> map) {
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("map.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		for(int i = 0; i < map.size(); i++){
			for(int j = 0; j < map.get(i).size(); j++){
				out.print(toString(map.get(i).get(j).tileValue));
			}
			out.println();
		}
		
		out.close();
		
		g.drawImage(tiles[tileValue], getX(), getY(), getDimension(), getDimension(), null);
	}
	
	public String toString(int v) {
		
		String toReturn = "";

		switch (v){
			case 10: toReturn = "a"; break;
			case 11: toReturn = "b"; break;
			case 12: toReturn = "c"; break;
			case 13: toReturn = "d"; break;
			case 14: toReturn = "e"; break;
			case 15: toReturn = "f"; break;
			case 16: toReturn = "g"; break;
			case 17: toReturn = "h"; break;
			case 18: toReturn = "i"; break;
			case 19: toReturn = "j"; break;
			case 20: toReturn = "k"; break;
			case 21: toReturn = "l"; break;
			case 22: toReturn = "m"; break;
			case 23: toReturn = "n"; break;
			case 24: toReturn = "o"; break;
			case 25: toReturn = "p"; break;
			case 26: toReturn = "q"; break;
			case 27: toReturn = "r"; break;
			case 28: toReturn = "s"; break;
			case 29: toReturn = "t"; break;
			case 30: toReturn = "u"; break;
			case 31: toReturn = "v"; break;
			case 32: toReturn = "w"; break;
			case 33: toReturn = "x"; break;
			case 34: toReturn = "y"; break;
			case 35: toReturn = "z"; break;		
			default: toReturn = Integer.toString(v); break;
		}
		
		return toReturn;
	}

	public boolean bounds(MouseEvent e){
		if (e.getX() <= getX() + getDimension()  && e.getX() >= getX() && e.getY() <= getY() + getDimension() && e.getY() >= getY())
			return true;
		return false;
	}
}
