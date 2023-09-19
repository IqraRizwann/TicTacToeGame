package Game;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        boolean gameOver = false;
        int moves = 0;

        while (!gameOver && moves < 9) {
            makeMove();
            displayBoard();
            gameOver = checkGameOver();
            switchPlayer();
            moves++;
        }

        if (gameOver) {
            switchPlayer(); // Switch back to the winning player
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.println("Player " + currentPlayer + ", enter row (0, 1, or 2) and column (0, 1, or 2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');

        board[row][col] = currentPlayer;
    }

    private static boolean checkGameOver() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private static boolean checkRows() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColumns() {
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
