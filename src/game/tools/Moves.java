package game.tools;

import java.util.Random;
import java.util.Scanner;

public class Moves {

	// Method takes controlling id, our board, and scanner object (created in Main)
	public void makeMove(int id, String[][] board, Scanner sc) {

		if (id == 0) // If current id is 0...
			user(board, sc); // ...run user move method
		if (id == 1) // If current id is 1...
			comp(board); // ...run computer move generating method
	}

	// Computer generated move
	private void comp(String[][] board) {

		System.out.println("Computer move:");
		Random rnd = new Random();
		int x = -1, y = -1; // x = row; y = column
		boolean valid;
		x = rnd.nextInt(3); // Random numbers generated: 0, 1 or 2
		y = rnd.nextInt(3);
		// If board value of generated board spot is x or o (i.e. taken), valid is
		// false, otherwise valid is true
		valid = (board[x][y].equalsIgnoreCase("x") || board[x][y].equalsIgnoreCase("o")) ? false : true;
		// If valid is false (!valid), then while condition is true >> while loop runs
		// (Otherwise skip loop)
		while (!valid) {
			x = rnd.nextInt(3); // New row/col pairs are generated
			y = rnd.nextInt(3);
			// Valid is true when generated board spot is not (!) x or o; loop breaks
			valid = (!board[x][y].equalsIgnoreCase("x") && !board[x][y].equalsIgnoreCase("o"));
		}
		// Generated board spot is assigned an O; with or without the loop
		board[x][y] = "O";
	}

	// metoden tar emot användaren inmatning
	private void user(String[][] board, Scanner sc) {

		System.out.print("Choose a spot: ");
		int pick = getUserInput(sc);
		boolean valid = false;

		/*
		 * while loopen kollar att inmatat värdet skapa ingen konflikt med valda drag
		 * (datorns/användarens)
		 */
		while (!valid) {
			int x = -1, y = -1, found = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j].equals(pick + "")) {
						found++;
						x = i;
						y = j;
						break;
					}
				}
			}
			if (found > 0) {
				board[x][y] = "X"; // om värdet är giltigt tilldela det till arrayn
				valid = true;
			} else {
				System.out.println("3- invalid input try again:");
				pick = getUserInput(sc); // annars användaren matar in ett nytt värde
			}
		}
	}

	/*
	 * metoden tvingar användaren att mata en siffra mellan 1 och 9 och inte någon
	 * annan char - sedan returnerar den en giltig siffra
	 */
	private int getUserInput(Scanner sc) {
		int output = -1;
		boolean valid = false;
		while (!valid) {
			try {
				output = sc.nextInt();
				valid = (output <= 9 && output > 0) ? true : false;
			} catch (Exception e) {
				System.out.println("1- invalid input try again:");
				sc.next();
			}
		}
		return output;
	}

}
