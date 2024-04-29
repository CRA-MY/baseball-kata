import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    Game game;
    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void 입력값에문제가있으면예외반환() {
        assertIllegalArgument(null);
        assertIllegalArgument("");
        assertIllegalArgument("1");
        assertIllegalArgument("12");
        assertIllegalArgument("12");
        assertIllegalArgument("12e");
        assertIllegalArgument("122");
        assertIllegalArgument("111");
    }

    @Test
    void 정답성공() {
        game.question = "123";
        assertMacheNumber(game.guess("123"), true, 3, 0);

    }

    @Test
    void 모든숫자가다른경우() {
        game.question = "123";
        assertMacheNumber(game.guess("456"), false, 0, 0);
    }

    @Test
    void 스트라이크만있을경우() {
        game.question = "123";
        assertMacheNumber(game.guess("124"), false, 2, 0);
    }

    @Test
    void 볼만있을경우() {
        game.question = "123";
        assertMacheNumber(game.guess("231"), false, 0, 3);
    }

    @Test
    void 스트라이크와볼이있는경우() {
        game.question = "123";
        assertMacheNumber(game.guess("139"), false, 1, 1);
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail("");
        }
        catch (IllegalArgumentException e) {
        }
    }

    private void assertMacheNumber(GueseResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }
}