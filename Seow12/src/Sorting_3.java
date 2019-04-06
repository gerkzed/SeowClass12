import java.io.*;
import java.util.*;

public class Sorting_3 {
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		Friend[] friends = readDatabase("friends.txt");

		boolean looping = true;
		int choice;

		while (looping) {

			System.out.println("1) Add a friend: ");
			System.out.println("2) Display friends by first name: ");
			System.out.println("3) Display friends by last name: ");
			System.out.println("4) Find a friend: ");
			System.out.println("5) Delete a friend: ");
			System.out.println("6) Quit: ");

			try {

				choice = input.nextInt();

				switch (choice) {

				case 1:
					addFriend(friends);
					friends = readDatabase("friends.txt");
					break;
				case 2:
					displayFriends(friends, 0);
					break;
				case 3:
					displayFriends(friends, 1);
					break;
				case 4:
					searchFriends(friends);
					break;
				case 5:
					deleteFriend(friends);
					friends = readDatabase("friends.txt");
					break;
				case 6:
					System.out.println("Quitting program");
					looping = false;
					System.exit(0);
				default:
					throw new InputMismatchException();
				}

			}

			catch (InputMismatchException e) {

				System.out.println("Invalid input.");
				System.exit(0);

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

		return friends;

	}

	private static void addFriend(Friend[] friends) throws IOException {

		try {

			Scanner input = new Scanner(System.in);

			String[] inputs = new String[4];

			while (inputs[0] == null) {

				System.out.println("Enter first name: ");
				inputs[0] = WillLib.VerifyName(input.nextLine());

			}

			while (inputs[1] == null) {

				System.out.println("Enter last name: ");
				inputs[1] = WillLib.VerifyName(input.nextLine());

			}

			while (inputs[2] == null) {

				System.out.println("Enter email: ");
				inputs[2] = WillLib.VerifyEmail(input.nextLine());

			}

			while (inputs[3] == null) {

				System.out.println("Enter phone number: ");
				inputs[3] = WillLib.VerifyNumber(input.nextLine());

			}

			Scanner file = new Scanner(new File("friends.txt"));

			int lines = file.nextInt();
			file.nextLine();

			String[] tempFile = new String[lines];

			for (int i = 0; i < lines; i++) {

				tempFile[i] = file.nextLine();

			}

			PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("friends.txt")));

			pr.println(lines + 1);

			for (int i = 0; i < lines; i++) {

				pr.println(tempFile[i]);

			}

			pr.println(inputs[0] + "/" + inputs[1] + "/" + inputs[2] + "/" + inputs[3]);

			pr.close();

		}

		catch (InputMismatchException e) {

			System.out.println("Invalid input.");

		}

	}

	private static void displayFriends(Friend[] friends, int name) {

		// FIRST
		if (name == 1) {

			String[] lastNameFriends = new String[friends.length];

			for (int i = 0; i < friends.length; i++) {

				lastNameFriends[i] = friends[i].getName(0);

			}

			WillLib.mergesort(lastNameFriends);

			WillLib.printArray(lastNameFriends);

		}

		// LAST
		else if (name == 0) {

			String[] firstNameFriends = new String[friends.length];

			for (int i = 0; i < friends.length; i++) {

				firstNameFriends[i] = friends[i].getName(1);

			}

			WillLib.mergesort(firstNameFriends);

			WillLib.printArray(firstNameFriends);

		}
	}

	private static void searchFriends(Friend[] friends) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter friend to be searched for (name, email, phone number):  ");
		String key = input.nextLine();

		// Check Email
		if (key.contains("@")) {

			for (int i = 0; i < friends.length; i++) {

				if (friends[i].getEmail().contains(key)) {

					System.out.println(i + ": " + friends[i]);
					System.out.println();

				}
			}
		}

		// Check Number
		else if (key.matches("\\d+")) {

			for (int i = 0; i < friends.length; i++) {

				if (friends[i].getPhone().contains(key)) {

					System.out.println(i + ": " + friends[i]);
					System.out.println();

				}
			}
		}

		// Check Names
		else if (key.matches("[a-zA-Z]*")) {

			for (int i = 0; i < friends.length; i++) {

				if (friends[i].getName(1).contains(key)) {

					System.out.println(i + ": " + friends[i]);
					System.out.println();

				}

				else if (friends[i].getName(0).contains(key)) {

					System.out.println(i + ": " + friends[i]);
					System.out.println();

				}
			}
		}

		else {

			System.out.println("Invalid search!");

		}
	}

	private static void deleteFriend(Friend[] friends) throws IOException {

		Scanner input = new Scanner(System.in);
		Scanner file = new Scanner(new File("friends.txt"));

		String search;

		try {

			System.out.println("Enter friend to be deleted (name, email, phone number):  ");
			search = input.nextLine();

			int lines = file.nextInt();
			file.nextLine();

			String[] tempFile = new String[friends.length];

			int k = 0;
		
			while (file.hasNextLine()) {
				
				String next = file.nextLine();
				
				if (next.contains(search)) {
					
					System.out.println(friends[k].getName(0) + " " + friends[k].getName(1) + " has been deleted from the database.");
					continue;
					
				}
				
				else {
					
					tempFile[k] = next;
					k++;
					
				}
			}

			PrintWriter pr = new PrintWriter(new BufferedWriter(new FileWriter("friends.txt")));

			int counter = 0;

			for (int i = 0; i < tempFile.length; i++) {

				if (tempFile[i] != null) {

					counter++;

				}

			}
			
			if (counter == tempFile.length) {
				
				System.out.println("Search has no results, nobody was deleted from the database.");
				
			}

			pr.println(counter);

			for (int i = 0; i < tempFile.length; i++) {

				if (tempFile[i] != null) {

					pr.println(tempFile[i]);

				}

			}

			pr.close();

		}

		catch (InputMismatchException e) {

			System.out.println("Invalid Input!");

		}
	}
}
