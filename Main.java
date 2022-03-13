import models.Game;

public class Main {

    public static void main(String[] args) {
        final Game game = new Game();
        game.addPlayer(1, "Lionel");
        game.addPlayer(2, "Ronaldo");

        game.play();
    }
}
