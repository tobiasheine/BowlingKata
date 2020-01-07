object StrikeFrame : Frame {
    override val pins: List<Int> = listOf(10)

    override fun score(nextFrames: List<Frame>): Int {
        val nextFrame = nextFrames.getOrNull(0)
        return when (nextFrame) {
            is RegularFrame, is SpareFrame -> pins.sum() + nextFrame.pins.sum()
            is StrikeFrame -> {
                val currentAndNextFrameSum = pins.sum() + nextFrame.pins.sum()
                val nextAfterNextFrame = nextFrames.getOrNull(1)
                nextAfterNextFrame?.let { currentAndNextFrameSum + it.pins.first() } ?: currentAndNextFrameSum
            }
            else -> 10
        }
    }
}