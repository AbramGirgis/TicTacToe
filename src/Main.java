import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

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