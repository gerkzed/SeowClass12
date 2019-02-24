import java.util.*;

public class Review_1 {
	public static void main (String[] args) {
	
	// Call new Scanner to get user input
	Scanner input = new Scanner(System.in);
	
	// Using GetInput method to grab each variable and assign
	double[] variables = GetInput(input);

	// Check if the derivative is negative
	boolean derivative = RealRoots(variables);
	
	// If there are real roots, compete the equation
	if (derivative) {
		
		// Use the formula for each possible root in the equation
		double[] roots = QuadraticFormulaPos(variables);
		
		// Print each root
		System.out.println("The roots are " + roots[0] + " and " + roots[1]);
	}
	
	else {
		
		System.exit(0);
		
	}

	}
	
	// This method grabs the user input using the Scanner feature
	// The method also checks to make sure that the input is a number
	
	private static double[] GetInput(Scanner input) {
		
		// Create a new 3 number array to store the variables in
		double[] numbers = new double[3];
				
		// Try to get a double from user input
		try {
			System.out.println("Enter value for a:  ");
			numbers[0] = input.nextDouble();
			
			System.out.println("Enter value for b:  ");
			numbers[1] = input.nextDouble();
			
			System.out.println("Enter value for c:  ");
			numbers[2] = input.nextDouble();
		}
		
		// Catches if the user inputs a letter instead of a number and returns error statement
		catch (InputMismatchException e) {
			
			System.out.println("Invalid input");
			System.exit(0);
			
		}
	
		return numbers;
	}
	
	// This method checks to make sure the derivative is a real number
	// It checks to make sure the number below the square root is not a negative
	
	public static boolean RealRoots(double[] variables) {
		
		double root = 0;
		
		// Plug variables into derivative formula
		root = (Math.pow(variables[1], 2) - (4 * variables[0] * variables[2]));
		
		// If the roots are non-real, throw error message
		if (root < 0) {
			
			System.out.println("Derivative is negative, this equasion has no real roots!");
			return false;
			
		}
		
		else {
			
			return true;
			
		}
		
		
	}

	// This method does both roots of the quadratic equation
	// The method also checks to make sure that the output is a real number
	
	public static double[] QuadraticFormulaPos(double[] variables) {

		double[] roots = new double[2];
		
		// If A is zero and C is not, the program makes sure it gives a real answer
		if (variables[0] == 0 && variables[1] != 0) {
			
			roots[0] = (variables[2] * -1 / variables[1]);
			
			System.out.println("The root is " + roots[0]);
			System.exit(0);
			
		}
		
		else if (variables[0] == 0 && variables[1] == 0 && variables[2] == 0) {
			
			System.out.println("The root is all real numbers");
			System.exit(0);
			
		}
		
		// If both A and C are 0, the program sets both roots to zero
		else if (variables[0] == 0 && variables[1] == 0) {
			
			System.out.println("There are no real roots");
			System.exit(0);
			
		}
		
		
		// If both are real numbers, they are put into the real formula
		else {
			
			// Quadratic formula equation
			roots[0] = (-variables[1] + Math.sqrt(Math.pow(variables[1], 2) - (4 * variables[0] * variables[2]))) / (2 * variables[0]);
			roots[1] = (-variables[1] - Math.sqrt(Math.pow(variables[1], 2) - (4 * variables[0] * variables[2]))) / (2 * variables[0]);
			
		}

		return roots;
		
		
	}
	
}

