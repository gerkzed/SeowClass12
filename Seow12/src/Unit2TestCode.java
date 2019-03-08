import java.util.*;

public class Unit2TestCode {
	public static void main(String[] args) {
		
		int[] array_nums = {77, 77, 65, 65, 65, 77};
		
		System.out.println("Original Array: " + Arrays.toString(array_nums));
		
		int num1 = 77;
		int num2 = 65;
		
		System.out.println("Result: " + result(array_nums, num1, num2));
		
	}

	private static boolean result(int[] array_nums, int num1, int num2) {

		int count1 = 0, count2 = 0;
		
		for(int i = 0; i < array_nums.length; i++) {
			
			if (array_nums[i] == num1) {
				
				count1++;
				
			}
			
			if (array_nums[i] == num2) {
				
				count2++;
				
			}
			
		}
		
		if (count1 > 0 && count2 > 0) {
			
			return true;
			
		}
		
		else {
			
			return false;
			
		}
		
	}
	
}
