class BowlingGame {

    fun score(input: String): Int {
        val frames = input
            .split(Regex(" "))
            .mapIndexed { index, rolls ->
                when {
                    // because the format of the last roll differs between strikes and others
                    // e.g. X X X vs. 5/5
                    rolls.length == 3 || index > 8 -> NoBonusFrame(rolls)
                    rolls.contains("/") -> SpareFrame(rolls)
                    rolls == "X" -> StrikeFrame
                    else -> NoBonusFrame(rolls)
                }
            }

        return frames
            .mapIndexed { index, frame ->
                val nextFrames = frames.drop(index + 1)
                val nextPins = nextFrames.flatMap { it.pins }
                frame.score(nextPins)
            }
            .sum()
    }
}


