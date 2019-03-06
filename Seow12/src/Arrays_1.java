import java.io.*;
import java.util.*;

public class Arrays_1 {
	public static void main(String args[]) throws FileNotFoundException {

		int[] numList = readFiles();

		Integer[] mode = calcMode(numList);

		if (mode == null) {
			
			System.out.println("There are no modes in the sequence.");
			
		}
		
		else {
			
			System.out.print("The mode(s) of the sequence are: ");
			
			for (int i = 0; i < mode.length; i++) { 

				int j;
				
		        for (j = 0; j < i; j++) {
		        	
			           if (mode[i] == mode[j]) {
			        	   
			        	   break;
			        	   
			           }

		        }

		        if (i == j) {
		        	
		        	System.out.print(mode[i] + " ");
		        	
		        }

		    } 
			
		}

	}

	private static Integer[] calcMode(int[] numList) {
		
		List<Integer> modes = new ArrayList<Integer>();
		
		int max = 0;
		
		for (int i = 0; i < numList.length; i++) {
			
			int count = 0;
			
			for (int j = 0; j < numList.length; j++) {
				
				if (numList[i] == numList[j]) {
					
					count++;
					
				}
			}
			
			if (count > max) {
				
				max = count;
				modes.clear();
				modes.add(numList[i]);
				
			}
			
			else if (count == max) {
				
				modes.add(numList[i]);
				
			}
			
		}
		
		if (max == 1) {
			
			return null;
			
		}
		
		else {
			
			return modes.toArray(new Integer[modes.size()]);
			
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