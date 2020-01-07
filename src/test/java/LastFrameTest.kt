import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LastFrameTest {

    @Test
    fun `last frame below 10 points`() {
        val lastFrame = LastFrame("34")

        assertThat(lastFrame.pins).isEqualTo(listOf(34))
    }

    @Test
    fun `last frame with spare`() {
        val lastFrame = LastFrame("3/6")

        assertThat(lastFrame.pins).isEqualTo(listOf(16))
    }

    @Test
    fun `last frame with spare ans strike`() {
        val lastFrame = LastFrame("3/X")

        assertThat(lastFrame.pins).isEqualTo(listOf(20))
    }

    @Test
    fun `last frame with strikes`() {
        val lastFrame = LastFrame("XXX")

        assertThat(lastFrame.pins).isEqualTo(listOf(30))
    }
}