/**
 * Represents a Tic Tac Toe game board with a grid of cells.
 * Provides methods to interact with the board, such as checking if a cell is empty,
 * placing a marker, clearing the board, and printing the board.
 */
public class Board {

    /**
     * The  2D array representing the game board.
     * Each cell is indexed by row and column, and holds a character representing
     * the player's marker or an empty space.
     */
    public char[][] cells;

    /**
     * Constructs a new Tic Tac Toe board with a grid of empty spaces.
     */
    public Board() {
        cells = new char[3][3];
        clear();
    }

    /**
     * Checks if a cell at the specified row and column is empty.
     *
     * @param x the row index of the cell
     * @param y the column index of the cell
     * @return true if the cell is empty, false otherwise
     */
    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    /**
     * Places a marker on the board at the specified row and column.
     *
     * @param x the row index of the cell
     * @param y the column index of the cell
     * @param marker the marker to place on the cell
     */
    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    /**
     * Checks if the entire board is filled with markers, indicating that the game is over.
     *
     * @return true if the board is full, false otherwise
     */
    public boolean isFull() {
        for (int i =  0; i <  3; i++) {
            for (int j =  0; j <  3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Clears the board, resetting all cells to empty spaces.
     */
    public void clear() {
        for(int i =  0; i <  3; i++) {
            for(int j =  0; j <  3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    /**
     * Prints the current state of the board to the console.
     */
    public void print() {
        for (int i =  0; i < cells.length; i++) {
            for (int j =  0; j < cells[i].length; j++) {
                System.out.print(cells[i][j]);
                if (j < cells[i].length -  1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < cells.length -  1) {
                System.out.println("-----");
            }
        }
    }
}
