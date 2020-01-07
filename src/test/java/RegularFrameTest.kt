import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RegularFrameTest {

    @Test
    fun `return pins`() {
        val regularFrame = RegularFrame("12")

        assertThat(regularFrame.pins).isEqualTo(listOf(1, 2))
    }

    @Test
    fun `regular frame sums pins`() {
        val regularFrame = RegularFrame("12")
        val score = regularFrame.score(listOf(regularFrame))

        assertThat(score).isEqualTo(3)
    }
}