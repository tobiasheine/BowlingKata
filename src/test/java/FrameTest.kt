import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class FrameTest {

    @Test
    fun `sum up rolls for regular frame`() {
        val frame = Frame(rolls = listOf(2, 4))

        assertThat(frame.score()).isEqualTo(6)
    }

    @Test
    fun `a spare gets as bonus the next frames roll`() {
        val frame = SpareFrame(rolls = listOf(2, 8))
        val nextFrame = Frame(rolls = listOf(1, 1))

        val score = frame.score(nextFrame.rolls)

        assertThat(score).isEqualTo(11)
    }

    @Test
    fun `strike get us bonus next two rolls`() {
        val frame = StrikeFrame()
        val nextFrame = Frame(rolls = listOf(1, 1))

        val score = frame.score(nextFrame.rolls)

        assertThat(score).isEqualTo(12)
    }


}