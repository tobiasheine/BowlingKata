class LastFrame(private val roll: String) : Frame {

    override val pins: List<Int>
        get() = roll.asPins()

    override fun score(nextFrames: List<Frame>): Int =
        pins.sum()
}