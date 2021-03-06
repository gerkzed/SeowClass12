import java.util.*;

public class Arrays_3 {
	public static void main(String args[]) {

		int size = -1;
		
		while (size == -1) {
			
			size = takeInput();
		
		}

		long[][] PascalTriangle = new long[size + 1][];

		PascalTriangle = generateTriangle(PascalTriangle, size);

		for (int i = 1; i <= PascalTriangle.length - 1; i++) {

			for (int j = 1; j < PascalTriangle[i].length - 1; j++) {

				System.out.print(PascalTriangle[i][j] + " ");

			}

			System.out.println();

		}
	}

	private static int takeInput() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int size = 0;

		try {

			System.out.println("Enter number of layers to the Pascal Triangle: ");

			size = input.nextInt();

			if (size <= 0) {

				System.out.println("Pascal Triangle cannot be less than 1 layer! \n");
				return -1;

			}

			if (size > 50) {

				System.out.println("Pascal Triangle cannot be that large! \n");
				return -1;

			}

		}

		catch (InputMismatchException e) {

			System.out.println("Error: Invalid Input");
			return -1;

		}

		return size;

	}

	private static long[][] generateTriangle(long[][] pascalTriangle, int size) {

		pascalTriangle[1] = new long[3];
		pascalTriangle[1][1] = 1;

		for (int i = 2; i <= size; i++) {

			pascalTriangle[i] = new long[i + 2];

			for (int j = 1; j < pascalTriangle[i].length - 1; j++) {

				pascalTriangle[i][j] = (pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j]);

			}
		}

		return pascalTriangle;

	}

}
