class SpareFrame(private val roll: String) : Frame {
    override val pins: List<Int>
        get() = roll.asPins()

    override fun score(nextFrames: List<Frame>): Int =
        pins
            .map { it.toString().toInt() }
            .sum()
            .plus(nextFrames.getOrNull(0)?.pins?.first() ?: 0)
}