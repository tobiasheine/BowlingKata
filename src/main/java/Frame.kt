interface Frame {
    val pins: List<Int>
    fun score(nextPins: List<Int>): Int
}