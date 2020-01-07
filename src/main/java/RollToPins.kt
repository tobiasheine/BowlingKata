fun String.asPins(): List<Int> {
    return mapIndexed { index, it ->
        when {
            it.toString() == "-" -> 0
            it.toString() == "X" -> 10
            it.toString() == "/" -> 10 - this[index -1].toString().toInt()
            else -> it.toString().toInt()
        }
    }
}