import kotlin.math.min

class BowlingGame {

    private var frames: List<Frame> = emptyList()

    fun rolls(input: String) {
        frames = input
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
    }

    fun score(): Int {
        return frames
            .mapIndexed { index, frame ->
                frame.score(frames.drop(min(frames.size - 1, index + 1)))
            }
            .sum()
    }

}


