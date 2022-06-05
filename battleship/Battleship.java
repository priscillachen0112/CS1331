import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Battleship {
	public static char[][] initBoard(int n) {
		// YOUR CODE BELOW: initializes a board of size n * n
		char[][] board = new char[n][n];
		return board;
	}

	private static char[][] gameBoard(int[][] coordinates) {
		char[][] gameBoard = initBoard(5);
		for (int i=0; i<5; i++) {
			int row = coordinates[i][0];
			int column = coordinates[i][1];
			gameBoard[row][column] = '@';
		}
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (gameBoard[i][j] != '@') {
					gameBoard[i][j] = '-';
				}
			}
		}
		return gameBoard;
	}


	private static int[][] getPlayerInput(Scanner input) {
		int[][] coordinates = {
				{-1,-1},
				{-1,-1},
				{-1,-1},
				{-1,-1},
				{-1,-1}};
		int shipNumber = 1;
		boolean validInput;
		do{
			System.out.println("Enter ship" + shipNumber + " location:");
			int row = input.nextInt();
			int column = input.nextInt();
			validInput = true;
			if (row >= 5 || column >= 5) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				validInput = false;
			}
			for (int i=0; i<5; i++) {
				if (coordinates[i][0]==row && coordinates[i][1]==column) {
					System.out.println("You already have a ship there. Choose different coordinates.");
					validInput = false;
				}
			}
			if (validInput) {
				coordinates[shipNumber-1][0] = row;
				coordinates[shipNumber-1][1] = column;
				shipNumber++;
			}

			System.out.println(row + " " + column);
		} while (shipNumber <= 5);

		/*System.out.println(coordinates);*/
		return coordinates;
	}


    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}


	private static char[][] fireMissile(int playerNum, Scanner input,
										char[][] gameBoard1, char[][] gameBoard2,
										char[][] round1, char[][] round2) {

		int oppNum;
		char[][] gameBoard;
		char[][] round;

		if (playerNum == 1) {
			oppNum = 2;
			gameBoard = gameBoard2;
			round = round1;
		} else {
			oppNum = 1;
			gameBoard = gameBoard1;
			round = round2;
		}

		boolean validInput = false;
		do {
			System.out.println("Player " + playerNum + ", enter hit row/column:");

			int row = input.nextInt();
			int column = input.nextInt();

			if (row >= 5 || column >= 5) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				validInput = false;
			} else if (gameBoard[row][column] == '-') {
				System.out.println("PLAYER " + playerNum + " MISSED!");
				round[row][column] = 'O';
				gameBoard[row][column] = 'O';
				validInput = true;
			} else if (gameBoard[row][column] == 'O' || gameBoard[row][column] == 'X') {
				System.out.println("You already fired on this spot. Choose different coordinates.");
				validInput = false;
			} else if (gameBoard[row][column] == '@') {
				System.out.println("PLAYER " + playerNum + " HIT PLAYER " + oppNum + "'s SHIP!");
				round[row][column] = 'X';
				gameBoard[row][column] = 'X';
				validInput = true;
			}
		} while (validInput == false);
		return round;
	}


	private static boolean endGame(char[][] gameBoard) {
		boolean endGame = false;
		int hits = 0;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				if (gameBoard[i][j] == 'X') {
					hits++;
				}
			}
		}
		if (hits == 5) {
			endGame = true;
		}
		return endGame;
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Battleship!");
		System.out.println(" ");
		System.out.println("PLAYER1, ENTER YOUR SHIPS' COORDINATES.");
		int[][] player1Input = getPlayerInput(input);
		char[][] gameBoard1 = gameBoard(player1Input);

		printBattleShip(gameBoard1);

		for (int i=0; i<100; i++) {
			System.out.println("\n");
		}

		System.out.println("PLAYER2, ENTER YOUR SHIPS' COORDINATES.");
		int[][] player2Input = getPlayerInput(input);
		char[][] gameBoard2 = gameBoard(player2Input);

		printBattleShip(gameBoard2);


		for (int i=0; i<100; i++) {
			System.out.println("\n");
		}


		boolean endGame = false;
		int playerNum = 1;

		char[][] round1 = initBoard(5);
		char[][] round2 = initBoard(5);

		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				round1[i][j] = '-';
				round2[i][j] = '-';
			}
		}


		while (endGame == false) {
			char[][] hitBoard1;
			char[][] hitBoard2;

			if (playerNum % 2 == 1) {

				playerNum = 1;
				hitBoard1 = fireMissile(playerNum, input, gameBoard1, gameBoard2, round1, round2);
				printBattleShip(hitBoard1);

				endGame = endGame(hitBoard1);
				if (endGame) {
					System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
				}

			} else {

				playerNum = 2;
				hitBoard2 = fireMissile(playerNum, input, gameBoard1, gameBoard2, round1, round2);
				printBattleShip(hitBoard2);

				endGame = endGame(hitBoard2);
				if (endGame) {
					System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
				}
			}
			playerNum += 1;
		}
	}
}