package net.codetreats.aoc.day02

import kotlin.math.max

data class Game(val id: Int, val takes: List<Take>) {
    fun isPossible(input: Map<String, Int>) =
        takes.map { it.dices }.flatten().none { input[it.color]!! < it.amount }

    fun power(): Int {
        val min = mutableMapOf("green" to 0, "red" to 0, "blue" to 0)
        takes.map { it.dices }.flatten().forEach { dices ->
            min[dices.color] = max(dices.amount, min[dices.color]!!)
        }
        return min.map { it.value }.reduce { min1, min2 -> min1 * min2 }
    }

    companion object {
        fun from(line: String): Game {
            val id = line.split(":")[0].split(" ")[1].toInt()
            val takes: List<Take> = line.split(":")[1].trim().split(";").map { Take.from(it.trim()) }
            return Game(id, takes)
        }
    }

}

data class Take(val dices: List<Dices>) {
    companion object {
        fun from(part: String): Take = Take(part.trim().split(",").map { Dices.from(it.trim()) })
    }
}

data class Dices(val color: String, val amount: Int) {
    companion object {
        fun from(part: String): Dices {
            val amount = part.split(" ")[0].trim().toInt()
            val color = part.split(" ")[1].trim()
            return Dices(color, amount)
        }
    }
}