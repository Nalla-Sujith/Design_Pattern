package Tic_Tac_Toe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    public Board board;
    public Deque<Player> players;

    Game() {
        initialize();
    }

    void initialize() {
        board = new Board(3);
        players = new LinkedList<>();
        PlayingPieceX piecex = new PlayingPieceX();
        Player player1 = new Player("Sujith", piecex);
        PlayingPieceO pieceo = new PlayingPieceO();
        Player player2 = new Player("Sindhu", pieceo);
        players.add(player1);
        players.add(player2);
    }

    String startGame() {
        boolean isWinnerFound = false;
        while (!isWinnerFound) {
            Player currentPlayer = players.removeFirst();
            board.printBoard();
            if (board.isBoardFilled()) {
                return "Tie";
            }
            Scanner s = new Scanner(System.in);
            System.out.println("Player " + currentPlayer.getName() + " Enter the x,y of your position");
            String a[] = s.nextLine().split(",");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            if (!board.addPiece(x, y, currentPlayer.getPiece())) {
                System.out.println("Incorrect Position choosen Please try again...");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);
            if (board.isGameCompleted(x, y, currentPlayer.getPiece())) {
                return currentPlayer.getName();
            }
        }
        return "Tie";
    }

}
