package gui.screens;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

//card inserted screen
public class CardInserted extends Screen {
	int inc = 5;
	
	private static final long serialVersionUID = 1L;
	
	public CardInserted() {
		super();
	}
	
	@Override
	public void keyFrame() {
		inc = inc + 2;
	}
	
	//Sets tital and subtitle for verifiing screen 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHeader(g, "Please Wait");
		drawSubtitle(g, "Do Not Remove Card");
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		drawLoadingAnimation(g, inc);
	}
}
