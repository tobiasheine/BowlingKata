class NoBonusFrame(private val roll: String) : Frame {
    override val pins: List<Int>
        get() = roll.asPins()

    override fun score(nextPins: List<Int>): Int =
        pins
            .sum()
}