import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SpareFrameTest {

    @Test
    fun `return pins`() {
        val spareFrame = SpareFrame("3/")

        assertThat(spareFrame.pins).isEqualTo(listOf(3, 7))
    }

    @Test
    fun `spare frame followed with regular frame`() {
        val spareFrame = SpareFrame("5/")
        val nextFrames = listOf(NoBonusFrame("21"))
        val score = spareFrame.score(nextPins = nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(12)
    }

    @Test
    fun `spare frame followed with spare`() {
        val spareFrame = SpareFrame("5/")
        val nextFrames = listOf(SpareFrame("2/"))
        val score = spareFrame.score(nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(12)
    }

    @Test
    fun `spare frame followed with strike`() {
        val spareFrame = SpareFrame("5/")
        val nextFrames = listOf(StrikeFrame)
        val score = spareFrame.score(nextPins = nextFrames.flatMap { it.pins })

        assertThat(score).isEqualTo(20)
    }
}