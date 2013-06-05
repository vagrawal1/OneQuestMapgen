	package tiles;
	
	import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
	
	@SuppressWarnings("serial")
	public class Tile extends Square {
		
		BufferedImage[] tiles;
		int tileValue = 0;
		
		public Tile (int x, int y, int size, BufferedImage[] tileSet){
			super(x,y,size);
			tiles = tileSet;
		}
	
		public void render(Graphics g) {
			
			g.drawImage(tiles[tileValue], getX(), getY(), getDimension(), getDimension(), null);		
		}
	
		public void onClicked(Graphics g, MouseEvent e) {
			
			switch (e.getModifiers()){
			case InputEvent.BUTTON1_MASK:
				tileValue++;
				break;
			case InputEvent.BUTTON3_MASK:
				if (tileValue > 0 )
					tileValue--;
				break;					
			}
			
			System.out.println(tileValue);
			g.drawImage(tiles[tileValue], getX(), getY(), getDimension(), getDimension(), null);
		}
		
		public boolean bounds(MouseEvent e){
			if (e.getX() <= getX() + getDimension()  && e.getX() >= getX() && e.getY() <= getY() + getDimension() && e.getY() >= getY())
				return true;
			return false;
		}
	}
