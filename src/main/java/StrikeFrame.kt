import kotlin.math.min

private const val STRIKE_NEXT_PINS_SCORE_BONUS = 2

object StrikeFrame : Frame {
    override val pins: List<Int> = listOf(10)

    override fun score(nextPins: List<Int>): Int {
        return pins.sum() + nextPins
            .subList(0, min(nextPins.size, STRIKE_NEXT_PINS_SCORE_BONUS))
            .sum()
    }
}