package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.start();

        while (true) {
            System.out.println("Current board:");
            game.board.print();

            int row, col;
            do {
                System.out.println("Current Player: " + game.currentPlayer.getMarker());
                System.out.print("Enter row and column (0, 1, 2): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while (!game.board.isCellEmpty(row, col));

            game.board.place(row, col, game.currentPlayer.getMarker());

            if (game.hasWinner()) {
                System.out.println("Player " + game.currentPlayer.getMarker() + " wins!");
                game.board.print();
                break;
            } else if (game.board.isFull()) {
                System.out.println("The game is a draw.");
                game.board.print();
                break;
            }

            game.switchCurrentPlayer();
        }

        scanner.close();
    }
}