package eu.tobiasheine.bowling

class NoBonusFrame(override val pins: List<Int>) : Frame {

    override fun score(nextPins: List<Int>): Int =
        pins.sum()
}