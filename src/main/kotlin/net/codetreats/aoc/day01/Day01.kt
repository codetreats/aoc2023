package net.codetreats.aoc.day01

import net.codetreats.aoc.Day
import net.codetreats.aoc.util.Logger

class Day01 : Day<List<Line>>(1) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = true

    override fun convert(input: List<String>): List<Line> = input.map { Line(it) }

    override fun run1(data: List<Line>): String = data.sumOf { line -> line.sum(false) }.toString()

    override fun run2(data: List<Line>): String {
        logger.info(data)
        return data.sumOf { line -> line.sum(true) }.toString()
    }
}