import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class RollToPinsKtTest {

    @Test
    fun spare() {
        val pins = "1/".asPins()

        assertThat(pins).isEqualTo(listOf(1, 9))
    }

    @Test
    fun `spare with additional pin`() {
        val pins = "1/1".asPins()

        assertThat(pins).isEqualTo(listOf(1, 9, 1))
    }

    @Test
    fun strike() {
        val pins = "X".asPins()

        assertThat(pins).isEqualTo(listOf(10))
    }

    @Test
    fun `strike with regular roll`() {
        val pins = "X45".asPins()

        assertThat(pins).isEqualTo(listOf(10, 4, 5))
    }
}