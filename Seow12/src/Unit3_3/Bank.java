package Unit3_3;

import java.io.File;
import java.util.Scanner;

public class Bank {
	
	// FOR THIS PROGRAM TO WORK YOU NEED "Account.txt" AND "History.txt" IN THE SAME FOLDER!
	
	public static Account User = getAccount();
	
	public static final String fileAccount = "Account.txt";
	
	public static final String fileLog = "History.txt";
	
	public static void main(String[] args) {
		
		BankGUI gui = new BankGUI();
				
		gui.setVisible(true);
		
		
	}

	private static Account getAccount() {
		
		try {
			
			Scanner input = new Scanner(new File(fileAccount));
			
			String[] a = input.nextLine().split("/");
			
			Account User = new Account(Double.parseDouble(a[0]), Double.parseDouble(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3]));
			
			input.close();
			
			return User;
			
		}
		
		catch (Exception e) {
			
			System.out.println("Error: Problem reading Account.txt file");
			
			System.exit(0);
			
		}
		
		return new Account();
		
	}

}
