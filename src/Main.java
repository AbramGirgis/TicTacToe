import java.util.*;

public class Main {

    static Scanner in = new Scanner(System.in);
    static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> computerPositions = new ArrayList<>();

    public static void main(String[] args) {

        //Print the game board
        printGameBoard(gameBoard);

        while (true) {
            // Player input
            System.out.println("\nPlayer1 turn...");
            player1Move();

            //Check if player wins!
            String result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }

            //Computer input (random)
            System.out.println("\nComputer turn...");
            playerComputerMove();

            //Check if computer wins!
            result = checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }
        }

    }

    private static void playerComputerMove() {
        Random rand = new Random();
        int computerPosition = rand.nextInt(9) + 1;
        if (playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)) {
            playerComputerMove();
        } else {
            placePiece(computerPosition, 'O');
            computerPositions.add(computerPosition);
            printGameBoard(gameBoard);
        }
    }

    private static void player1Move() {
        System.out.print("Enter your placement (1-9): ");
        int playerPosition = in.nextInt();
        if (playerPosition > 9 || playerPosition < 1) {
            System.out.println("Wrong choice! please choose a number from 1 to 9!");
            player1Move();
        } else if (playerPositions.contains(playerPosition) || computerPositions.contains(playerPosition)) {
            System.out.println("Position is taken! please enter a correct position!");
            player1Move();
        } else {
            System.out.println(playerPosition);
            placePiece(playerPosition, 'X');
            playerPositions.add(playerPosition);
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

    private static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List diagonal1 = Arrays.asList(1,5,9);
        List diagonal2 = Arrays.asList(3,5,7);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(diagonal1);
        winningConditions.add(diagonal2);

        for (List l : winningConditions){
            if (playerPositions.containsAll(l)){
                return "Congratulations, you won!";
            } else if (computerPositions.containsAll(l)) {
                return "Computer wins! Sorry :(";
            } else if ((playerPositions.size() + computerPositions.size()) == 9){
                return "Draw!";
            }
        }

        return "";
    }

}