import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public static void main(String[] args) {

        //Print the game board
        printGameBoard(gameBoard);

        boolean check = true;
        while (check) {
            // Player input
            System.out.println("Player1 turn...");
            player1Move();

            //Computer input (random)
            System.out.println("\nComputer turn...");
            playerComputerMove();
        }

    }

    private static void playerComputerMove() {
        Random rand = new Random();
        int computerPosition = rand.nextInt(9) + 1;
        placePiece(computerPosition, 'O');
        printGameBoard(gameBoard);
    }

    private static void player1Move() {
        System.out.print("Enter your placement (1-9): ");
        int playerPosition = in.nextInt();
        if (playerPosition > 9 || playerPosition < 1) {
            System.out.println("Wrong choice! please choose a number from 1 to 9!");
            player1Move();
        } else {
            System.out.println(playerPosition);
            placePiece(playerPosition, 'X');
            printGameBoard(gameBoard);
        }
    }

    private static void placePiece(int position, char c) {
        switch (position) {
            case 1:
                gameBoard[0][0] = c;
                break;
            case 2:
                gameBoard[0][2] = c;
                break;
            case 3:
                gameBoard[0][4] = c;
                break;
            case 4:
                gameBoard[2][0] = c;
                break;
            case 5:
                gameBoard[2][2] = c;
                break;
            case 6:
                gameBoard[2][4] = c;
                break;
            case 7:
                gameBoard[4][0] = c;
                break;
            case 8:
                gameBoard[4][2] = c;
                break;
            case 9:
                gameBoard[4][4] = c;
                break;
            default:
                break;
        }

    }

    private static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}