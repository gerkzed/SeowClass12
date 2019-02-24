import java.util.*;

public class Review_2 {
	public static void main (String[] args) {
		
		// Create Scanner object to take user input
		Scanner input = new Scanner(System.in);
		
		// Make a new number variable with user input stored
		int number = GetNumber(input);
		
		// Do the right method based on the number
		if (number > 0) {
			
			// Sums the odd numbers to the number that the user enters (inclusive)
			OddSumPos(number);
				
		}
		
		else {
			
			// Sums the negative odd numbers to the number that the user enters (inclusive)
			OddSumNeg(number);	
			
		}

	}
	
	// This method uses the Scanner to take the input
	// It also checks to see if the input is invalid
	
	public static int GetNumber(Scanner input) {
	
		int x = 0;
		
		// Try to take user input to a variable
		try {
			System.out.println("Enter the number to be summed to:  ");
			x = input.nextInt();
		}
		
		// Catch invalid input and throw an error
		catch (InputMismatchException e) {
			System.out.println("Invalid input");
			System.exit(0);
		}
		
		if (x == 0) {
			
			System.out.println("The sum of all the odd numbers is 1");
			System.exit(0);
				
		}
		
		// If the number is negative, also throw an error
		
		return x;
	}
	
	// This method uses a for loop to sum all the odd numbers up to the user input (inclusive)
	// It also prints the result of the sum
	
	public static void OddSumPos(int number) {
	
		int sumTotal = 0;
		
		// For loop sums up all the numbers
		for (int i = 0; i <= number; i++) {
			
			if (i % 2 == 1) {
			
				sumTotal += i;
					
			}
			
		}
		
		// Print to console
		System.out.println("The sum of all the odd numbers is " + sumTotal);
			
	}
	
	public static void OddSumNeg(int number) {
	
		int sumTotal = 1;
		
		// For loop sums up all the numbers
		for (int i = 0; i >= number; i--) {
			
			if (i % 2 == -1) {
			
				sumTotal += i;
					
			}
			
		}
		
		// Print to console
		System.out.println("The sum of all the negative odd numbers is " + sumTotal);
			
	}
	
	
}