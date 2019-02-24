import java.util.*;

public class CCC_Sunflowers {
	public static void main (String args[]) {
		
		Scanner input = new Scanner(System.in);
		
		int lines;
		int[][] table;
		
		lines = Integer.parseInt(input.nextLine());
		table = new int [lines][lines];
		
		for (int i = 0; i < lines; i++) {
			
			for (int j = 0; j < lines; j++) {
				
				table [i] [j] = input.nextInt();
				
			}
			
		}

		CheckValues(lines, table);
		
	}

	private static void CheckValues(int lines, int[][] table) {
		
		int Score = 0;
		
		// Check 360
		
		if (table [0][0] < table [0][lines - 1] && table[0][0] < table[lines - 1][0]) {
			
			Score = 0;
			
		}
		
		// Check 90
		
		if (table [0][0] > table [0][lines - 1] && table[0][0] < table[lines - 1][0]) {
			
			Score = 1;
			
		}
		
		// Check 180
		
		if (table [0][0] > table [0][lines - 1] && table[0][0] > table[lines - 1][0]) {
			
			Score = 2;
		}
		
		// Check 270
		
		if (table [0][0] < table [0][lines - 1] && table[0][0] > table[lines - 1][0]) {
			
			Score = 3;
		}
		
		switch (Score) {
			case 0: for (int i = 0; i < lines; i++) {
						for (int j = 0; j < lines; j++) {
							
							System.out.print(table [i][j]);
							System.out.print(" ");
							
						}
						
						System.out.println();
						
					}
			
					break;
					
			case 1: for (int y = lines - 1; y >= 0; y--) {
						for (int x = 0; x < lines; x++) {
					
							System.out.print(table [x][y]);
							System.out.print(" ");
					
						}
				
						System.out.println();
				
					}
			
					break;
					
			case 2: for (int a = lines - 1; a >= 0; a--) {
						for (int s = lines - 1; s >= 0; s--) {
			
							System.out.print(table [a][s]);
							System.out.print(" ");
			
						}
		
						System.out.println();
		
					}
	
					break;
			
			case 3: for (int m = 0; m < lines; m++) {
						for (int n = lines - 1; n >= 0; n--) {
					
							System.out.print(table [n][m]);
							System.out.print(" ");
	
						}

						System.out.println();

					}

					break;
					
		}
		
	}

}
