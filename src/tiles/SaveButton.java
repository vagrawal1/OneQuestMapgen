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
				out = new PrintWriter(new FileWriter("C:\\Users\\Vasu\\Desktop\\map.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			for(int i = 0; i < map.size(); i++){
				for(int j = 0; j < map.get(i).size(); j++){
					out.print(map.get(i).get(j).tileValue);
				}
				out.println();
			}
			
	//		int numberCompleted = 1;
	//		for (int i = 0; i < map.size(); i++){
	//			if (numberCompleted == 0){
	//				out.print(map.get(i).tileValue);
	//			}	
	//			
	//			if (numberCompleted != 0 && numberCompleted%36 != 0)
	//				out.print(map.get(i).tileValue);
	//			else //if (numberCompleted %36 == 0 && numberCompleted != 0)
	//				out.println(map.get(i).tileValue);
	//			
	//			numberCompleted++;
	//			
	//		}
	
			out.close();
			
			g.drawImage(tiles[tileValue], getX(), getY(), getDimension(), getDimension(), null);
		}
		
		public boolean bounds(MouseEvent e){
			if (e.getX() <= getX() + getDimension()  && e.getX() >= getX() && e.getY() <= getY() + getDimension() && e.getY() >= getY())
				return true;
			return false;
		}
	}
