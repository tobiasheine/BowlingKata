package eu.tobiasheine.bowling

private const val SPARE_NEXT_PINS_SCORE_BONUS = 1

class SpareFrame(override val pins: List<Int>) : BonusFrame(pins, SPARE_NEXT_PINS_SCORE_BONUS)