import java.io.*;
import java.util.*;

public class Sorting_3 {
	public static void main(String[] args) throws IOException {

		Friend[] friends = readDatabase("friends.txt");

		boolean looping = true;
		int choice;

		while (looping) {

			System.out.println("1) Add a friend: ");
			System.out.println("2) Display friends by last name: ");
			System.out.println("3) Display friends by first name: ");
			System.out.println("4) Find a friend: ");
			System.out.println("5) Delete a friend: ");
			System.out.println("6) Quit: ");

			try {

				Scanner input = new Scanner(System.in);
				choice = input.nextInt();

				switch (choice) {

				case 0:
					break;
				case 1:
					friends = addFriend(friends);
					break;
				case 2:
					displayFriendsLast(friends);
					break;
				case 3:
					displayFriendsFirst(friends);
					break;
				case 4:
					searchFriends(friends);
					break;
				case 5:
					friends = deleteFriend(friends);
				case 6:
					looping = false;
					break;
				default:
					System.out.println("Invalid input, only numbers between 1 and 6.");
					break;

				}

			}

			catch (InputMismatchException e) {

				System.out.println("Invalid input.");
				choice = 0;

			}

		}

	}

	private static Friend[] readDatabase(String filename) throws FileNotFoundException, IOException {

		Scanner input = new Scanner(new File(filename));

		int lines = input.nextInt();
		input.nextLine();

		Friend[] friends = new Friend[lines];

		for (int i = 0; i < lines; i++) {

			String[] information = input.nextLine().split("/");

			friends[i] = new Friend(information[0], information[1], information[2], information[3]);

		}

		input.close();

		return friends;

	}

	private static Friend[] addFriend(Friend[] friends) throws IOException {

		Scanner input = new Scanner(System.in);
		
		Friend[] friendsnew = new Friend[friends.length + 1];

		for (int i = 0; i < friends.length; i++) {

			friendsnew[i] = friends[i];

		}

		try {

			String[] inputs = new String[4];

			while (inputs[0] == null) {

				System.out.println("Enter first name: ");
				inputs[0] = VerifyName(input.nextLine());

			}

			while (inputs[1] == null) {

				System.out.println("Enter last name: ");
				inputs[1] = VerifyName(input.nextLine());

			}

			while (inputs[2] == null) {

				System.out.println("Enter email: ");
				inputs[2] = VerifyEmail(input.nextLine());

			}

			while (inputs[3] == null) {

				System.out.println("Enter phone number: ");
				inputs[3] = VerifyNumber(input.nextLine());

			}

			friendsnew[friends.length] = new Friend(inputs[0], inputs[1], inputs[2], inputs[3]);

		}

		catch (InputMismatchException e) {

			System.out.println("Invalid input.");

		}

		return friendsnew;

	}

	private static void displayFriendsLast(Friend[] friends) {

		for (int i = 0; i < friends.length; i++) {

			System.out.println(i + ": " + friends[i].getName(0));

		}

		System.out.println();

	}

	private static void displayFriendsFirst(Friend[] friends) {

		for (int i = 0; i < friends.length; i++) {

			System.out.println(i + ": " + friends[i].getName(1));

		}

		System.out.println();

	}

	private static void searchFriends(Friend[] friends) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter friend to be searched for (name, email, phone number):  ");
		String key = input.nextLine();
		
		//Check Email
		if(key.contains("@gmail.com")) {
			
			for (int i = 0; i < friends.length; i++) {
				
				if(friends[i].getEmail().contains(key)) {
					
					System.out.println(i + ": " + friends[i]);
					System.out.println();
					
				}
			}
		}
		
		//Check Number
		else if(key.matches("\\d+")) {
			
			for (int i = 0; i < friends.length; i++) {
				
				if(friends[i].getPhone().contains(key)) {
					
					System.out.println(i + ": " + friends[i]);
					System.out.println();
					
				}
			}
		}
		
		//Check Names
		else if(key.matches("[a-zA-Z]*")) {
			
			for (int i = 0; i < friends.length; i++) {
				
				if(friends[i].getName(1).contains(key)) {
					
					System.out.println(i + ": " + friends[i]);
					System.out.println();
					
				}
				
				if(friends[i].getName(0).contains(key)) {
					
					System.out.println(i + ": " + friends[i]);
					System.out.println();
					
				}
			}
		}
		
		else {
			
			System.out.println("Invalid search!");
			
		}
	}

	private static Friend[] deleteFriend(Friend[] friends) {
		
		Scanner inputDelete = new Scanner(System.in);
		
		Friend[] friendsnew = new Friend[friends.length - 1];

		int index;
		
		try {

			System.out.println("Choose an index to delete from the database: (Numbers 0 through " + (friends.length - 1));
			index = inputDelete.nextInt();
		
			for (int i = 0, k = 0; i < friendsnew.length; i++) {
				
				if (i == index) {
					
					continue;
					
				}
				
				friendsnew[k++] = friends[i];
				
			}
			
		}
		
		catch (InputMismatchException e) {
			
			System.out.println("Invalid Input!");
			
		}
		
		return friendsnew;
		
	}
	
	private static String VerifyName(String nextLine) {

		if (nextLine.replaceAll("\\s+", "").matches("[a-zA-Z]*")) {

			return nextLine;

		}

		else {

			System.out.println("Error: Invalid name!");
			return null;

		}
	}

	
	private static String VerifyEmail(String nextLine) {

		if (nextLine.contains("@gmail.com")) {

			return nextLine;

		}

		else {

			System.out.println("Invalid email!");
			return null;

		}
	}

	
	private static String VerifyNumber(String nextLine) {

		nextLine = nextLine.replace("-", "");

		if (nextLine.matches("\\d+") && nextLine.length() == 10) {

			return nextLine;

		}

		else {

			System.out.println("Invalid number!");
			return null;

		}

	}

}
