package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Database  object
public class Database {
	//Account object
	public static class Account {
		//Member variables to hold account details
		boolean open;
		String cardnum;
		String zip;
		String CSV;
		String expDate;
		String[] balance = new String[2];
		String name;
		String[] history = new String[50];
		
		//Acconut object
		public Account() {
			open = false;
			cardnum = "";
			zip = "";
			expDate = "";
			CSV = "";
			balance[0] = "N/A";
			balance[1] = "N/A";
			for (int i = 0; i < history.length; i++)
				history[i] = "";
			name = "";
		}
		
		//getter for isOpen variable
		public boolean isOpen() {
			return open;
		}
		//settter for isOpen
		public void setOpen(boolean o) {
			open = o;
		}
		//get/set for Card num
		public String getCardnum() {
			return cardnum;
		}

		public void setCardnum(String c) {
			cardnum = c;
		}

		//get/set for Zip
		public String getZip() {
			return zip;
		}

		public void setZip(String z) {
			zip = z;
		}
		
		//get/set for Checking balance
		public String getChecking() {
			return balance[0];
		}

		public void setChecking(String b) {
			balance[0] = b;
		}
		
		//get/set for saving balance
		public String getSaving() {
			return balance[1];
		}

		public void setSaving(String b) {
			balance[1] = b;
		}
		
		//Gets and sets for remaining variables
		public String getName() {
			return name;
		}

		public void setName(String n) {
			name = n;
		}

		public String getExpDate() {
			return expDate;
		}

		public void setExpDate(String d) {
			expDate = d;
		}

		public String getCSV() {
			return CSV;
		}

		public void setCSV(String c) {
			CSV = c;
		}

		public String[] gethistory() {
			return history;
		}

		public String getHistoryIndex(int i) {
			return history[i];
		}

		public void sethistory(String h, int i) {
			history[i] = h;
		}
	}
	
	//Creates accounts array to hold data
	static Account[] database = new Account[7];

	//constuctor
	public Database() throws IOException {
		//connects to Data.txt file and scans in account details
		File data = new File("Data.txt");
		Scanner fr = new Scanner(data);
		int iterator = 0;
		for (int i = 0; i < database.length; i++)
			database[i] = new Account();
		while (fr.hasNextLine()) {
			loadData(fr.nextLine(), iterator);
			iterator++;
		}
		
		//for loop that prints the account details to console
		for (int i = 0; i < database.length; i++) {
			System.out.println(database[i].getName() + " " + database[i].getCardnum() + " " + database[i].getZip() + " "
					+ database[i].getExpDate() + " " + database[i].getCSV() + " (" + database[i].getChecking() + " "
					+ database[i].getSaving() + ") ");
			System.out.println("Account History:\n" + database[i].getHistoryIndex(0));
			System.out.println(database[i].getHistoryIndex(1));
			System.out.println(database[i].getHistoryIndex(2));
			System.out.println(database[i].getHistoryIndex(3));
			System.out.println(database[i].getHistoryIndex(4));
		}
		saveData();
		fr.close();
	}
	
	//Decrypt function
	private static String decrypt(String s) {
		String decrypted = "";
		for (int i = 0; i < s.length(); i++)
			//changes char value for each spot by 14
			decrypted += (char) (s.charAt(i) + 14);
		return decrypted;
	}
	
	//Encrypt function
	private static String encrypt(String s) {
		String encrypted = "";
		for (int i = 0; i < s.length(); i++)
			encrypted += (char) (s.charAt(i) - 14);
		return encrypted;
	}
	
	//Loads data into database array
	public static void loadData(String data, int loc) {
		int previous = 0;
		int dataCollected = 0;
		boolean checking = false;
		boolean saving = false;
		int iterator = 0;
		//decrypts data
		data = decrypt(data);
		if (data.length() > 0) {
			for (int i = 0; i < data.length(); i++) {
				//iterates through string and parses for all vales
				if (data.charAt(i) == '~' || i >= data.length() - 1) {
					String currentData = data.substring(previous, i);
					if (i >= data.length() - 1)
						currentData = data.substring(previous, i + 1);
					if (dataCollected == 0)
						database[loc].setName(currentData);
					else if (dataCollected == 1)
						database[loc].setCardnum(currentData);
					else if (dataCollected == 2)
						database[loc].setZip(currentData);
					else if (dataCollected == 3)
						database[loc].setExpDate(currentData);
					else if (dataCollected == 4)
						database[loc].setCSV(currentData);
					else if (dataCollected == 5) {
						if (currentData.equals("0"))
							database[loc].setOpen(false);
						else
							database[loc].setOpen(true);
					} else if (currentData.contentEquals("checking"))
						checking = true;
					else if (currentData.contentEquals("saving"))
						saving = true;
					else if (checking) {
						database[loc].setChecking(currentData);
						checking = false;
					} else if (saving) {
						database[loc].setSaving(currentData);
						saving = false;
					} else if (!saving && !checking) {
						database[loc].sethistory(currentData, iterator);
						iterator++;
					}
					previous = i + 1;
					dataCollected++;
				}
			}
		}
	}

