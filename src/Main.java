import java.util.Scanner;

public class Main {

    static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public static void main(String[] args) {

        //Print the game board
        printGameBoard(gameBoard);

        Scanner in = new Scanner(System.in);

        // Player input
        System.out.print("Enter your placement (1-9): ");
        int playerPosition = in.nextInt();
        System.out.println(playerPosition);
        placePiece(playerPosition, 'X');



    }

    private static void placePiece(int playerPosition, char x) {
        switch (playerPosition){
            case 1:
                gameBoard[0][0] = 'X';
                break;
            case 2:
                gameBoard[0][2] = 'X';
                break;
            case 3:
                gameBoard[0][4] = 'X';
                break;
            case 4:
                gameBoard[2][0] = 'X';
                break;
            case 5:
                gameBoard[2][2] = 'X';
                break;
            case 6:
                gameBoard[2][4] = 'X';
                break;
            case 7:
                gameBoard[4][0] = 'X';
                break;
            case 8:
                gameBoard[4][2] = 'X';
                break;
            case 9:
                gameBoard[4][4] = 'X';
                break;
            default:
                System.out.println("Wrong choice! please choose a number from 1 to 9!");
        }
        printGameBoard(gameBoard);
    }

    private static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard){
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

}