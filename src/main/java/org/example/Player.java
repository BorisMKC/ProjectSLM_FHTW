package org.example;

/**
 * Represents a player in a Tic Tac Toe game.
 * Each player has a unique marker (X or O) that they use to claim cells on the board.
 */
public class Player {
    
    /**
     * The marker that represents the player on the Tic Tac Toe board.
     */
    public char marker;
    /**
     * Creates a new player with the given marker.
     *
     * @param marker the character representing the player on the board.
     */
    public Player(char marker) {
        this.marker = marker;
    }

    /**
     * Retrieves the marker associated with this player.
     *
     * @return the character marker used by this player.
     */
    public char getMarker() {
        return this.marker;
    }

}