	//saves adjusted Data to Data.txt file encrypted
	public static void saveData() throws IOException {
		//writer to file
		PrintWriter writer = new PrintWriter(new FileWriter("Data.txt"));
		//for length of databse array
		for (int i = 0; i < database.length; i++) {
			//if account is open
			if (database[i].isOpen())
				//prints each accounts info encrypted into the file
				if (database[i].balance[0].length() == 0)
					if (database[i].balance[1].length() == 0)
						writer.println();
					else
						writer.println(encrypt(database[i].getName() + "~" + database[i].getCardnum() + "~"
								+ database[i].getZip() + "~" + database[i].getExpDate() + "~" + database[i].getCSV()
								+ "~1~saving~" + database[i].getSaving() + "~" + database[i].getHistoryIndex(0) + "~"
								+ database[i].getHistoryIndex(1) + "~" + database[i].getHistoryIndex(2) + "~"
								+ database[i].getHistoryIndex(3) + "~" + database[i].getHistoryIndex(4)));
				else if (database[i].balance[1].length() == 0)
					writer.println(encrypt(database[i].getName() + "~" + database[i].getCardnum() + "~"
							+ database[i].getZip() + "~" + database[i].getExpDate() + "~" + database[i].getCSV()
							+ "~1~checking~" + database[i].getChecking() + "~" + database[i].getHistoryIndex(0) + "~"
							+ database[i].getHistoryIndex(1) + "~" + database[i].getHistoryIndex(2) + "~"
							+ database[i].getHistoryIndex(3) + "~" + database[i].getHistoryIndex(4)));
				else
					writer.println(encrypt(database[i].getName() + "~" + database[i].getCardnum() + "~"
							+ database[i].getZip() + "~" + database[i].getExpDate() + "~" + database[i].getCSV()
							+ "~1~checking~" + database[i].getChecking() + "~saving~" + database[i].getSaving() + "~"
							+ database[i].getHistoryIndex(0) + "~" + database[i].getHistoryIndex(1) + "~"
							+ database[i].getHistoryIndex(2) + "~" + database[i].getHistoryIndex(3) + "~"
							+ database[i].getHistoryIndex(4)));
			else if (database[i].balance[0].length() == 0)
				if (database[i].balance[1].length() == 0)
					writer.println();
				else
					writer.println(encrypt(database[i].getName() + "~" + database[i].getCardnum() + "~"
							+ database[i].getZip() + "~" + database[i].getExpDate() + "~" + database[i].getCSV()
							+ "~0~saving~" + database[i].getSaving() + "~" + database[i].getHistoryIndex(0) + "~"
							+ database[i].getHistoryIndex(1) + "~" + database[i].getHistoryIndex(2) + "~"
							+ database[i].getHistoryIndex(3) + "~" + database[i].getHistoryIndex(4)));
			else if (database[i].balance[1].length() == 0)
				writer.println(encrypt(database[i].getName() + "~" + database[i].getCardnum() + "~"
						+ database[i].getZip() + "~" + database[i].getExpDate() + "~" + database[i].getCSV()
						+ "~0~checking~" + database[i].getChecking() + "~" + database[i].getHistoryIndex(0) + "~"
						+ database[i].getHistoryIndex(1) + "~" + database[i].getHistoryIndex(2) + "~"
						+ database[i].getHistoryIndex(3) + "~" + database[i].getHistoryIndex(4)));
			else
				writer.println(encrypt(database[i].getName() + "~" + database[i].getCardnum() + "~"
						+ database[i].getZip() + "~" + database[i].getExpDate() + "~" + database[i].getCSV()
						+ "~0~checking~" + database[i].getChecking() + "~saving~" + database[i].getSaving() + "~"
						+ database[i].getHistoryIndex(0) + "~" + database[i].getHistoryIndex(1) + "~"
						+ database[i].getHistoryIndex(2) + "~" + database[i].getHistoryIndex(3) + "~"
						+ database[i].getHistoryIndex(4)));
		}
		//closes file writer
		writer.close();
	}
	
	public Account getAccount(String cardnum, String date, String CSV) {
		for (int i = 0; i < database.length; i++) {
			if (date.contentEquals(database[i].getExpDate()) && cardnum.contentEquals(database[i].getCardnum())
					&& CSV.contentEquals(database[i].getCSV())) {
				return database[i];}
		}
			return null;
	}
	//gets and sets for checking and saving accounts
	public String getChecking(String cardnum, String date, String CSV) {
		for (int i = 0; i < database.length; i++)
			if (date.contentEquals(database[i].getExpDate()) && cardnum.contentEquals(database[i].getCardnum())
					&& CSV.contentEquals(database[i].getCSV()))
				return database[i].getChecking();
		return "";
	}

	public String getSaving(String cardnum, String date, String CSV) {
		for (int i = 0; i < database.length; i++)
			if (date.contentEquals(database[i].getExpDate()) && cardnum.contentEquals(database[i].getCardnum())
					&& CSV.contentEquals(database[i].getCSV()))
				return database[i].getSaving();
		return "";
	}

	public void setSaving(String cardnum, String date, String CSV, String newSaving) {
		for (int i = 0; i < database.length; i++)
			if (date.contentEquals(database[i].getExpDate()) && cardnum.contentEquals(database[i].getCardnum())
					&& CSV.contentEquals(database[i].getCSV()))
				database[i].setSaving(newSaving);
	}

	public void setChecking(String cardnum, String date, String CSV, String newChecking) {
		for (int i = 0; i < database.length; i++)
			if (date.contentEquals(database[i].getExpDate()) && cardnum.contentEquals(database[i].getCardnum())
					&& CSV.contentEquals(database[i].getCSV()))
				database[i].setSaving(newChecking);
	}

	//checks if account is within database
	public boolean validAccount(String cardnum, String date, String CSV) {
		// need to check if open
		for (int i = 0; i < database.length; i++)
			if (date.contentEquals(database[i].getExpDate()) && cardnum.contentEquals(database[i].getCardnum())
					&& CSV.contentEquals(database[i].getCSV()))
				return true;
		return false;
	}
}