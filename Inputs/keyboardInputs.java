package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class keyboardInputs implements KeyListener {

	private GamePanel gamePanel;
	
	public keyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {

		case KeyEvent.VK_W:
			//gamePanel.changeYDelta(-5);
			break;

		case KeyEvent.VK_A:
			//gamePanel.changeXDelta(-5);
			break;

		case KeyEvent.VK_S:
			//gamePanel.changeYDelta(5);
			break;

		case KeyEvent.VK_D:
			//gamePanel.changeXDelta(5);
			break;

		}
	}

}
