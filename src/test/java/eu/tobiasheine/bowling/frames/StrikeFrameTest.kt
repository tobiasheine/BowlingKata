package eu.tobiasheine.bowling.frames

import eu.tobiasheine.bowling.asPins
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class StrikeFrameTest {

    @Test
    fun `get pins`() {
        assertThat(StrikeFrame.pins).isEqualTo(listOf(10))
    }

    @Test
    fun `strike followed with regular frames`() {
        val nextFrames = listOf(NoBonusFrame("12".asPins()))
        val score = StrikeFrame.score(nextPins = nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(13)
    }

    @Test
    fun `strike followed with spare frame`() {
        val nextFrames = listOf(StrikeFrame, SpareFrame("1/".asPins()))
        val score = StrikeFrame.score(nextPins = nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(21)
    }

    @Test
    fun `strike followed with strike`() {
        val nextFrames = listOf(StrikeFrame)
        val score = StrikeFrame.score(nextPins = nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(20)
    }

    @Test
    fun `strike followed with top strikes`() {
        val nextFrames = listOf(
            StrikeFrame,
            StrikeFrame
        )
        val score = StrikeFrame.score(nextPins = nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(30)
    }

    @Test
    fun `strike followed with three strikes`() {
        val nextFrames = listOf(
            StrikeFrame,
            StrikeFrame,
            StrikeFrame
        )
        val score = StrikeFrame.score(nextPins = nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(30)
    }

    @Test
    fun `strike followed with nothing`() {
        val score = StrikeFrame.score(nextPins = emptyList())

        assertThat(score).isEqualTo(10)
    }
}