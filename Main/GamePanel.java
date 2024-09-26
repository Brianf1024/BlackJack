package Main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

import DeckofCards.Card;
import DeckofCards.Deck;
import Inputs.MouseInputs;
import Inputs.keyboardInputs;
import People.Player;
import UI.Buttons;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 500, yDelta = 600;
    private float xDir = 0.5f, yDir = 0.5f;
    private Random random;
    private static final int CARD_WIDTH = 110;
    private static final int CARD_HEIGHT = 154;
    private Timer timer;
    private Player player;
    private Player dealer;
    private Deck deck;
    
    private Buttons HitButton;

    public GamePanel(Player player, Player dealer) {
        this.player = player;
        this.dealer = dealer;
        this.deck = new Deck();
        this.random = new Random();
        this.mouseInputs = new MouseInputs(this);

        setupPanel();
        addInputListeners();
		initButtons();

    }

    private void setupPanel() {
        setBackground(new Color(140, 22, 22));
        setFocusable(true);
    }

    private void addInputListeners() {
        addKeyListener(new keyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

	private void initButtons() {
	HitButton = new Buttons("HIT", 800,600,100,30);
	}

	  public void drawButtons(Graphics g) {
			 HitButton.draw(g);
	  }
	  
//    public void startAnimation(int startX, int startY, int endX, int endY) {
//        xDelta = startX;
//        yDelta = startY;
//        timer = new Timer(20, e -> {
//            updateCardPosition(endX, endY);
//            repaint();
//        });
//        timer.start();
//    }
//
//    private void updateCardPosition(int endX, int endY) {
//        if (Math.abs(xDelta - endX) < 1 && Math.abs(yDelta - endY) < 1) {
//            xDelta = endX;
//            yDelta = endY;
//            xDir = 0;
//            yDir = 0;
//            timer.stop();
//        } else {
//            xDelta += xDir;
//            yDelta += yDir;
//        }
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     
        drawHiddenCard(g);
        drawPlayerHand(g);
        drawDealerHand(g);
        drawScore(g);
        drawButtons(g);
    
       // g.drawRect(10, 200, 200, 200);
    }
 

    private void drawHiddenCard(Graphics g) {
        Image hiddenCardImg = new ImageIcon(getClass().getResource("/cards/BACK.png")).getImage();
        if (hiddenCardImg != null) {
            g.drawImage(hiddenCardImg, 20, 20, CARD_WIDTH, CARD_HEIGHT, null);
        } else {
            System.out.println("Hidden card image not found.");
        }
    }

    private void drawPlayerHand(Graphics g) {
        int startX = 500;
        int startY = 500;
        int shift = 25;

        ArrayList<Card> hand = player.getHand();
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            if (card != null) {
            	updateCard();
                String imagePath = card.getImagePath();
                Image cardImg = new ImageIcon(getClass().getResource(imagePath)).getImage();
                if (cardImg != null) {
                    g.drawImage(cardImg, (int) xDelta + i * (CARD_WIDTH + shift), (int) yDelta, CARD_WIDTH, CARD_HEIGHT, null);
                } else {
                    System.out.println("Card image not found: " + imagePath);
                }
            } else {
                System.out.println("Card is null.");
            }
        }
    }

    private void drawDealerHand(Graphics g) {
        int startX = 500;
        int startY = 30;
        int shift = 25;
        Image hiddenCardImg = new ImageIcon(getClass().getResource("/cards/BACK.png")).getImage();
        ArrayList<Card> dealerhand = dealer.getHand();
        for (int i = 0; i < dealerhand.size(); i++) {
            Card card = dealerhand.get(i);
            if (card != null) {
                String imagePath = card.getImagePath();
                Image cardImg = new ImageIcon(getClass().getResource(imagePath)).getImage();
                if (cardImg != null) {
                	if(card == dealerhand.get(0)) {
                		g.drawImage(hiddenCardImg, 500, startY, CARD_WIDTH, CARD_HEIGHT, null);
                	}
                	if(card == dealerhand.get(1)) {
                    int x = startX + i * (CARD_WIDTH + shift);
                    g.drawImage(cardImg, x, startY, CARD_WIDTH, CARD_HEIGHT, null);
                	}
                } else {
                    System.out.println("Card image not found: " + imagePath);
                }
            } else {
                System.out.println("Card is null.");
            }
                
        }
    }

    private void drawScore(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setColor(Color.BLACK);
        g.drawString("SCORE: " + player.evaluateHand(), 550, 475);
    }

	private void updateCard() {
	
		yDelta-= yDir;
		if (xDelta == 500 && yDelta == 500) {
			xDelta = 500;
			yDelta = 500;
			xDir =0;
			yDir = 0;
		}
		else {
			
		}
	}
	
}


//
//	private Color getRndColor() {
//		// random.nextInt chooses a random muber between 0 and 255
//		int r = random.nextInt(255);
//		int g = random.nextInt(255);
//		int b = random.nextInt(255);
//	return new Color(r,g,b);
//	}

