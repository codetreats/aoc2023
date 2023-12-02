package net.codetreats.aoc.day02

import kotlin.math.max

data class Game(val id: Int, val extractions: List<Extraction>) {
    fun isPossible(input: Map<String, Int>) =
        extractions.map { it.dices }.flatten().none { input[it.color]!! < it.amount }

    fun power(): Int {
        val min = mutableMapOf("green" to 0, "red" to 0, "blue" to 0)
        extractions.map { it.dices }.flatten().forEach { dices ->
            min[dices.color] = max(dices.amount, min[dices.color]!!)
        }
        return min.map { it.value }.reduce { min1, min2 -> min1 * min2 }
    }

    companion object {
        fun from(line: String): Game {
            val id = line.split(":")[0].split(" ")[1].toInt()
            val extractions: List<Extraction> = line.split(":")[1].trim().split(";").map { Extraction.from(it.trim()) }
            return Game(id, extractions)
        }
    }

}

data class Extraction(val dices: List<ColorDices>) {
    companion object {
        fun from(part: String): Extraction =
            Extraction(part.trim().split(",").map { ColorDices.from(it.trim()) })
    }
}

data class ColorDices(val color: String, val amount: Int) {
    companion object {
        fun from(part: String): ColorDices {
            val amount = part.split(" ")[0].trim().toInt()
            val color = part.split(" ")[1].trim()
            return ColorDices(color, amount)
        }
    }
}