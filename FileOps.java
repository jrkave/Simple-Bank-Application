package mypack;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOps {
	private ArrayList<Bank> users;
	private String fileName = "src/mypack/Users.txt";
	
	FileOps() {
		// Initialize users with data from .txt file
		users = new ArrayList<Bank>();
		String line = "";
		String splitBy = ",";
		
		// Read file and split into tokens
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] userInformation = line.split(splitBy);
				Bank user = new Bank();
				user.setID(Integer.parseInt(userInformation[0]));
				user.setName(userInformation[1]);
				user.setCheckings(Double.parseDouble(userInformation[2]));
				user.setSavings(Double.parseDouble(userInformation[3]));
				user.setAPR(Double.parseDouble(userInformation[4]));
				users.add(user);
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Print users in file
	public void printUsers() {
		for (int i = 0; i < users.size(); i++) {
			System.out.println("ID: " + users.get(i).ID);
			System.out.println("Name: " + users.get(i).clientName);
			System.out.println("Checkings: " + users.get(i).checkingsBalance);
			System.out.println("Savings: " + users.get(i).savingsBalance);
			System.out.println("APR: " + users.get(i).APR);
			System.out.println();
		}
	}
	
	// Return users
	public ArrayList<Bank> getUsers() {
		return users;
	}
	
	public void storeNewUser(Bank user) {
	    ArrayList<String[]> data = new ArrayList<>();
	    String line = "";
	    String splitBy = ",";
	    boolean userExists = false;
	    
	    // Read file and split into tokens
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(fileName));
	        while ((line = br.readLine()) != null) {
	            String[] userInformation = line.split(splitBy); // store tokens into an array of strings 
	            data.add(userInformation); // add array of strings to array list 
	            if (userInformation[1].equals(String.valueOf(user.clientName))) {
	                userExists = true;
	            }
	        }
	        br.close();
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    // Add new user if it doesn't exist
	    if (!userExists) {
	        String[] userInformation = new String[5];
	        userInformation[0] = String.valueOf(user.ID);
	        userInformation[1] = user.clientName;
	        userInformation[2] = String.valueOf(user.checkingsBalance);
	        userInformation[3] = String.valueOf(user.savingsBalance);
	        userInformation[4] = String.valueOf(user.APR);
	        data.add(userInformation);
		    try {
		        FileWriter fw = new FileWriter(fileName);
		        BufferedWriter writer = new BufferedWriter(fw);
		        for (int i = 0; i < data.size(); i++) {
		            String userData = data.get(i)[0] + "," + data.get(i)[1] + "," + data.get(i)[2] + "," + data.get(i)[3] + "," + data.get(i)[4] + ",\n";
		            writer.write(userData);
		        }
		        System.out.println("Thanks for creating an account with us, " + user.clientName + ".");
		        writer.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	    }
	    else {
	    	System.out.println("User already exists. Please try again later.");
	    	System.exit(0);
	    }
	}
	
	// Update file after transaction
	public void updateFile(Bank user) {
		ArrayList<String[]> data = new ArrayList<>();
		String line = "";
		String splitBy = ",";
		
		// Read file and split into tokens
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				String[] userInformation = line.split(splitBy); // store tokens into an array of strings 
				data.add(userInformation); // add array of strings to arraylist 
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Update oldDate to newData
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i)[0].equals(String.valueOf(user.ID))) {
				data.get(i)[2] = String.valueOf(user.checkingsBalance);
				data.get(i)[3] = String.valueOf(user.savingsBalance);
				data.get(i)[4] = String.valueOf(user.APR);
			}
		}
		
		// Write new data to file
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);
			BufferedWriter writer = new BufferedWriter(fw);
			for (int i = 0; i < data.size(); i++) { // outer loop to access String[] array in ArrayList
				String userData = data.get(i)[0] + "," + data.get(i)[1] + "," + data.get(i)[2] + "," + data.get(i)[3] + "," + data.get(i)[4] + ",\n";
				writer.write(userData);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
