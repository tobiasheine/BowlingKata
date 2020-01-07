import kotlin.math.min

class BowlingGame {

    fun score(input: String): Int {
        val frames = input
            .split(Regex(" "))
            .mapIndexed { index, rolls ->
                when {
                    // because the format of the last roll differs between strikes and others
                    // e.g. X X X vs. 5/5
                    rolls.length == 3 || index > 9 -> LastFrame(rolls)
                    rolls.contains("/") -> SpareFrame(rolls)
                    rolls == "X" -> StrikeFrame
                    else -> RegularFrame(rolls)
                }
            }

        return frames
            .mapIndexed { index, frame ->
                frame.score(frames.drop(min(frames.size - 1, index + 1)))
            }
            .sum()
    }
}


