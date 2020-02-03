class StrikeFrame() : BowlingFrame {

    override val rolls: List<Int> = listOf(10)

    override fun score(nextRolls: List<Int>): Int {

        return this.rolls.sum() + nextRolls[0] + nextRolls[1]
    }

}