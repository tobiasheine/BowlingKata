package eu.tobiasheine.bowling.frames

class NoBonusFrame(override val pins: List<Int>) : Frame {

    override fun score(nextPins: List<Int>): Int =
        pins.sum()
}