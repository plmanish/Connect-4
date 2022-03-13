package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Board board;
    private List<Player> players;
    private int availableMoves = 42;

    public Game() {
        this.board = new Board();
        this.players = new ArrayList<Player>();
    }

    public void addPlayer(int id, String name) {
        players.add(new Player(id, name));
    }

    public void printBoard() {
        board.printBoard();
    }

    public void play() {
        int chance = 0;

        Scanner scan = new Scanner(System.in);
        while (availableMoves > 0) {
            board.printBoard();
            final Player player = players.get(chance);
            int id = player.getPlayerId();
            System.out.println("Enter your column number: ");
            int col = scan.nextInt();
            col--;

            int insertedRow = board.move(col, id);
            if (insertedRow != -1 && board.checkWinner(insertedRow, col, id) == 1) {
                System.out.println("Winner is player: " + player.getName());
                return;
            }
            availableMoves--;
            chance = 1-chance;
        }

        System.out.println("Draw!!");
    }
}
