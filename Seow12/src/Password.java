import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Password {
	public static void main (String[] args) throws IOException {
		
		String loop = "y";
		
		while (loop.equals("y")) {
			
			Scanner input = new Scanner(System.in);
			
			String[] prePassword = new String[5];
			
			try {
				
				while (prePassword[0] == null) {
					
					System.out.println("Enter first name:  ");
					prePassword[0] = VerifyName(input.nextLine());
					
				}
				
				while (prePassword[1] == null) {
					
					System.out.println("Enter middle name:  ");
					prePassword[1] = VerifyName(input.nextLine());
					
				}
				
				while (prePassword[2] == null) {
					
				System.out.println("Enter last name:  ");
				prePassword[2] = VerifyName(input.nextLine());
					
				}
				
				while (prePassword[3] == null) {
					
				System.out.println("Enter favourite color:  ");
				prePassword[3] = VerifyColour(input.nextLine());
					
				}
				
				while (prePassword[4] == null) {
					
				System.out.println("Enter phone number:  ");
				prePassword[4] = VerifyNumber(input.nextLine());
					
				}
				
			}
			
			catch (InputMismatchException e) {
				
				System.out.println("Error: Invalid input");
				System.exit(0);
				
			}
			
			String password = CreatePassword(prePassword);
		
			System.out.println("Your password is " + password);
			
			System.out.println("Generate a new password? ('y' for a new password):  ");
			loop = input.nextLine();

		}
		
	System.exit(0);

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

		nextLine = nextLine.replace("-", "");

		if (nextLine.matches("\\d+") && nextLine.length() == 10) {
				
			return nextLine.substring(1, 3);
				
		}
			
		else {
				
			System.out.println("Invalid number");
			return null;
				
		}
			
	}

	private static String VerifyColour(String nextLine) throws IOException {

		if (nextLine.equals("")) {
			
			System.out.println("Error: Enter a colour");

		}
		
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
			return null;
			
		}
		
	}

	private static String VerifyName(String nextLine) {

		if (nextLine.replaceAll("\\s+", "").matches("[a-zA-Z]*")) {
			
			return nextLine;
		
		}
		
		else {
			
			System.out.println("Error: Invalid name!");
			return null;
			
		}
	}
}
	