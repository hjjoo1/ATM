package controller;

import gui.GUIController;

import gui.screens.MainMenu;

import java.awt.CardLayout;
import java.io.IOException;
import java.util.Scanner;



import database.Calc;
import database.Database;

public class WithdrawController extends GUIController {
	
	private static final long serialVersionUID = 1L;
	
	private String cardnum;
	private String date;
	private String csv;
	
	Database db;
	String balance;
	String withdrawAmount;
	String newBalance;

	private Object scanner;
	
	public WithdrawController(String cardnum, String date, String csv) throws IOException{
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
		System.out.println("Amount Withdraw: 10");
		withdrawAmount = "10";
		newBalance = Calc.subtract(balance,withdrawAmount);
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
	}

	@Override
	public void button2() {
		// TODO Auto-generated method stub
		System.out.println("Amount Withdraw: 20");
		withdrawAmount = "20";
		newBalance = Calc.subtract(balance,withdrawAmount);
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
	}

	@Override
	public void button3() {
		// TODO Auto-generated method stub
		System.out.println("Amount Withdraw: 30");
		withdrawAmount = "30";
		newBalance = Calc.subtract(balance,withdrawAmount);
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
	}

	@Override
	public void button4() {
		// TODO Auto-generated method stub
		System.out.println("Amount Withdraw: 40");
		withdrawAmount = "40";
		newBalance = Calc.subtract(balance,withdrawAmount);
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
	}

	@Override
	public void button5() {
		String withdrawAmount;
		System.out.println("Amount Withdraw:");
		withdrawAmount="50";        
		newBalance = Calc.subtract(balance,withdrawAmount);
		db.setChecking(cardnum, date, csv, newBalance);
		System.out.println("New Balance: " + newBalance);
	}

	//Custom Amount
	@Override
	public void button6() {
		// TODO Auto-generated method stub
		MainMenu menuScreen = new MainMenu();
        centerDisplay.add(menuScreen);
        CardLayout cardLayout = (CardLayout) centerDisplay.getLayout();
        cardLayout.next(centerDisplay);
		return;
		
	}

}