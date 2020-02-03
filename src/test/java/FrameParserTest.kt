import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class FrameParserTest {
    @Test
    fun `parse frame`() {
        val frame = FrameParser().asFrame("52")

        assertThat(frame).isInstanceOf(Frame::class.java)
    }

    @Test
    fun `parse strike`() {
        val frame = FrameParser().asFrame("X")

        assertThat(frame).isInstanceOf(StrikeFrame::class.java)
    }

    @Test
    fun `parse spare`() {
        val frame = FrameParser().asFrame("3/")

        assertThat(frame).isInstanceOf(SpareFrame::class.java)
    }
}