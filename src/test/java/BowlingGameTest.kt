import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BowlingGameTest {

    private val bowlingGame = BowlingGame()

    @Test
    fun `all strikes`() {
        val score = bowlingGame.score("X X X X X X X X X X X X")
        assertThat(score).isEqualTo(300)
    }

    @Test
    fun `every second pin a miss`() {
        val score = bowlingGame.score("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-")
        assertThat(score).isEqualTo(90)
    }

    @Test
    fun `all spares`() {
        val score = bowlingGame.score("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5")
        assertThat(score).isEqualTo(150)
    }
}