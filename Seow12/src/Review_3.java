import java.util.*;

public class Review_3 {
	public static void main (String[] args) {
		
		// Create Scanner object to take user input
		Scanner input = new Scanner(System.in);
		
		// Create two numbers to find the GCF using a method
		int x = GetInput(input);
		int y = GetInput(input);
		
		if (x == 0 && y == 0) {
			
			System.out.println("The greatest common factor of 0 and 0 is 1");
			System.exit(0);
			
		}
		
		// Find the GCF using the GCF method
		int factor = GCF(x, y);
		
		// Print to console the GCF
		System.out.println("The greatest common factor of " + x + " and " + y + " is " + factor);
		
	}
	
	// This method grabs the user input of a value that the user wants to find the GCF of
	// It also checks the value to make sure it is valid
	
	public static int GetInput(Scanner input) {

		int x = 0;
		
		// Try to get user input to a variable
		try {
			System.out.println("Enter value: ");
			x = input.nextInt();
			
		}
		
		// Catch invalid input and throw an error
		catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		

			
		return x;
			
	}
	
	// This method uses recursion to find the GCF
	// By returning a call to itself, it will recursively divide until the remainder is zero, and that is when the GCF is found
	
	public static int GCF(int x, int y) {
		
		// If the two numbers divide evenly, the GCF is found
		if(y == 0) { 
			
			// We return the absolute value of x because the GCF cannot be negative
			return Math.abs(x); 
			
		} 
		
		// We use recursion to make the method run until we have the GCF and return it
		return GCF(y, x % y);
	
	}
	
}