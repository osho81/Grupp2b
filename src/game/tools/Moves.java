package game.tools;

import java.util.Random;
import java.util.Scanner;

public class Moves {

	public String[][] userInput(String[][] moveBoardUser, Scanner sc) {

		System.out.print(" P� vilken siffra vill du l�gga din markering? ");
		boolean valid = false;
		int row = 0, col = 0;
		int userChoice = getInput(sc, false);
		
		while (!valid) {

			if (userChoice == 1 || userChoice == 2 || userChoice == 3)
				row = 0;
			else if (userChoice == 4 || userChoice == 5 || userChoice == 6)
				row = 1;
			else
				row = 2;

			if (userChoice == 1 || userChoice == 4 || userChoice == 7)
				col = 0;
			else if (userChoice == 2 || userChoice == 5 || userChoice == 8)
				col = 1;
			else
				col = 2;

			if (!moveBoardUser[row][col].equalsIgnoreCase("X")  && !moveBoardUser[row][col].equalsIgnoreCase("O")) {
				valid = true;
			}else {
				System.out.println("Ogiltigt val f�rs�k igen");
				userChoice = getInput(sc, false);
			}
		}
		moveBoardUser[row][col] = "O";
		return moveBoardUser;
	} // end userInput
	
	// kontrollera inmatning (felhantera) och l�gg till logiken att anv�ndaren ska inte v�lja en ruta som inte existerar
	private int getInput(Scanner sc, boolean validInput) {
		int output = 0;
		while (!validInput) {
			try {
				output = sc.nextInt();
				if (output <= 9 && output > 0) // logiskt!
					validInput = true;
				else
					System.out.println("Ogiltigt val f�rs�k igen");
			} catch (Exception e) {
				System.out.println("Ogiltigt val f�rs�k igen");
				sc.next();
			}
		}
		return output;
	}

	// Computer generated move
	public String[][] computerMove(String[][] CompBoard) {

		int countMoves = 2; //f�rsta g�ngen while-loopen k�rs s� �r datorns drag drag nr 2 i spelet. 
		if (countMoves<8) { //k�r s� l�nge spelplanen inte �r full DET H�R FUNGERAR INTER Om jag s�tter if (countMoves<2) s� g�r den till if-satsen men annars g�r den in i if. F�rst�r ej varf�r och kan inte debugga detta.
			countMoves = countMoves + 2;
		System.out.print("Datorns drag.\n");
		Random rand = new Random();

		int randomRow = rand.nextInt(3); // slumpa ett v�rde
		int randomCol = rand.nextInt(3);
		// om dator val redan �r taget slumpas det igen
		while (CompBoard[randomRow][randomCol].equalsIgnoreCase("X")
				|| CompBoard[randomRow][randomCol].equalsIgnoreCase("O")) {
			randomRow = rand.nextInt(3);
			randomCol = rand.nextInt(3);
		}

		CompBoard[randomRow][randomCol] = "X";
		
		} else {
			System.out.println("Det blev oavgjort!");
		}
	
		
		

		return CompBoard;
		
		
		
		

	} // end generated computer move
} // end class
