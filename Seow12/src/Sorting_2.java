
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
		int[] myArray = {-8, -8, -8, -8, -8, -8, -8, -8,};

		Scanner input = new Scanner(System.in);
		int goal;

		try {

			System.out.println("Enter the number to be searched for: ");
			goal = input.nextInt();

			int index = ternarySearch(myArray, 0, myArray.length - 1, goal);

			int first = index;

			int last = index;

			if (index >= 0) {

				while (first > 0 && myArray[first - 1] == goal) {

					first--;

				}

				while (last < myArray.length - 1 && myArray[last + 1] == goal) {

					last++;

				}

			}
			
			if (last > first) {

				System.out.print("The goal is on indexes: ");

				for (int i = first; i < last; i++) {

					System.out.print(i + ", ");

				}

				System.out.print(last);
				System.out.print(".");

			}

			else if (last == first && first != -1) {

				System.out.println("The goal is on index " + first + ".");

			}

			else if (index == -1) {

				System.out.println("The goal does not exist in the array.");

			}
			
			else {
				
				System.out.println("Big error");
				
			}
		}

		catch (InputMismatchException e) {

			System.out.println("Invalid input.");
			goal = -3;
			input.nextLine();

		}
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