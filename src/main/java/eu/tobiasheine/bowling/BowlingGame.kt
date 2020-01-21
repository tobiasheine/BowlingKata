package eu.tobiasheine.bowling

class BowlingGame {

    fun score(input: String): Int =
        parseFrames(input).let { frames ->
            frames
                .mapIndexed { index, frame ->
                    val nextFrames = frames.drop(index + 1)
                    val nextPins = nextFrames.flatMap { it.pins }
                    frame.score(nextPins)
                }
                .sum()
        }
}


