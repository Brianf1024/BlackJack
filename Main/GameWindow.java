package Main;

import java.awt.Color;

import javax.swing.JFrame;

// JFrame is the actual frame of the window
public class GameWindow extends JFrame {
	private JFrame jframe;
	
	// arguement allows picture to be in our frame now
	public GameWindow(GamePanel gamePanel) {
		// New JFrame Object Created
		jframe = new JFrame();
		
		jframe.setTitle("Wildcat Poker");
		jframe.setSize(1280, 720);
	    jframe.setBackground(new Color(135,31,31));
		// Sets the Window in the center of the screen
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jframe.add(gamePanel);
		jframe.setVisible(true);

	}
}
