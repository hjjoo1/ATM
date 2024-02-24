package gui.screens;

import java.awt.Graphics;

import database.Database;

public class CheckBalance extends Screen {
	private static final long serialVersionUID = 1L;
	Database.Account acnt;
	public CheckBalance(Database.Account act) {
		super();
		this.acnt = act;
		
	}
	
	//
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHeader(g, "Check Balance: ");
		drawSubtitle(g, "Press 6 for main menu \n ");
		g.drawString("Savings: " + acnt.getSaving() + "$", 75,150);
		g.drawString("Checking: " + acnt.getChecking()+ "$", 75, 170);
		g.drawString("Account History:", 75,190);
		g.drawString(acnt.getHistoryIndex(1)+"$", 100,210);
		g.drawString(acnt.getHistoryIndex(2)+"$", 100,230);
		g.drawString(acnt.getHistoryIndex(3)+"$", 100,250);
		g.drawString(acnt.getHistoryIndex(4)+"$", 100,270);
	}
}
