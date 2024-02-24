package gui.screens;

import java.awt.Graphics;

public class Withdraw_CashAmount extends Screen {
	private static final long serialVersionUID = 1L;
	public Withdraw_CashAmount() {
		super();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHeader(g, "Withdraw Cash ");
		drawSubtitle(g, "Select Withdraw Amount");
		g.drawString("Button 1: $10", 75,200);
		g.drawString("Button 2: $20", 75,225);
		g.drawString("Button 3: $30", 75,250);
		g.drawString("Button 4: $40", 275,200);
		g.drawString("Button 5: $50", 275,225);
		g.drawString("Button 6: Cancel", 275,250);
	}
}
