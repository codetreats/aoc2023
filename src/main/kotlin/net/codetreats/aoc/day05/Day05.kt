package net.codetreats.aoc.day05

import net.codetreats.aoc.Day
import net.codetreats.aoc.util.Logger

class Day05 : Day<List<String>>(5) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = true

    override fun convert(input: List<String>): List<String> = input

    override fun run1(data: List<String>): String {
        return ""
    }

    override fun run2(data: List<String>): String {
        return ""
    }
}