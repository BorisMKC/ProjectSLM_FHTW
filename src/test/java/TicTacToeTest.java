package org.example; // Make sure this package declaration matches your project's package structure

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testHasWinner() {
        // Set up a winning state on the game board
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');

        // Print the current state of the game board
        System.out.println("Current board state:");
        game.board.print();

        // Test conditions
        boolean result = game.hasWinner();
        System.out.println("Result: " + result);

        // Assert that there is a winner
        assertTrue(result);
    }
}
