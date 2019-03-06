import java.util.*;

public class Arrays_4 {
	public static void main(String[] args) {

		// CREATE A 2D ARRAY
		String[][] board = new String[5][5];

		board = genPrizes(board);
		board = genNull(board);

		printBoard(board);
		System.out.println();

		throwPenny(board);

	}

	private static String[][] genPrizes(String[][] board) {

		int[] randInt = new int[2];

		for (int i = 3; i > 0; i--) {

			randInt = genSpace(randInt);

			if (board[randInt[0]][randInt[1]] == null) {

				board[randInt[0]][randInt[1]] = "[ PUZZLE ]";

			}

			else {

				i += 1;

			}

		}

		for (int i = 3; i > 0; i--) {

			randInt = genSpace(randInt);

			if (board[randInt[0]][randInt[1]] == null) {

				board[randInt[0]][randInt[1]] = "[ POSTER ]";

			}

			else {

				i += 1;

			}

		}

		for (int i = 3; i > 0; i--) {

			randInt = genSpace(randInt);

			if (board[randInt[0]][randInt[1]] == null) {

				board[randInt[0]][randInt[1]] = "[  DOLL  ]";

			}

			else {

				i += 1;

			}

		}

		for (int i = 3; i > 0; i--) {

			randInt = genSpace(randInt);

			if (board[randInt[0]][randInt[1]] == null) {

				board[randInt[0]][randInt[1]] = "[  GAME  ]";

			}

			else {

				i += 1;

			}

		}

		return board;

	}

	private static String[][] genNull(String[][] board) {

		for (int i = 0; i < 5; i++) {

			for (int j = 0; j < 5; j++) {

				if (board[i][j] == null) {

					board[i][j] = "[        ]";

				}

			}
		}

		return board;

	}

	private static void printBoard(String[][] board) {

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				System.out.print(board[i][j] + " ");

			}

			System.out.println();

		}

	}

	private static void throwPenny(String[][] board) {

		int puzzle = 0;
		int poster = 0;
		int doll = 0;
		int game = 0;

		int[] randInt = new int[2];

		for (int i = 0; i < 10; i++) {

			randInt = genSpace(randInt);

			switch (board[randInt[0]][randInt[1]]) {

			case "[ PUZZLE ]":
				board[randInt[0]][randInt[1]] = "[  PENNY ]";
				printBoard(board);
				System.out.println();
				puzzle++;
				break;

			case "[ POSTER ]":
				board[randInt[0]][randInt[1]] = "[  PENNY ]";
				printBoard(board);
				System.out.println();
				poster++;
				break;

			case "[  DOLL  ]":
				board[randInt[0]][randInt[1]] = "[  PENNY ]";
				printBoard(board);
				System.out.println();
				doll++;
				break;

			case "[  GAME  ]":
				board[randInt[0]][randInt[1]] = "[  PENNY ]";
				printBoard(board);
				System.out.println();
				game++;
				break;

			case "[        ]":
				board[randInt[0]][randInt[1]] = "[  PENNY ]";
				printBoard(board);
				System.out.println();
				break;

			case "[  PENNY ]":
				i--;
				break;

			}
		}

		if (puzzle == 3) {

			System.out.println("YOU HAVE WON A PUZZLE!");

		}

		if (poster == 3) {

			System.out.println("YOU HAVE WON A POSTER!");

		}

		if (doll == 3) {

			System.out.println("YOU HAVE WON A DOLL!");

		}

		if (game == 3) {

			System.out.println("YOU HAVE WON A GAME!");

		}

		else if (puzzle != 3 && poster != 3 && doll != 3 && game != 3) {

			System.out.println("SORRY, YOU HAVEN'T WON ANYTHING!");

		}

	}

	private static int[] genSpace(int[] randInt) {

		Random generator = new Random();

		randInt[0] = generator.nextInt(5);
		randInt[1] = generator.nextInt(5);

		return randInt;
	}
}
