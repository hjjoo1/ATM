package controller;

import java.awt.CardLayout;
import gui.CreateWindow;
import java.io.IOException;
import gui.GUIController;
import gui.modules.InputButtons;
import gui.screens.*;
import database.*;
//Main menu Controller class, this is the screen that shows after a verified card

public class MainMenuController extends GUIController implements InputButtons {
	private static final long serialVersionUID = 1L;
	// member variables to hold card info
	public String cardnum;
	public String date;
	public String csv;
	public String curr = "main";
	Database database;
	GUIController current;

	// constructor for class
	public MainMenuController(String cardnum, String date, String csv, Database d) {
		this.cardnum = cardnum;
		this.date = date;
		this.csv = csv;
		database = d;
	}

	// Numbered Buttons
	@Override
	public void button1() {

		if (curr.compareTo("main") == 0) {
			// Withdraw
			curr = "withdraw";
			Withdraw_CashAmount withdrawScreen = new Withdraw_CashAmount();
			GUIController.centerDisplay.add(withdrawScreen);
			CardLayout cardLayout = (CardLayout) GUIController.centerDisplay.getLayout();
			cardLayout.next(GUIController.centerDisplay);
			try {
				current = new WithdrawController(cardnum, date, csv);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void button2() {
		// second button leads to check balance
		if (curr.compareTo("main") == 0) {
			curr = "cb";
			current = new CheckBalanceController(cardnum, date, csv, database);
		}
	}

	@Override
	public void button3() {

		// TODO Auto-generated method stub
	}

	@Override
	public void button4() {
		// Deposit
		if (curr.compareTo("cb") == 0) {
			curr = "main";
		} else {
			if (curr.compareTo("main") == 0) {
				curr = "dep";
				DepositCash depositAccount = new DepositCash();
				GUIController.centerDisplay.add(depositAccount);
				CardLayout cardLayout = (CardLayout) GUIController.centerDisplay.getLayout();
				cardLayout.next(GUIController.centerDisplay);
				try {
				current = new DepositCashController(cardnum, date, csv);
				}
				catch(IOException e){
				e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void button5() {
		// TODO Auto-generated method stub
	}

	@Override
	public void button6() {
		if (curr.compareTo("main") != 0) {
			current = null;
			removeAll();
			refresh();
			
			curr = "main";
			
		} else if (curr.compareTo("main") == 0) {
			removeAll();
			GUIController.frame.backToStart();
			return;
		}
		// TODO Auto-generated method stub
	}
}