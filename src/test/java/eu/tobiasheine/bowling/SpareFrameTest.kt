package eu.tobiasheine.bowling

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SpareFrameTest {

    @Test
    fun `return pins`() {
        val spareFrame = SpareFrame("3/".asPins())

        assertThat(spareFrame.pins).isEqualTo(listOf(3, 7))
    }

    @Test
    fun `spare frame followed with regular frame`() {
        val spareFrame = SpareFrame("5/".asPins())
        val nextFrames = listOf(NoBonusFrame("21".asPins()))
        val score = spareFrame.score(nextPins = nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(12)
    }

    @Test
    fun `spare frame followed with spare`() {
        val spareFrame = SpareFrame("5/".asPins())
        val nextFrames = listOf(SpareFrame("2/".asPins()))
        val score = spareFrame.score(nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(12)
    }

    @Test
    fun `spare frame followed with strike`() {
        val spareFrame = SpareFrame("5/".asPins())
        val nextFrames = listOf(StrikeFrame)
        val score = spareFrame.score(nextPins = nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(20)
    }
}