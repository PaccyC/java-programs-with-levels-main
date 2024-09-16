import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        // Play the game multiple times if the user desires
        while (playAgain) {
            initializeBoard();
            playGame(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
    }

    // Initialize/reset the board
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        currentPlayer = 'X'; // 'X' always starts
    }

    // Display the current state of the board
    private static void displayBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check if the game is won or drawn after each move
    private static void playGame(Scanner scanner) {
        boolean gameEnded = false;
        while (!gameEnded) {
            displayBoard();
            playerMove(scanner);
            gameEnded = checkWin() || checkDraw();

            // Switch players if the game isn't over
            if (!gameEnded) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    // Handle player moves
    private static void playerMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]): ");
            row = scanner.nextInt() - 1; // Convert to 0-index
            col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }
    }

    // Check if there's a winner
    private static boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i)) {
                System.out.println("Player " + currentPlayer + " wins!");
                return true;
            }
        }

        // Check diagonals
        if (checkDiagonals()) {
            System.out.println("Player " + currentPlayer + " wins!");
            return true;
        }

        return false;
    }

    // Check if there's a draw (board is full without a winner)
    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false; // Found an empty spot, not a draw
                }
            }
        }

        System.out.println("The game is a draw!");
        return true;
    }

    // Helper methods to check rows, columns, and diagonals
    private static boolean checkRow(int row) {
        return board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer;
    }

    private static boolean checkColumn(int col) {
        return board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer;
    }

    private static boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
}
