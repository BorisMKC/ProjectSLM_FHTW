import java.util.Scanner;

/**
 * The entry point for the Tic Tac Toe game application.
 * Initializes the game, takes user input for moves, and manages the game flow.
 */
public class Main {
    /**
     * The main method that launches the Tic Tac Toe game.
     * It creates a new game instance, starts the game, and handles user input for moves.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // Create a new Scanner Instance for Input
        Scanner scanner = new Scanner(System.in);

        // Create & Start a new game of TicTacToe
        TicTacToe game = new TicTacToe();
        game.start();

        /*
         * The main game loop. It continues until the game ends either by a win or by a draw.
         */
        while (true) {
            System.out.println("Current board: ");
            game.board.print();

            int row, col;
            boolean correctInput;

            do {
                System.out.println("Current Player: " + game.currentPlayer.getMarker());

                System.out.println("Enter row (0,   1,   2): ");
                row = scanner.nextInt();
                System.out.println("Enter column(0,   1,   2): ");
                col = scanner.nextInt();

                try {
                    // Validate user inputs
                    if (row <   0 || row >   2 || col <   0 || col >   2) {
                        throw new Exception("Invalid input. Please enter a row and column between 0 and 2.");
                    }

                    // Check if the cell is already taken (Error Handling)
                    if (!game.board.isCellEmpty(row, col)) {
                        throw new Exception("Cell (" + row + ", " + col + ") is already taken. Please choose another cell.");
                    }

                    game.board.place(row, col, game.currentPlayer.getMarker());
                    correctInput = true; // If no exceptions are thrown, the input is valid
                } catch (Exception e) {
                    System.out.println(e.getMessage()); // Print the error message
                    correctInput = false; // Set to false in order to repeat the loop
                }
            } while (!correctInput);

            game.board.place(row, col, game.currentPlayer.getMarker());

            if (game.hasWinner()) {
                System.out.println("Player " + game.currentPlayer.getMarker() + " wins!");
                game.board.print();
                break;
            } else if (game.board.isFull()) {
                System.out.println("It is a draw...");
                game.board.print();
                break;
            }
            game.switchCurrentPlayer();
        }
        scanner.close();
    }
}
