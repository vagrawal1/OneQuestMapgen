package OneQuestMapgen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import tiles.Tile;

public class MouseEventListener implements MouseListener, MouseMotionListener {

	OneQuestMapgen instance;
	ArrayList<ArrayList<Tile>> map;
	int mouseLastX = 0;
	int mouseLastY = 0;

	public MouseEventListener(OneQuestMapgen instance) {
		this.instance = instance;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX() + " , " + e.getY());
		map = instance.getMap();
		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.get(i).size(); j++)
				if (map.get(i).get(j).bounds(e)) {
					map.get(i).get(j).onClicked(instance.getGraphics(), e, map, i, j);
				}
		}

		if (e.getX() <= 10 && e.getY() <= 10) {
			instance.save.onClicked(instance.getGraphics(), instance.map);
		}
		
		mouseLastX = e.getX();
		mouseLastY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		System.out.println(e.getX() + " , " + e.getY());
		map = instance.getMap();
		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.get(i).size(); j++)
				if (map.get(i).get(j).bounds(e)) {
					map.get(i).get(j).onDragged(instance.getGraphics(), e, mouseLastX, mouseLastY);
				}
		}

		if (e.getX() <= 10 && e.getY() <= 10) {
			instance.save.onClicked(instance.getGraphics(), instance.map);
		}
		
		mouseLastX = e.getX();
		mouseLastY = e.getY();	
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("Mouse Moved: " + arg0.getX() + " , " + arg0.getY());
		
	}

}
