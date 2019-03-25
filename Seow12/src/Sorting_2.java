
/*********************************************************************************
Name: 
Date:
Project:
Description: 
**********************************************************************************/
import java.util.*;

public class Sorting_2 {
	public static void main(String[] args) {

		// You can modify this array and this code for testing
		int[] myArray = { -17, -10, -8, 2, 3, 8, 16, 20, 34, 41, 41 };

		Scanner input = new Scanner(System.in);
		boolean running = true;
		int goal;

		while (running) {

			try {

				System.out.println("Enter the number to be searched for: ");
				goal = input.nextInt();
				running = false;
				
				int index = ternarySearch(myArray, 0, myArray.length - 1, goal);

				if (index == -1) {

					System.out.println("The goal does not exist in the array.");

				}

				else {

					System.out.println("The position of " + goal + " is " + index);

				}
			}

			catch (InputMismatchException e) {

				System.out.println("Invalid input.");
				input.nextLine();

			}
		}
		
		input.close();
		
	}

	public static int ternarySearch(int[] myArray, int start, int end, int goal) {
		
		if (start <= end) {
			
			int mid1 = start + (end - start) / 3;
			int mid2 = end - (end - start) / 3;
		
			if (myArray[mid1] == goal) {
	
				return mid1;
					
			}
				
			if (myArray[mid2] == goal) {
	
				return mid2;
					
			}
				
			else if (goal < myArray[mid1]) {

				return ternarySearch(myArray, start, mid1 - 1, goal);
					
			}
			
			else if (goal > myArray[mid2]) {

				return ternarySearch(myArray, mid2 + 1, end, goal);
		
			}
				
			else {
					
				return ternarySearch(myArray, mid1 + 1, mid2 - 1, goal);
		
			}
		}
		
		else {
			
			return -1;
			
		}
	}
}