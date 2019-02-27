import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Password {
	public static void main (String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		String[] prePassword = new String[5];
		
		try {
			
			System.out.println("Enter first name:  ");
			prePassword[0] = VerifyName(input.nextLine());
			
			System.out.println("Enter middle name:  ");
			prePassword[1] = VerifyName(input.nextLine());
			
			System.out.println("Enter last name:  ");
			prePassword[2] = VerifyName(input.nextLine());
			
			System.out.println("Enter favourite color:  ");
			prePassword[3] = VerifyColour(input.nextLine());
			
			System.out.println("Enter phone number:  ");
			prePassword[4] = VerifyNumber(input.nextLine());
			
			input.close();
			
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: Invalid input");
			System.exit(0);
			
		}
		
		String password = CreatePassword(prePassword);
	
		System.out.println("Your password is " + password);
		
	}

	private static String CreatePassword(String[] prePassword) {
		
		String password = "";
		
		for(int i = 0; i < prePassword.length; i++) {
			
			if (prePassword[i].length() < 3) {
				
				password  += (prePassword[i]);
				
			}
			
			else {
				
				password += (prePassword[i].substring(1, 3));
				
			}
			
		}
		
		return password;
		
	}

	private static String VerifyNumber(String nextLine) {

		try {
			
			long number = Long.parseLong(nextLine.replace("-", "").replace(" ", ""));
			
			if (number > 0) {
				
				return nextLine;
				
			}
			
			else {
				
				System.out.println("Invalid number");
				return null;
				
			}
			
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Invalid number");
			return null;
			
		}
	}

	private static String VerifyColour(String nextLine) throws IOException {

		Scanner colour = new Scanner(new File("ColourList.txt"));
		
		String fileColours = "";
		
		boolean isColour = false;
		
		while (colour.hasNextLine()) {
			
			if (nextLine.equalsIgnoreCase(fileColours)) {
				
				isColour = true;
				break;
			}

			 fileColours = colour.nextLine();
			
		}
		
		colour.close();
		
		if (isColour) {
			
			return nextLine;
			
		}

		else {
			
			System.out.println("Invalid colour");
			System.exit(0);
			return null;
			
		}
		
	}

	private static String VerifyName(String nextLine) {
		
		if (nextLine.matches(".*\\d+.*")) {
			
			System.out.println("Error: No numbers in name");
			System.exit(0);
			return null;
			
		}
		
		else {
			
			return nextLine;
			
		}
	}
}
	