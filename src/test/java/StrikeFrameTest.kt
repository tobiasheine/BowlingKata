import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class StrikeFrameTest {

    @Test
    fun `get pins`() {
        assertThat(StrikeFrame.pins).isEqualTo(listOf(10))
    }

    @Test
    fun `strike followed with regular frames`() {
        val score = StrikeFrame.score(nextFrames = listOf(RegularFrame("12")))

        assertThat(score).isEqualTo(13)
    }

    @Test
    fun `strike followed with spare frame`() {
        val score = StrikeFrame.score(nextFrames = listOf(StrikeFrame, SpareFrame("1/")))

        assertThat(score).isEqualTo(21)
    }

    @Test
    fun `strike followed with strike`() {
        val score = StrikeFrame.score(nextFrames = listOf(StrikeFrame))

        assertThat(score).isEqualTo(20)
    }

    @Test
    fun `strike followed with strikes`() {
        val score = StrikeFrame.score(nextFrames = listOf(StrikeFrame, StrikeFrame))

        assertThat(score).isEqualTo(30)
    }

    @Test
    fun `strike followed with nothing`() {
        val score = StrikeFrame.score(nextFrames = emptyList())

        assertThat(score).isEqualTo(10)
    }
}