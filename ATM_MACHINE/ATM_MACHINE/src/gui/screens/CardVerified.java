package gui.screens;

import java.awt.Graphics;

//Card verified screen
public class CardVerified extends Screen{
	private static final long serialVersionUID = 1L;
	public CardVerified() {
		super();
	}
	//puts title and subtitle for screen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHeader(g, "Card Verified!");
		drawSubtitle(g, "Loading Main Menu...");
	}
}
