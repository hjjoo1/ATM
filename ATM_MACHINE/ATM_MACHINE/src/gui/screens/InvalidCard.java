package gui.screens;

import java.awt.Graphics;

//Screen for invalid card
public class InvalidCard extends Screen{
	private static final long serialVersionUID = 1L;
	public InvalidCard() {
		super();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHeader(g, "Invalid Card");
		drawSubtitle(g, "Sorry, we could not verify your card.");
	}
}
