import java.io.*;
import java.util.*;

public class Arrays_1 {
	public static void main (String args[]) throws FileNotFoundException {
		
		int[] numList = readFiles();

		int mode = calcMode(numList);
		
	}

	private static int calcMode(int[] numList) {
		
		int maxCount = 0, mode = 0;
		
		for (int i = 0; i < numList.length; i++) {
			
			int modeCounter = 0;
			
			for (int j = 0; j < numList.length; j++) {
				
				if (numList[i] == numList[j]) {
					
					modeCounter++;
					
				}
			}
			
			if (modeCounter > maxCount) {
				
				maxCount = modeCounter;
				mode = numList[i];
				
			}
			
		}

		return mode;
	}

	private static int[] readFiles() {
		
		Scanner input;
		Scanner arrayRead;

    File f = new File("list1.txt");
		
		try {
			
			input = new Scanner(f);
			
			int counter = 0;
			
			while (input.hasNextInt()) {
				
				counter++;
				input.nextInt();
				
			}
			
			int[] numList = new int[counter];
			
			arrayRead = new Scanner(f);
			
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