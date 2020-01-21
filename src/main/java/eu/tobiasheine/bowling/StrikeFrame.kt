package eu.tobiasheine.bowling

private const val STRIKE_NEXT_PINS_SCORE_BONUS = 2
const val STRIKE_ROLL_CHAR = "X"
val StrikeFrame = object : BonusFrame(listOf(10), STRIKE_NEXT_PINS_SCORE_BONUS) {}
