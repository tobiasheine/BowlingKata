package eu.tobiasheine.bowling

private const val STRIKE_NEXT_PINS_SCORE_BONUS = 2
private const val STRIKE_ROLL_CHAR = "X"
val StrikeFrame = object : BonusFrame(STRIKE_ROLL_CHAR, STRIKE_NEXT_PINS_SCORE_BONUS) {}
