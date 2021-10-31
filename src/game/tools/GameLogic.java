package game.tools;

import java.util.Scanner;



// GameLogic har startats i Main, som i sin tur kontrollerar spelstrukturen

public class GameLogic {
	
	PrintOut printOut = new PrintOut(); // Skapa objekt av klassen PrintOut
	Moves moves = new Moves(); // skapar objekt av klassen Moves

	String[][] board; // Deklareras h�r s� den �r tillg�nnglig i hela klassen
	
	public void run() { // Anropad fr�n Main; kontrollerar spelstrukturen

		initiateArray();
		System.out.println(
				"V�lkommen till tre i rad! \nDina rutor markeras med O och datorns med X. Vars�god att b�rja.");

		// Anropa metoden printBoard i klassen PrintOut, genom objektet printOut

		printOut.printBoard(board); // skriver ut spelplanen f�r f�rsta g�ngen

		boolean noWin = true;
		int numOfMoves = 0;
		Scanner sc = new Scanner(System.in);
		// loopa tills vinnare eller spelplanen full
		while (noWin && numOfMoves < 9) {
			board = moves.userInput(board, sc); // anv�ndarens drag

			printOut.printBoard(board); // utskrift efter anv�ndarens drag

			
			if(numOfMoves<8) {
				board = moves.computerMove(board); // datorns drag

				printOut.printBoard(board); // utskrift efter datorns drag
			
			

				noWin = WinCheck.winChecker(board);
				numOfMoves = numOfMoves + 2; 
				
			}else if (numOfMoves==8){
				System.out.println("Det blev oavgjort!");
				
		}//end else
		}//end while
		sc.close();
	}//end run

	private void initiateArray() {
		board = new String[3][3]; // Redan deklarerad �verst

		for (int row = 0, count = 1; row < board.length; row++) { // Count g�r fr�n 1-9

			// count 1-3 tilldelas row 1, count 4-6 tilldelas row 2, count 7-9 tilldelas row
			// 3
			for (int col = 0; col < board[row].length; col++, count++) {
				board[row][col] = count + ""; // Typomvandla int till string, med genv�g
			}
		}
	}

}// end class
