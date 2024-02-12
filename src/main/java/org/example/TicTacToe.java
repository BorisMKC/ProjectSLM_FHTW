package org.example;

public class TicTacToe {
    public Player player1;
    public Player player2;
    public Player currentPlayer;
    public  Board board;

    public TicTacToe() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    public void start() {
        board.clear();
        currentPlayer = player1;

    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char marker = currentPlayer.getMarker();

        for (int i = 0; i < 3; i++) {
            if ((board.cells[i][0] == marker && board.cells[i][1] == marker && board.cells[i][2] == marker) ||
                    (board.cells[0][i] == marker && board.cells[1][i] == marker && board.cells[2][i] == marker)) {
                return true;
            }
        }

        if ((board.cells[0][0] == marker && board.cells[1][1] == marker && board.cells[2][2] == marker) ||
                (board.cells[0][2] == marker && board.cells[1][1] == marker && board.cells[2][0] == marker)) {
            return true;
        }
        return false;
    }
}