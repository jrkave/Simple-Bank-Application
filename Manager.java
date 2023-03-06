package mypack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Manager {
	private Bank bank;
	private FileOps file;
	public ArrayList<Bank> users;
	
	// Constructors
	Manager() {
		bank = new Bank();
		file = new FileOps();
		users = file.getUsers();
	}
	
	// Returning users
	public boolean loginUser(String name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).clientName.equals(name)) {
				bank = users.get(i);
				System.out.println("Welcome back, " + name + ".");
				System.out.println();
				return true;
			}
		}
		System.out.println("User not found. Try again later.");
		return false;
	}
	
	// Create account
	public void createUser(String name) {
		bank = new Bank(name);
		bank.setID(users.size()); // set ID to size of users
		file.storeNewUser(bank);
		System.out.println();
	}
	
	// Print menu
	public void printMenu() {
		System.out.println(" ----- BANK MENU ---- ");
		System.out.println("1: View Account Information");
		System.out.println("2: Make a Deposit");
		System.out.println("3: Make a Withdrawl");
		System.out.println("4: Transfer Funds");
		System.out.println("5: Calculate Monthly Interest");
	}
	
	// Execute Menu for calculating monthly interest or printing account information
	public void executeMenu(int option) {
		if (option == 1) {
			bank.printAccountInformation();
		}
		else if (option == 5) {
			bank.calculateMonthlyInterest();
			file.updateFile(bank);
		}
	}
	
	// Execute Menu for managing funds
	public void executeMenu(int option, double amount, int actionType) {
		// Make a deposit
		if (option == 2) {
			if (actionType == 1) {
				bank.depositCheckings(amount);
			}
			else if (actionType == 2) {
				bank.depositSavings(amount);
			}
			else {
				System.out.println("Invalid input. Operation could not be performed.");
			}
			file.updateFile(bank);
		}
		// Make a withdrawal
		if (option == 3) {
			if (actionType == 1) {
				bank.withdrawCheckings(amount);
			}
			else if (actionType == 2) {
				bank.withdrawSavings(amount);
			}
			else {
				System.out.println("Invalid input. Operation could not be performed.");
			}
			file.updateFile(bank);
		}
		// Transfer funds
		if (option == 4) {
			if (actionType == 1) {
				bank.checkingsToSavings(amount);
			}
			else if (actionType == 2) {
				bank.savingsToCheckings(amount);
			}
			else {
				System.out.println("Invalid input. Operation could not be performed.");
			}
			file.updateFile(bank);
		}
	}
	
	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		String name;
		int loginChoice = 0;
		Manager manager = new Manager();
		boolean validNum = false;
		boolean isNum = false;
		
		// Login or Create Account
		System.out.println("Welcome to the bank!");
		System.out.println("To create an account, enter 1.");
		System.out.println("To login, enter 2.");
		// Input validation
		validNum = false;
		isNum = false;
		while (!isNum || !validNum) {
    		try {
        		loginChoice = scnr.nextInt();
        		isNum = true;
        		if (loginChoice == 1 || loginChoice == 2) {
            		validNum = true;
        		} else {
            		System.out.println("Invalid choice. Please enter 1 or 2.");
            		scnr.nextLine(); // consume the invalid input
            		isNum = false;
        		}
    		} catch (InputMismatchException e) {
        		System.out.println("Invalid input. Please enter a number.");
        		scnr.nextLine(); // consume the invalid input
    		}
		}
		System.out.println("Enter first name: ");
		name = scnr.next();
		System.out.println("Enter last name: ");
		name += " " + scnr.next();
		if (loginChoice == 1) {
			manager.createUser(name);
		}
		else if (loginChoice == 2) {
			if (manager.loginUser(name) == false) {
				System.exit(0);
			}
		}
		
		// Perform program
		int option = 0;
		int actionType = 0;
		double amount = 0;
		String stop = "null";
		while (!stop.equals("stop")) {	
			manager.printMenu();
			// Input validation
			System.out.println("Please choose an option: ");
			validNum = false;
			isNum = false;
			while (!isNum || !validNum) {
	    		try {
	        		option = scnr.nextInt();
	        		isNum = true;
	        		if (option >= 1 && option <= 5) {
	            		validNum = true;
	        		} else {
	            		System.out.println("Invalid choice. Please enter a number between 1 and 5.");
	            		scnr.nextLine(); // consume the invalid input
	            		isNum = false;
	        		}
	    		} catch (InputMismatchException e) {
	        		System.out.println("Invalid input. Please enter a number.");
	        		scnr.nextLine(); // consume the invalid input
	    		}
			}
			switch (option) {
				case 1:
					manager.executeMenu(option);
					break;
				case 2:
					System.out.println("To deposit to checkings, press 1.");
					System.out.println("To deposit to savings, press 2.");
					actionType = scnr.nextInt();
					while (actionType != 1 && actionType != 2) {
						System.out.println("Invalid input. Please enter 1 or 2.");
						actionType = scnr.nextInt();
					}
					System.out.println("Enter amount to deposit:");
					amount = scnr.nextDouble();
					amount = Math.round(amount * 100.0) / 100.0;
					manager.executeMenu(option, amount, actionType);
					break;
				case 3:
					System.out.println("To withdraw from checkings, press 1.");
					System.out.println("To withdraw from savings, press 2.");
					actionType = scnr.nextInt();
					while (actionType != 1 && actionType != 2) {
						System.out.println("Invalid input. Please enter 1 or 2.");
						actionType = scnr.nextInt();
					}
					System.out.println("Enter amount to withdraw:");
					amount = scnr.nextDouble();
					amount = Math.round(amount * 100.0) / 100.0;
					manager.executeMenu(option, amount, actionType);
					break;
				case 4:
					System.out.println("To transfer funds from checkings to savings, press 1.");
					System.out.println("To transfer funds from savings to checkings, press 2.");
					actionType = scnr.nextInt();
					while (actionType != 1 && actionType != 2) {
						System.out.println("Invalid input. Please enter 1 or 2.");
						actionType = scnr.nextInt();
					}
					System.out.println("Enter amount to transfer:");
					amount = scnr.nextDouble();
					amount = Math.round(amount * 100.0) / 100.0;
					manager.executeMenu(option, amount, actionType);
					break;
				case 5:
					manager.executeMenu(option);
					break;
				default:
					System.out.println("Invalid input.");
					break;
			}
			System.out.println("To continue, press any key. To end, type 'stop'.");
			stop = scnr.next();
		}
		scnr.close();
	}
}