class FrameParser {

    fun parse(input: String): List<BowlingFrame> {
        return input
            .split(Regex(" "))
            .map { frameAsString ->
                asFrame(frameAsString)
            }
    }

    fun asFrame(string: String): BowlingFrame {
        return when (true) {
            string == "X" -> StrikeFrame()
            Regex("[0-9]{2}").matches(string) -> Frame(string.map { it.toString().toInt() })
            Regex("[0-9\\/]{2,3}").matches(string) -> SpareFrame( parseSpare(string))

            else -> TODO()
        }
    }

    private fun parseSpare(string: String): List<Int> {
        // 1/5
        // 3/

        val first = string.get(0).toString().toInt();
        return listOf(first, 10-first)


    }
}