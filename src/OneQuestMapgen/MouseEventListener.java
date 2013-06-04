package OneQuestMapgen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import tiles.Tile;

public class MouseEventListener implements MouseListener {

	OneQuestMapgen instance;
	ArrayList<ArrayList<Tile>> map;

	public MouseEventListener(OneQuestMapgen instance) {
		this.instance = instance;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + " , " + e.getY());
		map = instance.getMap();
		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.get(i).size(); j++)
				if (map.get(i).get(j).bounds(e)) {
					map.get(i).get(j).onClicked(instance.getGraphics());
				}
		}

		if (e.getX() <= 10 && e.getY() <= 10) {
			instance.save.onClicked(instance.getGraphics(), instance.map);
		}

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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
