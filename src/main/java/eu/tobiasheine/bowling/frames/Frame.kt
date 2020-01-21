package eu.tobiasheine.bowling.frames

interface Frame {
    val pins: List<Int>
    fun score(nextPins: List<Int>): Int
}