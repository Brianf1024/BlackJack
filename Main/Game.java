package Main;

import java.awt.Graphics;

import DeckofCards.Deck;
//import GameStates.Gamestate;
//import GameStates.Menu;
//import GameStates.Playing;
import People.Player;
import UI.Buttons;

public class Game implements Runnable {

	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private Deck deck;
	private final int FPS_SET = 120;
    private Player player;
    private Player dealer;

   // private Playing playing;
  //  private Menu menu;
    
	// Constructor Head Method of the Class
	public Game() {
		this.player = new Player();
		this.dealer = new Player();
		this.deck = new Deck();
		gamePanel = new GamePanel(player, dealer);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		
		startGame();
		startGameLoop();

	}


	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	  public void startGame() {
	        deck.initDeck();
	        deck.shuffleDeck();

	        // Deal 5 cards to the player
	        for (int i = 0; i < 2; i++) {
	            player.drawFromDeck(deck);;
	            dealer.drawFromDeck(deck);
	        }
	    }
	
	  
	  
//	  public void update() {
//		  
//		  switch(Gamestate.state) {
//		case MENU:
//
//			break;
//		case PLAYING:
//			
//			break;
//		default:
//			
//			break;
//		
//		  }
//		  
//	  }
	
	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		long lastFrame = System.nanoTime();
		long now = System.nanoTime();
		
		int frames = 0;
		long lastCheck =  System.currentTimeMillis(); 
		
		while (true) {

			now = System.nanoTime();
			if (now - lastFrame >= timePerFrame) {

				gamePanel.repaint();
				lastFrame = now;

				frames++;

			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {

				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames);
				frames = 0;
			}

		}
	}

}
