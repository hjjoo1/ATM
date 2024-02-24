package controller;

import java.io.IOException;

import database.Database;

//Verifies Card
public class VerifyCard {
	private Database dbController;
	private boolean verified;
	//Constructor passes in card info
	public VerifyCard(String number, String expDate, String csv) {
		try {
			//creates a database object which reads the encrypted data from the Data.txt file
			dbController = new Database();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		//Asks db if the card is valid and stores in member variable
		verified = dbController.validAccount(number, expDate, csv);
	}
	public Database getdb() {
		return dbController;
	}
	public boolean verified() {
		return verified;
	}
}
