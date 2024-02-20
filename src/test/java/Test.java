import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    /* Class TicTacToe Unit Tests */

    @org.junit.jupiter.api.Test
    public void testConstructor() {
        TicTacToe game = new TicTacToe();
        assertNotNull(game.board);
        assertEquals('X', game.player1.getMarker());
        assertEquals('O', game.player2.getMarker());
        assertEquals(game.player1, game.currentPlayer);
    }

    @org.junit.jupiter.api.Test
    public void testStart() {
        TicTacToe game = new TicTacToe();
        game.start();
        assertNotNull(game.board);
        assertEquals(game.player1, game.currentPlayer);
    }

    @org.junit.jupiter.api.Test
    public void testSwitchCurrentPlayer() {
        TicTacToe game = new TicTacToe();
        game.switchCurrentPlayer();
        assertEquals(game.player2, game.currentPlayer);
    }

    @org.junit.jupiter.api.Test
    public void testHasWinner_Positive() {
        TicTacToe game = new TicTacToe();
        game.board.cells[0][0] = 'X';
        game.board.cells[0][1] = 'X';
        game.board.cells[0][2] = 'X';
        assertTrue(game.hasWinner());
    }

    @org.junit.jupiter.api.Test
    public void testHasWinner_Positive_Column() {
        TicTacToe game = new TicTacToe();
        game.board.cells[0][0] = 'X';
        game.board.cells[1][0] = 'X';
        game.board.cells[2][0] = 'X';
        assertTrue(game.hasWinner());
    }

    @org.junit.jupiter.api.Test
    public void testHasWinner_Positive_Diagonal() {
        TicTacToe game = new TicTacToe();
        game.board.cells[0][0] = 'X';
        game.board.cells[1][1] = 'X';
        game.board.cells[2][2] = 'X';
        assertTrue(game.hasWinner());
    }

    @org.junit.jupiter.api.Test
    public void testHasWinner_Negative_NoMoves() {
        TicTacToe game = new TicTacToe();
        assertFalse(game.hasWinner());
    }

    @org.junit.jupiter.api.Test
    public void testHasWinner_Positive_AllMovesNoWinner() {
        TicTacToe game = new TicTacToe();
        game.board.cells[0][0] = 'X';
        game.board.cells[0][1] = 'O';
        game.board.cells[0][2] = 'X';
        game.board.cells[1][0] = 'O';
        game.board.cells[1][1] = 'X';
        game.board.cells[1][2] = 'O';
        game.board.cells[2][0] = 'X';
        game.board.cells[2][1] = 'O';
        game.board.cells[2][2] = 'X';
        // Even though the last two cells / moves are redundant, there is a diagonal win for 'X' here.
        assertTrue(game.hasWinner());
    }

    @org.junit.jupiter.api.Test
    public void testHasWinner_Negative_SomeMovesNoWinner() {
        TicTacToe game = new TicTacToe();
        game.board.cells[0][0] = 'X';
        game.board.cells[0][1] = 'O';
        game.board.cells[0][2] = 'X';
        game.board.cells[1][0] = 'O';
        game.board.cells[1][1] = 'X';
        assertFalse(game.hasWinner());
    }

    @org.junit.jupiter.api.Test
    public void testHasWinner_Negative_AllMovesNoWinner() {
        TicTacToe game = new TicTacToe();
        // Randomly picked moves
        game.board.cells[0][1] = 'X';
        game.board.cells[1][1] = 'O';
        game.board.cells[2][0] = 'X';
        game.board.cells[0][0] = 'O';
        game.board.cells[2][2] = 'X';
        game.board.cells[2][1] = 'O';
        game.board.cells[0][2] = 'X';
        game.board.cells[1][2] = 'O';
        game.board.cells[1][0] = 'X';
        assertFalse(game.hasWinner());
    }

    /* Class Board Unit Tests */

    @org.junit.jupiter.api.Test
    public void testIsCellEmpty_empty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0,  0));
    }

    @org.junit.jupiter.api.Test
    public void testIsCellEmpty_occupied() {
        Board board = new Board();
        board.place(0,  0, 'X');
        assertFalse(board.isCellEmpty(0,  0));
    }

    @org.junit.jupiter.api.Test
    public void testPlace_Positive() {
        Board board = new Board();
        board.place(0,  0, 'X');
        assertEquals('X', board.cells[0][0]);
    }

    @org.junit.jupiter.api.Test
    public void testPlace_Negative() {
        Board board = new Board();
        board.place(0,  0, 'X');
        board.place(0,  0, 'O');
        assertEquals('X', board.cells[0][0]);
    }

    @org.junit.jupiter.api.Test
    public void testIsFull_Positive() {
        Board board = new Board();
        for (int i =  0; i <  3; i++) {
            for (int j =  0; j <  3; j++) {
                board.cells[i][j] = 'X';
            }
        }
        assertTrue(board.isFull());
    }

    @org.junit.jupiter.api.Test
    public void testIsFull_Negative() {
        Board board = new Board();
        board.cells[0][0] = 'X';
        assertFalse(board.isFull());
    }

    @org.junit.jupiter.api.Test
    public void testClear() {
        Board board = new Board();
        board.cells[0][0] = 'X';
        board.clear();
        for (int i =  0; i <  3; i++) {
            for (int j =  0; j <  3; j++) {
                assertEquals(' ', board.cells[i][j]);
            }
        }
    }

    @org.junit.jupiter.api.Test
    public void testPrint() {
        Board board = new Board();
        board.place(0,  0, 'X');
        board.place(1,  1, 'O');
        board.place(0,  2, 'X');

        // Call the print method
        // NOTE: Once all Tests are "tested", the output of method is seen in the terminal
        board.print();

        // Randomly selected markers
        assertEquals('X', board.cells[0][0]);
        assertEquals('O', board.cells[1][1]);
        assertEquals('X', board.cells[0][2]);
    }
}
