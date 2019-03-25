import java.io.*;
import java.util.*;
import src.*;

public class Sorting_3 {
	public static void main(String[] args) {
		
		readDatabase("friends.txt");
		
		
		
	}

	private static void readDatabase(String filename) throws FileNotFoundException {

		Scanner input = new Scanner(new File(filename));
		
		int lines = input.nextInt();
		Friend[] friends = new Friends[lines];
		
		for(int i = 0; i < lines; i++) {
			
			
			
			
		}
		
	}

}
