import kotlin.math.min

private const val SPARE_NEXT_PINS_SCORE_BONUS = 1

class SpareFrame(private val roll: String) : Frame {
    override val pins: List<Int>
        get() = roll.asPins()

    override fun score(nextPins: List<Int>): Int =
        pins.sum() + nextPins
            .subList(0, min(nextPins.size, SPARE_NEXT_PINS_SCORE_BONUS))
            .sum()
}