package eu.tobiasheine.bowling

const val STRIKE_ROLL_CHAR = "X"
const val SPARE_ROLL_CHAR = "/"
const val EMPTY_ROLL_CHAR = "-"
private const val FRAME_SEPARATOR = " "
val parseFrames: (String) -> List<Frame> = { frames ->
    frames
        .split(Regex(FRAME_SEPARATOR))
        .mapIndexed { index, rolls ->
            val pins = rolls.asPins()
            when {
                // because the format of the last roll differs between strikes and others
                // e.g. X X X vs. 5/5
                rolls.length == 3 || index > 8 -> NoBonusFrame(pins)
                rolls.contains(SPARE_ROLL_CHAR) -> SpareFrame(pins)
                rolls == STRIKE_ROLL_CHAR -> StrikeFrame
                else -> NoBonusFrame(pins)
            }
        }
}