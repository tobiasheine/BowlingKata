package eu.tobiasheine.bowling

import kotlin.math.min

open class BonusFrame(
    private val roll: String,
    private val bonusPinScore: Int
) : Frame {
    override val pins: List<Int>
        get() = roll.asPins()

    override fun score(nextPins: List<Int>): Int =
        pins.plus(nextPins)
            .let { allPins -> allPins.subList(0, min(allPins.size, pins.size + bonusPinScore)) }
            .sum()
}