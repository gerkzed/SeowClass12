import java.io.*;
import java.util.*;

public class Sorting_4 {
	public static void main(String[] args) throws IOException {

		/*
		
		MAZE LEGEND
		________________
		
		x = WALL
		$ = GOAL
		  = VALID SPACE
		+ = PATH THE ALGORITHM TOOK
		# = PATH THE ALGORTIHM TOOK AND HAD TO BACKTRACK

		*/
		
		final String filename = "maze3.txt";
		
		String[][] maze = parseMaze(filename);

		printMaze(maze);

		findPathway(maze, 1, 1);

		printMaze(maze);

		int[] goal = findGoalIndex(maze);

		String[][] mazeGoal = maze.clone();
		
		printRoute(mazeGoal, goal[0], goal[1]);

	}

	private static String[][] parseMaze(String filename) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(filename));

		int rows = Integer.parseInt(reader.readLine());
		int cols = Integer.parseInt(reader.readLine());

		String[][] maze = new String[rows][cols];

		for (int i = 0; i < rows; i++) {

			maze[i] = reader.readLine().split("");

		}

		reader.close();

		return maze;

	}

	private static void printMaze(String[][] maze) {

		for (int i = 0; i < maze.length; i++) {

			for (int k = 0; k < maze[i].length; k++) {
				
				System.out.print(maze[i][k]);
				
			}
			
			System.out.println();
			
		}
		
		System.out.println();
		
	}

	private static void printRoute(String[][] maze, int x, int y) {

		if (x == 1 && y == 1) {

			return;

		}

		// ROUTE NORTH
		if (maze[x][y - 1].equals("+")) {

			maze[x][y] = "#";
			y--;
			System.out.println("(" + x + " " + y + ")");
			printRoute(maze, x, y);

		}

		// ROUTE SOUTH
		else if (maze[x][y + 1].equals("+")) {
			
			maze[x][y] = "#";
			y++;
			System.out.println("(" + x + " " + y + ")");
			printRoute(maze, x, y);

		}

		// ROUTE EAST
		else if (maze[x + 1][y].equals("+")) {

			maze[x][y] = "#";
			x++;
			System.out.println("(" + x + " " + y + ")");
			printRoute(maze, x, y);

		}

		// ROUTE WEST
		else if (maze[x - 1][y].equals("+")) {

			maze[x][y] = "#";
			x--;
			System.out.println("(" + x + " " + y + ")");
			printRoute(maze, x, y);

		}

	}

	private static void findPathway(String[][] maze, int x, int y) {

		if (maze[x][y].equals("$")) {

			return;

		}

		// NORTH
		if (canGoNorth(maze, x, y) && !maze[x - 1][y].equals("+")) {

			maze[x][y] = "+";

			x--;
			findPathway(maze, x, y);

		}

		// SOUTH
		else if (canGoSouth(maze, x, y) && !maze[x + 1][y].equals("+")) {

			maze[x][y] = "+";

			x++;
			findPathway(maze, x, y);

		}

		// EAST
		else if (canGoEast(maze, x, y) && !maze[x][y + 1].equals("+")) {

			maze[x][y] = "+";

			y++;
			findPathway(maze, x, y);

		}

		// WEST
		else if (canGoWest(maze, x, y) && !maze[x][y - 1].equals("+")) {

			maze[x][y] = "+";

			y--;
			findPathway(maze, x, y);

		}

		// BACKTRACK NORTH
		else if (!canGoSouth(maze, x, y) && !canGoEast(maze, x, y) && !canGoWest(maze, x, y) && maze[x - 1][y].equals("+")) {

			maze[x][y] = "#";

			x--;
			findPathway(maze, x, y);

		}

		// BACKTRACK SOUTH
		else if (!canGoNorth(maze, x, y) && !canGoEast(maze, x, y) && !canGoWest(maze, x, y) && maze[x + 1][y].equals("+")) {

			maze[x][y] = "#";

			x++;
			findPathway(maze, x, y);

		}

		// BACKTRACK EAST
		else if (!canGoNorth(maze, x, y) && !canGoSouth(maze, x, y) && !canGoWest(maze, x, y) && maze[x][y + 1].equals("+")) {

			maze[x][y] = "#";

			y++;
			findPathway(maze, x, y);

		}

		// BACKTRACK WEST
		else if (!canGoNorth(maze, x, y) && !canGoSouth(maze, x, y) && !canGoEast(maze, x, y) && maze[x][y - 1].equals("+")) {

			maze[x][y] = "#";

			y--;
			findPathway(maze, x, y);

		}
		
		else {
			
			System.out.println("Error: No path found to go or cannot backtrack this path. The maze has no solution.");
			System.exit(0);
			
		}

	}

	private static boolean canGoNorth(String[][] maze, int x, int y) {

		if (!maze[x - 1][y].equals("x") && !maze[x - 1][y].equals("#") && !maze[x - 1][y].equals("+")) {

			return true;

		}

		else {

			return false;

		}
	}

	private static boolean canGoSouth(String[][] maze, int x, int y) {

		if (!maze[x + 1][y].equals("x") && !maze[x + 1][y].equals("#") && !maze[x + 1][y].equals("+")) {

			return true;

		}

		else {

			return false;

		}
	}

	private static boolean canGoEast(String[][] maze, int x, int y) {

		if (!maze[x][y + 1].equals("x") && !maze[x][y + 1].equals("#") && !maze[x][y + 1].equals("+")) {

			return true;

		}

		else {

			return false;

		}
	}

	private static boolean canGoWest(String[][] maze, int x, int y) {

		if (!maze[x][y - 1].equals("x") && !maze[x][y - 1].equals("#") && !maze[x][y - 1].equals("+")) {

			return true;

		}

		else {

			return false;

		}
	}

	private static int[] findGoalIndex(String[][] maze) {

		int[] coords = new int[2];

		for (int i = 0; i < maze.length; i++) {

			for (int k = 0; k < maze[i].length; k++) {

				if (maze[i][k].equals("$")) {

					coords[0] = i;
					coords[1] = k;

				}

			}

		}

		System.out.println("(" + coords[0] + " " + coords[1] + ")");
		
		return coords;

	}
}
