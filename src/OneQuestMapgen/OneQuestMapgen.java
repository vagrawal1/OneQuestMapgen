package OneQuestMapgen;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

import tiles.SaveButton;
import tiles.Tile;
import tiles.TileSet;

public class OneQuestMapgen extends JApplet{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public static OneQuestMapgen instance;
	
	ArrayList<ArrayList<Tile>> map = new ArrayList<ArrayList<Tile>>();
	TileSet tileSet = new TileSet();
	SaveButton save = null;
	
	public void init(){
		this.setSize(950,600);
	}
	
	public void start(){
		
		MouseEventListener mel = new MouseEventListener(this);
		KeyEventListener kel = new KeyEventListener(this);
		
		addMouseListener(mel);
		addMouseMotionListener(mel);
		addKeyListener(kel);
		
		int tileSize = tileSet.get("grasslands")[1].getHeight();
		
		for (int i = 0; i < getHeight(); i += tileSize) {
			ArrayList<Tile> temp = new ArrayList<Tile>();
			for (int j = 0; j < getWidth(); j += tileSize) {
				temp.add(new Tile(j, i, tileSize, tileSet.get("grasslands")));
			}
			map.add(temp);
		}
		
		save = new SaveButton(0,0,10,tileSet.get("grasslands"));
	}
	
	public void paint(Graphics g){
		
		for (int i = 0; i < map.size(); i++){
			for(int j = 0; j < map.get(i).size(); j++){
				map.get(i).get(j).render(g);
			}				
		}
		save.render(g);		
	}
	
	public void stop(){
	}
	
	public void destroy(){
	}
	
	public ArrayList<ArrayList<Tile>> getMap(){
		return map;
	}
}
