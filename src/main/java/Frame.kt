interface Frame {
    val pins: List<Int>
    fun score(nextFrames: List<Frame>): Int
}