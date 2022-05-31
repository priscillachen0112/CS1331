import java.util.*;
import java.io.*;

public class Battleship2 {

    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!");
        System.out.println(" "); System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");
        Scanner typeinOri = new Scanner(System.in);
        Scanner typein = typeinOri;
        int[][] play1_coor = getPlayerInput(typein);
        char[][] gameboard1 = locationBoard(play1_coor);
        printBattleShip(gameboard1); for (int i = 1; i <= 100; i++) {
            System.out.print("\n");
        }
        System.out.println(" ");
        System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
        int[][] play2_coor = getPlayerInput(typein);
        char[][] gameboard2 = locationBoard(play2_coor);
        printBattleShip(gameboard2);
        for (int i = 1; i <= 100; i++) {
            System.out.print("\n");
        }
        //game starts...//
        int player1score = 0;
        int player2score = 0;
        //initialising the targetboard...
        char[][] round1 = new char[5][5];
        char[][] round2 = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                round1[i][j] = '-'; round2[i][j] = '-';
            }
        }
        do {
            round1 = updateTargetboard(typein, 1, gameboard1, gameboard2, round1, round2);
            printBattleShip(round1);
            System.out.print("\n");
            round2 = updateTargetboard(typein, 2, gameboard1, gameboard2, round1, round2);
            printBattleShip(round2); player1score = 0; player2score = 0;
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++) {
                    if (round1[i][j] == 'X') {
                        player1score += 1;
                    }
                    if (round2[i][j] == 'X') {
                        player2score += 1;
                    }
                }
            }
        } while (player1score < 5 && player2score < 5 );

        char[][] player1finalboard = round2;
        char[][] player2finalboard = round1;
        if (player1score == 5) {
            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (gameboard1[i][j] == '@' && round2[i][j] != 'X') {
                        player1finalboard[i][j] = '@';
                    }
                }
            }
        }
        else {
            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (gameboard2[i][j] == '@' && round1[i][j] != 'X') {
                        player2finalboard[i][j] = '@';
                    }
                }
            }
        }
        System.out.print("\n");
        System.out.println("Final boards:");
        System.out.print("\n");
        printBattleShip(player1finalboard);
        System.out.print("\n");
        printBattleShip(player2finalboard);
    }
    //method to read each play's input
    private static int[][] getPlayerInput(Scanner typein) {
        int[][] input = {{5,5},{5,5},{5,5},{5,5},{5,5}};
        int m = 1;
        boolean correctInput = true;
        do {
            System.out.println("Enter ship " + m + " location:");
            int row = typein.nextInt();
            int col = typein.nextInt();
            correctInput = true;
            if (row >= 5 || col >= 5) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                correctInput = false;
            }
            for (int i = 0; i < 5; i++) {
                if (row == input[i][0] && col == input[i][1]) {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                    correctInput = false;
                }
            }
            if (correctInput)           {
                input[m-1][0] = row;
                input[m-1][1] = col;
                m++;
            }
        }
        while (m < 6);
        return input;
    }
    //method to track the fires
    private static char[][] updateTargetboard(Scanner typein, int playerID, char[][] gameboard1, char[][] gameboard2, char[][] player1targetboard, char[][] player2targetboard) {
        char[][] opponentboard = new char[5][5];
        char[][] targetboard = new char[5][5];
        int opponentID;
        if (playerID == 1) {
            opponentboard = gameboard2;
            opponentID = 2;
            targetboard = player1targetboard;
        }
        else {
            opponentboard = gameboard1;
            opponentID = 1;
            targetboard = player2targetboard;
        }

        boolean correctInput = false;
        do {
            System.out.println("Player " + playerID + ", enter hit row/column:");
            int row = typein.nextInt();
            int col = typein.nextInt();
            if (row >= 5 || col >= 5) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                correctInput = false;
            }
            else if (targetboard[row][col] == 'O' || targetboard[row][col] == 'X') {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                correctInput = false;
            }
            else if (opponentboard[row][col] == '@') {
                System.out.println("PLAYER " + playerID + " HIT PLAYER " + opponentID + "'s SHIP!");
                targetboard[row][col] = 'X';
                correctInput = true;
            }
            else    {
                System.out.println("PLAYER " + playerID + " MISSED!");
                targetboard[row][col] = 'O';
                correctInput = true;
            }
        } while (correctInput == false);
        return targetboard;
    }

    //method to construct the game boards
    private static char[][] locationBoard(int[][] player_coor) {
        char[][] gameboard = new char[5][5];
        for (int i = 0; i < 5; i++) {
            int row = player_coor[i][0];
            int col = player_coor[i][1];
            gameboard[row][col] = '@';
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameboard[i][j] != '@') {
                    gameboard[i][j] = '-';
                }
            }
        }
        return gameboard;
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
}