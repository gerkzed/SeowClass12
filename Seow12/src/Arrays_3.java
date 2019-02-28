import java.util.*;

public class Arrays_3 {
	public static void main (String args[]) {
		
		int size = takeInput();

		int [][] PascalTriangle = new int [size + 1][];
		
		PascalTriangle = generateTriangle(PascalTriangle, size);

		for (int i = 1; i <= PascalTriangle.length - 1; i++) {
			
			for (int j = 1; j < PascalTriangle[i].length - 1; j++) {
				
				System.out.print(PascalTriangle[i][j] + " ");
				
			}
			
			System.out.println();
			
		}	
	}

	private static int takeInput() {
		
		int size = 0;
		
		try {
			
			System.out.println("Enter number of layers to the Pascal Triangle");
			Scanner input = new Scanner(System.in);
			size = input.nextInt();
			input.close();
			
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Error: Invalid Input");
			size = takeInput();
			
		}
		
		return size;
	}
	
	private static int[][] generateTriangle(int[][] pascalTriangle, int size) {
		
		pascalTriangle[1] = new int[1 + 2];
        pascalTriangle[1][1] = 1;

		for (int i = 2; i <= size; i++){
			
			pascalTriangle[i] = new int[i + 2];
			
			for (int j = 1; j < pascalTriangle[i].length - 1; j++) {
				
				pascalTriangle[i][j] = (pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j]);

			}
		}
		
		return pascalTriangle;
		
	}
	
	
}
