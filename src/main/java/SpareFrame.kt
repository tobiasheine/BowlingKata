class SpareFrame(override val rolls: List<Int>) : BowlingFrame {

    override fun score(nextRolls: List<Int>): Int {

            return this.rolls.sum() + nextRolls[0]
    }

}