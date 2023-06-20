import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(7, "Ivan", 25);
    Player player2 = new Player(17, "Petr", 18);
    Player player3 = new Player(27, "Andrey", 39);
    Player player4 = new Player(37, "Vasiliy", 39);
    Player player5 = new Player(47, "Sergey", 58);

    @Test
    public void shouldWinPlayer1() {
        Game game = new Game();

        game.register("Ivan", player1);
        game.register("Petr", player2);

        int expected = 1;
        int actual = game.round("Ivan", "Petr");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        Game game = new Game();

        game.register("Andrey", player3);
        game.register("Sergey", player5);

        int expected = 2;
        int actual = game.round("Andrey", "Sergey");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGameDraw() {
        Game game = new Game();

        game.register("Andrey", player3);
        game.register("Vasiliy", player4);

        int expected = 0;
        int actual = game.round("Andrey", "Vasiliy");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPlayer1Registered() {
        Game game = new Game();

        game.register("Petr", player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Oleg", "Petr");
        });
    }

    @Test
    public void shouldNotPlayer2Registered() {
        Game game = new Game();

        game.register("Andrey", player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Andrey", "Anton");
        });
    }
}
