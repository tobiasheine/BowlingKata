interface BowlingFrame {

    val rolls: List<Int>

    fun score(nextRolls: List<Int> = listOf()): Int
}