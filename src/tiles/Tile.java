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

	public void onDragged(Graphics g, MouseEvent e, int mouseLastX, int mouseLastY) {
		
		switch (e.getModifiers()){
		case InputEvent.BUTTON1_MASK: {
			if (!isEqualT(mouseLastX, e.getX(), 1)
					&& isEqualT(mouseLastY, e.getY(), 8)) {
				System.out.println("dragged");
				if (tileValue == 3)
					tileValue = 1;
				else
					tileValue = 2;
			}

			if (!isEqualT(mouseLastY, e.getY(), 1)
					&& isEqualT(mouseLastX, e.getX(), 8)) {
				System.out.println("dragged");
				if (tileValue == 2)
					tileValue = 1;
				else
					tileValue = 3;
			}
		}
			break;
		case InputEvent.BUTTON3_MASK: {
			tileValue = 0;
		} break;
		default: break;
		}
		

		
		g.drawImage(tiles[tileValue], getX(), getY(), getDimension(), getDimension(), null);
		
	}
	
	public boolean isEqualT(double value1, double value2, double tolerance){
		if (Math.abs(value1 - value2) <= tolerance)
			return true;
		return false;
	}
}
