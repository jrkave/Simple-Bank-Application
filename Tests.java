package mypack;

public class Tests {

	public static void main(String[] args) {
		System.out.println("TESTING STARTED");
		System.out.println();
		
		// Test constructors
		System.out.println("=== TESTING CONSTRUCTORS ===");
		Bank user1 = new Bank();
		System.out.println("Expected ID: 0, Actual ID: " + user1.getID());
		System.out.println("Expected Name: Name, Actual Name: " + user1.getName());
		System.out.println("Expected APR: 0.02, Actual APR: " + user1.getAPR());
		System.out.println("Expected Checkings: 0.0, Actual Checkings: " + user1.getChecking());
		System.out.println("Expected Savings: 0.0, Actual Savings: " + user1.getSaving());
		System.out.println("Expected APR: 0.02, Actual APR: " + user1.getAPR());
		
		Bank user2 = new Bank("Ducky");
		System.out.println("Expected Name: Ducky, Actual Name: " + user2.getName());
		
		// Testing functions
		System.out.println();
		System.out.println("=== TESTING DEPOSITS ===");
		System.out.println("Depositing 11.23 to Checkings...");
		user1.depositCheckings(11.23);
		System.out.println("Depositing 34252.96 to Savings...");
		user1.depositSavings(34252.96);
		System.out.println();
		
		System.out.println("=== TESTING WITHDRAWS ===");
		System.out.println("Withdrawing 1.23 from Checkings...");
		user1.withdrawCheckings(1.23);
		System.out.println("Withdrawing 2.97 from Savings...");
		user1.withdrawSavings(2.97);
		System.out.println("Testing withdraws with insufficient funds (Checkings)...");
		user1.withdrawCheckings(11.00);
		System.out.println("Testing withdraws with insufficient funds (Savings)...");
		user1.withdrawSavings(40000);
		System.out.println();
		
		System.out.println("=== TESTING TRANSFERS ===");
		System.out.println("Transferring .01 from Checkings to Savings...");
		System.out.println("Expected values: Checkings: 9.99, Savings: 34250.0");
		System.out.println("Actual values:");
		user1.checkingsToSavings(.01);
		System.out.println("Transferring .01 from Savings to Checkings...");
		System.out.println("Expected values: Checkings: 10.0, Savings: 34249.99");
		System.out.println("Actual values:");
		user1.savingsToCheckings(.01);
		System.out.println("Testing transfers with insufficient funds (Checkings to Savings)...");
		user1.checkingsToSavings(11.00);
		System.out.println("Testing transfers with insufficent funds (Savings to Checkings)...");
		user1.savingsToCheckings(34250);
		System.out.println();
		
		System.out.println("=== TESTING CACULATE MONTHLY INTEREST ===");
		System.out.println("Expected values: 0.02 APR, Checking Balance: 10.2");
		user1.calculateMonthlyInterest();
		System.out.println();
	
		System.out.println("=== TESTING PRINT ACCOUNT INFO ===");
		System.out.println("Expected values:");
		System.out.println("ID: 0");
		System.out.println("Name: Name");
		System.out.println("Checking Balance: 10.2");
		System.out.println("Savings Balance: 34249.99");
		System.out.println("APR: 0.02");
		System.out.println();
		System.out.println("Actual values:");
		System.out.println("ID: " + user1.getID());
		System.out.println("Name: " + user1.getName());
		System.out.println("Checking Balance: " + user1.getChecking());
		System.out.println("Savings Balance: " + user1.getSaving());
		System.out.println("APR: " + user1.getAPR());
		System.out.println();
		
		System.out.println("=== TESTING GETTING USERS IN FILE ===");
		Manager manager = new Manager();
		for (int i = 0; i < manager.users.size(); i++) {
			System.out.println("ID: " + manager.users.get(i).getID());
			System.out.println("Name: " + manager.users.get(i).getName());
			System.out.println("Checking Balance: " + manager.users.get(i).getChecking());
			System.out.println("Savings Balance: " + manager.users.get(i).getSaving());
			System.out.println("APR: " + manager.users.get(i).getAPR());
			System.out.println();
		}
		System.out.println("TESTING COMPLETE");
	}
}
