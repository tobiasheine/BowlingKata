package eu.tobiasheine.bowling

import kotlin.math.min

abstract class BonusFrame(
    override val pins: List<Int>,
    private val bonusPinScore: Int
) : Frame {
    override fun score(nextPins: List<Int>): Int =
        pins.plus(nextPins)
            .let { allPins -> allPins.subList(0, min(allPins.size, pins.size + bonusPinScore)) }
            .sum()
}