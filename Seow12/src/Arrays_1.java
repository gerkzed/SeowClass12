import java.io.*;
import java.util.*;

public class Arrays_1 {
	public static void main(String args[]) throws FileNotFoundException {

		int[] numList = readFiles();

		int mode = calcMode(numList);

		if (mode == -1) {

			System.out.println("No mode");

		}

		else {

			System.out.println("The mode of the file is: " + mode);

		}

	}

	private static int calcMode(int[] numList) {

		int[] numListParallel = numList.clone();

		int highest = 0, mode = 0;

		for (int i = 0; i < numList.length; i++) {

			int counter = 0;

			for (int j = 0; j < numList.length; j++) {

				if (numList[i] == numListParallel[j]) {

					counter++;

				}
			}

			if (counter > highest) {

				highest = counter;
				mode = numList[i];

			}

		}

		if (highest == 1) {

			return -1;

		}

		else {

			return mode;

		}

	}

	private static int[] readFiles() {

		Scanner input;
		Scanner arrayRead;

		File file = new File("list4.txt");

		try {

			input = new Scanner(file);

			int counter = 0;

			while (input.hasNextInt()) {

				counter++;
				input.nextInt();

			}

			int[] numList = new int[counter];

			arrayRead = new Scanner(file);

			for (int i = 0; i < numList.length; i++) {

				numList[i] = arrayRead.nextInt();

			}

			input.close();
			arrayRead.close();

			return numList;

		}

		catch (Exception e) {

			return null;

		}

	}

}