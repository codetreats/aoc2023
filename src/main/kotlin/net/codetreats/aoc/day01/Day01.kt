package net.codetreats.aoc.day01

import net.codetreats.aoc.Day
import net.codetreats.aoc.util.Logger

class Day01 : Day<List<String>>(1) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = true

    override fun convert(input: List<String>): List<String> = input

    override fun run1(): String {
        return ""
    }

    override fun run2(): String {
        return ""
    }
}