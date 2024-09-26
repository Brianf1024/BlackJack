package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Buttons {
	private int x, y, width, height;
	private String text;
	
	private Rectangle bounds;
	
	public Buttons(String text, int x, int y, int width, int height) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		initBounds();
	}
	
	private void initBounds() {
		this.bounds = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		
		// body
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		
		// border
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		
		// Text
		drawText(g);

		
	}
	
	public void drawText(Graphics g) {
		int w = g.getFontMetrics().stringWidth(text);
		int h = g.getFontMetrics().getHeight();
		
		g.drawString("HIT", x - w / 2 + width / 2, (y + h /2 + h/2) - 5);
		
	}
	
	public Rectangle getBounds() {
		
		return bounds;
	}
	
	
	
}
