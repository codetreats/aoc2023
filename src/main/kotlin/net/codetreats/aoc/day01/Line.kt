package net.codetreats.aoc.day01

class Line(private val line: String) {
    fun sum(withText: Boolean): Int {
        var tmp = line
        var first: Char? = null
        var last: Char? = null

        while (tmp.isNotBlank()) {
            val nr = tmp.number(withText)
            if (nr != null) {
                last = nr
                if (first == null) {
                    first = last
                }
            }
            tmp = tmp.pop()
        }
        return "$first$last".toInt()
    }

    private fun String.number(withText: Boolean): Char? {
        if (isEmpty()) {
            return null
        }
        if (this[0].isDigit()) {
            return this[0]
        }
        if (withText.not()) {
            return null
        }
        return when {
            startsWith("one") -> '1'
            startsWith("two") -> '2'
            startsWith("three") -> '3'
            startsWith("four") -> '4'
            startsWith("five") -> '5'
            startsWith("six") -> '6'
            startsWith("seven") -> '7'
            startsWith("eight") -> '8'
            startsWith("nine") -> '9'
            else -> null
        }
    }

    private fun String.pop() = substring(1)
}