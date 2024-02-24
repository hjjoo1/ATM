package controller;

import java.awt.CardLayout;
import java.io.IOException;
import java.util.Scanner;

import gui.GUIController;
import gui.screens.MainMenu;
import database.Calc;
import database.Database;
import gui.*;

public class DepositCashController extends GUIController {
	
	private static final long serialVersionUID = 1L;
	
	private String cardnum;
	private String date;
	private String csv;
	
	Database db;
	String balance;
	String depositAmount;
	String newBalance;

	private Object scanner;
	
	public DepositCashController(String cardnum, String date, String csv) throws IOException{
		this.cardnum = cardnum;
		this.date = date;
		this.csv = csv;
		db = new Database();
		balance = db.getChecking(cardnum, date, csv);	//Current Balance
		System.out.println("Current Balance: " + balance);
	}
	
	@Override
	public void button1() {
		// TODO Auto-generated method stub
		System.out.println("Amount Deposit: 10");
		depositAmount = "10";
		newBalance = Calc.add(balance,depositAmount);
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
	}

	@Override
	public void button2() {
		// TODO Auto-generated method stub
		System.out.println("Amount Deposit: 20");
		depositAmount = "20";
		newBalance = Calc.add(balance,depositAmount);
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
	}

	@Override
	public void button3() {
		// TODO Auto-generated method stub
		System.out.println("Amount Deposit: 30");
		depositAmount = "30";
		newBalance = Calc.add(balance,depositAmount);
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
	}

	@Override
	public void button4() {
		// TODO Auto-generated method stub
		System.out.println("Amount Deposit: 40");
		depositAmount = "40";
		newBalance = Calc.add(balance,depositAmount);
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
	}
	@Override
	public void button5() {
		String withdrawAmount;
		withdrawAmount= "50";     
		System.out.println("Amount Deposit: 50" );
		newBalance = Calc.add(balance,"50");
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
		return;
		
	}

	@Override
	public void button6() {
		MainMenu menuScreen = new MainMenu();
        centerDisplay.add(menuScreen);
        CardLayout cardLayout = (CardLayout) centerDisplay.getLayout();
        cardLayout.next(centerDisplay);
		return;
		
	}

}
