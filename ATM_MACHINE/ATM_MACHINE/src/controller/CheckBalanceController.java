package controller;
import gui.*;
import gui.screens.CheckBalance;
import gui.screens.MainMenu;

import java.awt.CardLayout;
import java.io.IOException;

import database.Database;

/*
 * This is an incomplete framework for the CheckBalance controller
 */
public class CheckBalanceController extends MainMenuController {

	private static final long serialVersionUID = 1L;
	Database.Account account;
	//constructor 
	public CheckBalanceController(String cardnum, String date, String csv, Database dControl){
		super(cardnum, date, csv, dControl);
		account = database.getAccount(cardnum, date, csv);
		CheckBalance balanceScreen = new CheckBalance(account);
		GUIController.centerDisplay.add(balanceScreen);
		CardLayout cardLayout = (CardLayout) GUIController.centerDisplay.getLayout();
		cardLayout.next(GUIController.centerDisplay);
		
	}
	
	
	//overridden button function stubs
	@Override
	public void button1() {
		// TODO Auto-generated method stub
	}

	@Override
	public void button2() {
		// TODO Auto-generated method stub
	}

	@Override
	public void button3() {
		// TODO Auto-generated method stub
	}

	@Override
	public void button4() {
		
	}

	@Override
	public void button5() {
		// TODO Auto-generated method stub
	}

	@Override
	public void button6() {
		MainMenu menuScreen = new MainMenu();
        centerDisplay.add(menuScreen);
        CardLayout cardLayout = (CardLayout) centerDisplay.getLayout();
        cardLayout.next(centerDisplay);
		return;
		// TODO Auto-generated method stub
	}

}
