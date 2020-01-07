import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LastFrameTest {

    @Test
    fun `last frame below 10 points`() {
        val lastFrame = LastFrame("34")

        assertThat(lastFrame.pins).isEqualTo(listOf(3, 4))
    }

    @Test
    fun `last frame with spare`() {
        val lastFrame = LastFrame("3/6")

        assertThat(lastFrame.pins).isEqualTo(listOf(3, 7, 6))
    }

    @Test
    fun `last frame with spare and strike`() {
        val lastFrame = LastFrame("3/X")

        assertThat(lastFrame.pins).isEqualTo(listOf(3, 7, 10))
    }

    @Test
    fun `last frame with strikes`() {
        val lastFrame = LastFrame("XXX")

        assertThat(lastFrame.pins).isEqualTo(listOf(10, 10, 10))
    }
}