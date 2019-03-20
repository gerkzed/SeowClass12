import java.io.*;
import java.util.*;

public class Sorting_1 {
	public static void main (String[] args) throws IOException {
		
		Scanner input = new Scanner(new File("MergeSortNames.txt"));
		
		String[] names = new String[input.nextInt() + 1];
		input.nextLine();
		
		int a = 0;
		
		while (input.hasNextLine()) {
			
			names[a] = input.nextLine();
			a++;
			
		}
		
		input.close();
		
		ObjectMergeSort(names);
		
		for (int i = 0; i < names.length; i++) {
			
			System.out.println(names[i]);
			
		}
		
	}
	
	private static void ObjectMergeSort(String[] arr) {
		
		if (arr.length < 2) {
			
			return;
			
		}

		int middle = arr.length / 2;
		int right = arr.length - middle;
		
		String[] tempLeft = new String[middle];
		String[] tempRight = new String[right];
		
		for (int i = 0; i < middle; i++) {
			
			tempLeft[i] = arr[i];
			
		}
		
		for (int i = middle; i < arr.length; i++) {
			
			tempRight[i - middle] = arr[i];
			
		}

		ObjectMergeSort(tempLeft);
		ObjectMergeSort(tempRight);
		
		int i = 0, j = 0, k = 0;
		
		while(i < middle && j < right) {
		
			if (tempLeft[i].compareTo(tempRight[j]) < 0)
				arr[k++] = tempLeft[i++];
			
			else 
				arr[k++] = tempRight[j++];
		
		}
		
		while (i < middle) {
			
			arr[k++] = tempLeft[i++];
			
		}
		
	    while (j < right) {
	    	
	        arr[k++] = tempRight[j++];
	        
	    }
		
	
	}
}
