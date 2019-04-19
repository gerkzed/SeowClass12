import java.util.*;

public class WillLib {
	public static void main (String[] args) {
		
		int[] array = {12, 3456, 123, 2134, 324, 234, 12, 5, 8, 4};
		
		mergesort(array);
		
		System.out.println(Arrays.toString(array));
		
		
		
	}
	
	
	public static void mergesort(String[] arr) {

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

		mergesort(tempLeft);
		mergesort(tempRight);

		int i = 0, j = 0, k = 0;

		while (i < middle && j < right) {

			if ((tempLeft[i].toUpperCase()).compareTo(tempRight[j].toUpperCase()) < 0)
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

	public static void mergesort(int[] arr) {

		if (arr.length < 2) {

			return;

		}

		int middle = arr.length / 2;
		int right = arr.length - middle;

		int[] tempLeft = new int[middle];
		int[] tempRight = new int[right];

		for (int i = 0; i < middle; i++) {

			tempLeft[i] = arr[i];

		}

		for (int i = middle; i < arr.length; i++) {

			tempRight[i - middle] = arr[i];

		}

		mergesort(tempLeft);
		mergesort(tempRight);

		int i = 0, j = 0, k = 0;

		while (i < middle && j < right) {

			if (tempLeft[i] < tempRight[j]) {

				arr[k++] = tempLeft[i++];

			}

			else {

				arr[k++] = tempRight[j++];

			}

		}

		while (i < middle) {

			arr[k++] = tempLeft[i++];

		}

		while (j < right) {

			arr[k++] = tempRight[j++];

		}

	}

	public static void mergesort(double[] arr) {
		
		if (arr.length < 2) {
			
			return;
			
		}
		
		int middle = arr.length / 2;
		int right = arr.length - middle;
		
		double[] tempLeft = new double[middle];
		double[] tempRight = new double[right];
		
		for (int i = 0; i < middle; i++) {
			
			tempLeft[i] = arr[i];
			
		}
		
		for (int i = middle; i < arr.length; i++) {
			
			tempRight[i - middle] = arr[i];
			
		}
		
		mergesort(tempLeft);
		mergesort(tempRight);
		
		int i = 0, j = 0, k = 0;
		
		while (i < middle && j < right) {
			
			if (tempLeft[i] < tempRight[k]) {
				
				arr[k++] = tempLeft[i++];
				
			}
			
			else {
				
				arr[k++] = tempRight[j++];
				
			}
		}
		
		while (i < middle) {
			
			arr[k++] = tempLeft[i++];
			
		}
		
		while (j < right) {
			
			arr[k++] = tempLeft[j++];
			
		}
	}
	
	public static String VerifyName(String name) {

		if (name.replaceAll("\\s+", "").matches("[a-zA-Z]*")) {

			return name;

		}

		else {

			System.out.println("Error: Invalid name!");
			return null;

		}
	}

	public static String VerifyEmail(String email) {

		if (email.contains("@") && email.contains(".com")) {

			return email;

		}

		else {

			System.out.println("Invalid email!");
			return null;

		}
	}

	public static String VerifyNumber(String number) {

		number = number.replace("-", "");

		if (number.matches("\\d+") && number.length() == 10) {

			return number;

		}

		else {

			System.out.println("Invalid number!");
			return null;

		}

	}

	public static void printArray(String[] array) {

		for (int i = 0; i < array.length; i++) {

			System.out.println(array[i]);

		}

	}

}
