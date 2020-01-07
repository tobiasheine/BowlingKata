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
        val score = spareFrame.score(listOf(RegularFrame("21")))

        assertThat(score).isEqualTo(12)
    }

    @Test
    fun `spare frame followed with spare`() {
        val spareFrame = SpareFrame("5/")
        val score = spareFrame.score(listOf(SpareFrame("2/")))

        assertThat(score).isEqualTo(12)
    }

    @Test
    fun `spare frame followed with strike`() {
        val spareFrame = SpareFrame("5/")
        val score = spareFrame.score(listOf(StrikeFrame))

        assertThat(score).isEqualTo(20)
    }
}