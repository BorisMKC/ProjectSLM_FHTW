/**
 * Represents a Tic Tac Toe game with a board and two players.
 * Manages the state of the game, including switching turns and determining the winner.
 */
public class TicTacToe {

    /**
     * player1 is using the marker 'X'.
     */
    public Player player1;

    /**
     * player2 is using the marker 'O'.
     */
    public Player player2;

    /**
     * The current player whose turn it is to play.
     */
    public Player currentPlayer;

    /**
     * The game board upon which the game is played.
     */
    public Board board;

    /**
     * Initializes a new Tic Tac Toe game with two players and a blank board.
     * In this scenario, player1 ('X') starts the game.
     */
    public TicTacToe() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    /**
     * Starts a new game by clearing the board and setting the current player to player1.
     */
    public void start() {
        board.clear();
        currentPlayer = player1;
    }

    /**
     * Switches the current player to the next player in the turn order.
     */
    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Determines if there is a winner in the game based on the current state of the board.
     *
     * @return true if there is a winner, false otherwise.
     */
    public boolean hasWinner() {
        char marker = currentPlayer.getMarker();

        // For loop to iterate through all cells vertically, horizontally and diagonally
        for (int i =  0; i <  3; i++) {
            if ((board.cells[i][0] == marker && board.cells[i][1] == marker && board.cells[i][2] == marker) ||
                    (board.cells[0][i] == marker && board.cells[1][i] == marker && board.cells[2][i] == marker)) {
                return true;
            }
        }

        if ((board.cells[0][0] == marker && board.cells[1][1] == marker && board.cells[2][2] == marker) ||
                (board.cells[0][2] == marker && board.cells[1][1] == marker && board.cells[2][0] == marker)) {
            return true;
        }
        // If no winner is found, return false
        return false;
    }
}

