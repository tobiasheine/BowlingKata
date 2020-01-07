import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class BowlingGameTest {

    private val bowlingGame = BowlingGame()

    @Test
    fun `all strikes`() {
        bowlingGame.rolls("X X X X X X X X X X X X")

        assertThat(bowlingGame.score()).isEqualTo(300)
    }

    @Test
    fun `every second pin a miss`() {
        bowlingGame.rolls("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-")

        assertThat(bowlingGame.score()).isEqualTo(90)
    }

    @Test
    fun `all spares`() {
        bowlingGame.rolls("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5")

        assertThat(bowlingGame.score()).isEqualTo(150)
    }
}