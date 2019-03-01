import java.io.*;
import java.util.*;

public class Arrays_2 {
	public static void main(String args[]) {

		int[][] table = GetFileInput("magic5.txt");

		int magic = CalcMagic(table);

		if (magic != -1) {

			System.out.println("The square is magic and the number is: " + magic);

		}

		else {

			System.out.println("The square is not magic");

		}

	}

	private static int[][] GetFileInput(String string) {

		try {

			Scanner input = new Scanner(new File(string));

			int size = input.nextInt();

			int[][] table = new int[size][size];

			for (int i = 0; i < size; i++) {

				for (int j = 0; j < size; j++) {

					table[i][j] = input.nextInt();

				}

			}

			input.close();

			return table;

		}

		catch (FileNotFoundException e) {

			return null;

		}

	}

	private static int CalcMagic(int[][] table) {

		int[] totalH = new int[table.length];
		int[] totalV = new int[table[0].length];
		int totalD = 0;

		for (int i = 0; i < table.length; i++) {

			for (int j = 0; j < table[0].length; j++) {

				totalH[i] += table[i][j];

			}

			System.out.println("Sum of row " + i + " is " + totalH[i]);

		}

		System.out.println("");

		for (int i = 0; i < table[0].length; i++) {

			for (int j = 0; j < table[0].length; j++) {

				totalV[i] += table[j][i];

			}

			System.out.println("Sum of column " + i + " is " + totalV[i]);

		}

		System.out.println("");

		for (int i = 0; i < table.length; i++) {

			totalD += table[i][i];

		}

		System.out.println("Sum of diagonal is " + totalD);

		System.out.println("");

		int score = 0;

		for (int i = 0; i < table.length; i++) {

			if (totalH[i] == totalV[i] && totalV[i] == totalD) {

				score++;

			}

		}

		if (score == table.length) {

			return totalD;

		}

		else {

			return -1;

		}

	}

}
