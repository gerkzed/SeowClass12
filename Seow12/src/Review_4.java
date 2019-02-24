import java.util.*;
import java.text.*;

public class Review_4 {
	public static void main (String args[]) {
		
		// Making a new Scanner, Random and DEcimalFormat objects to use in the program
		Scanner input = new Scanner(System.in);
		Random generator = new Random();
		DecimalFormat df = new DecimalFormat("#.##");
		
		// Call generate method to get the two numbers and the answer and put them in an array
		int[] numbers = GenerateQuestion(generator);
		
		// Call answer method to take user input and print the question
		double answer = TakeAnswer(input, numbers);
		
		// Call check method to compare the user input to the answer
		CheckAnswer(answer, numbers, df);
		
	}

	// This method makes a three number array, the first two spaces for the two numbers, and the third space for the operator
	// The method uses the Random object instantiated in the main class file
	
	public static int[] GenerateQuestion(Random generator) {
		
		// Create a new 3 number array to store the variables in
		int[] numbers = new int[3];
		
		// Assigning the array spaces to each number
		numbers[0] = generator.nextInt(10) + 1;
		numbers[1] = generator.nextInt(10) + 1;
		numbers[2] = generator.nextInt(3) + 1; //Operator

		// Return the array
		return numbers;
		
		
	}
	
	// This method generates the question and takes the user input
	// The method also catches bad inputs
	
	public static double TakeAnswer(Scanner input, int[] numbers) {
		
		double answer = 0;
		
		// Switch to print the correct question with operator
		switch(numbers[2]) {
			case 0:	System.out.println("What is " + numbers[0] + " + " + numbers[1] + "?");
					break;
			case 1:	System.out.println("What is " + numbers[0] + " - " + numbers[1] + "?");
					break;
			case 2:	System.out.println("What is " + numbers[0] + " * " + numbers[1] + "?");
					break;
			case 3:	System.out.println("What is " + numbers[0] + " / " + numbers[1] + "? (To two decimal places)");
					break;
					
		}
		
		// A try method to have the user input 
		try {
			
			answer = input.nextDouble();
			
		}
		
		// A catch method so the user cannot input letters
		catch (InputMismatchException e) {
			
			System.out.println("Invalid input");
			System.exit(0);
			
		}
		
		// Return the user input
		return answer;
		
	}
	
	// This method compares the user input to the answer and tells the user if it is right or wrong
	
	public static void CheckAnswer(double answer, int[] numbers, DecimalFormat df) {
		
		double correct = 0;
		
		double[] doubleNumbers = new double[2];
		
		doubleNumbers[0] = numbers[0];
		doubleNumbers[1] = numbers[1];
		
		// Switch to find the correct answer
		switch(numbers[2]) {
			case 0:	correct = numbers[0] + numbers[1];
					break;
			case 1:	correct = numbers[0] - numbers[1];
					break;
			case 2:	correct = numbers[0] * numbers[1];
					break;
			case 3:	correct = Double.parseDouble(df.format(doubleNumbers[0] / doubleNumbers[1]));
					break;

		}
		
		// If statement compares the answers
		if (answer == correct) {
			
			System.out.println("Correct answer!");
			
		}
		
		// If the answer is incorrect, the user will receive a message and the correct answer
		else {
			
			System.out.println("Incorrect answer!");
			System.out.println("The correct answer was: " + correct);
			System.exit(0);
			
		}
		
	}

}
