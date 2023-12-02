package net.codetreats.aoc.day02

import net.codetreats.aoc.Day
import net.codetreats.aoc.util.Logger

class Day02 : Day<List<Game>>(2) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = false

    override fun convert(input: List<String>): List<Game> = input.map { Game.from(it) }

    override fun run1(data: List<Game>) =
        data.filter { it.isPossible(mapOf("red" to 12, "green" to 13, "blue" to 14)) }.sumOf { it.id }.toString()

    override fun run2(data: List<Game>) =
        data.sumOf { it.power() }.toString()
}