package OneQuestMapgen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListener implements KeyListener{

	OneQuestMapgen instance;
	public KeyEventListener(OneQuestMapgen instance){
		
		this.instance = instance;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		System.out.println(arg0.getKeyChar());
	}

}
