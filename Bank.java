package mypack;

public class Bank {
    int ID;
    String clientName;
    double checkingsBalance;
    double savingsBalance;
    double APR;

    // Constructors
    Bank() {
    	ID = 0;
        clientName = "Name";
        checkingsBalance = 0.0;
        savingsBalance = 0.0;
        APR = 0.02;
    }
    
    Bank(String name) {
    	ID = 0;
    	clientName = name;
    	APR = 0.02;
    }
    
    
    // Setters
    public void setName(String name) {
        clientName = name;
    }

    public void setAPR(double apr) {
        APR = apr;
    }
    
    public void setID(int ID) {
    	this.ID = ID;
    }
    
    public void setCheckings(double checkings) {
    	checkingsBalance = checkings;
    }
    
    public void setSavings(double savings) {
    	savingsBalance = savings;
    }
    
    // Getters
    double getChecking() {
        return checkingsBalance;
    }

    double getSaving() {
        return savingsBalance;
    }

    double getAPR() {
        return APR;
    }
    
    String getName() {
    	return clientName;	
    }
    
    int getID() {
    	return ID;
    }
    
    // Bank operations
    public void printAccountInformation() {
    	System.out.println("ID: " + ID);
    	System.out.println("Name: " + clientName);
    	System.out.println("Checking Balance: " + checkingsBalance);
    	System.out.println("Savings Balance: " + savingsBalance);
    	System.out.println("Current APR: " + APR);
    }
    
    public void depositCheckings(double checkings) {
        checkingsBalance += checkings;
        System.out.println("Checking Balance: " + checkingsBalance);
    }

    public void depositSavings(double savings) {
        savingsBalance += savings;
        System.out.println("Savings Balance: " + savingsBalance);
    }


    public void withdrawCheckings(double checkings) {
        if ((checkingsBalance - checkings) >= 0) {
            checkingsBalance -= checkings;
            System.out.println("Checkings Balance: " + checkingsBalance);
        }
        else {
            System.out.println("Insufficient funds to perform the action.");
        }
    }

    public void withdrawSavings(double savings) {
        if ((savingsBalance - savings) >= 0) {
            savingsBalance -= savings;
            System.out.println("Savings Balance: " + savingsBalance);
        }
        else {
            System.out.println("Insufficient funds to perform the action.");
        }
    }

    public void savingsToCheckings(double savings) {
        if ((savingsBalance - savings) >= 0) {
            savingsBalance -= savings;
            savingsBalance = Math.round(savingsBalance * 100.0) / 100.0;
            checkingsBalance += savings;
            checkingsBalance = Math.round(checkingsBalance * 100.0) / 100.0;
            System.out.println("Savings Balance: " + savingsBalance);
            System.out.println("Checkings Balance: " + checkingsBalance);
        }
        else {
            System.out.println("Insufficient funds to perform the action.");
        }
    }

    public void checkingsToSavings(double checkings) {
        if ((checkingsBalance - checkings) >= 0) {
            checkingsBalance -= checkings;
            checkingsBalance = Math.round(checkingsBalance * 100.0) / 100.0;
            savingsBalance += checkings;
            savingsBalance = Math.round(savingsBalance * 100.0) / 100.0;
            System.out.println("Savings Balance: " + savingsBalance);
            System.out.println("Checkings Balance: " + checkingsBalance);
        }
        else {
            System.out.println("Insufficient funds to perform the action.");
        }
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = checkingsBalance * APR;
        checkingsBalance += monthlyInterest;
        monthlyInterest = Math.round(monthlyInterest * 100.0) / 100.0;
        checkingsBalance = Math.round(checkingsBalance * 100.0) / 100.0;
        System.out.println("Monthly interest with APR of " + APR + ": " + monthlyInterest);
        System.out.println("Checkings Balance: " + checkingsBalance);
    }
}
