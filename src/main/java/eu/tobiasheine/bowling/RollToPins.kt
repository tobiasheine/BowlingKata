package eu.tobiasheine.bowling

fun String.asPins(): List<Int> {
    return mapIndexed { index, it ->
        when {
            it.toString() == EMPTY_ROLL_CHAR -> 0
            it.toString() == STRIKE_ROLL_CHAR -> 10
            it.toString() == SPARE_ROLL_CHAR -> 10 - this[index - 1].toString().toInt()
            else -> it.toString().toInt()
        }
    }
}