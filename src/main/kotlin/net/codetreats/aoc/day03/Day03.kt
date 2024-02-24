package net.codetreats.aoc.day03

import net.codetreats.aoc.Day
import net.codetreats.aoc.common.Board
import net.codetreats.aoc.common.Point
import net.codetreats.aoc.util.Logger

class Day03 : Day<Board<Char>>(3) {
    override val logger: Logger = Logger.forDay(dayOfMonth)

    override val useDummy = true

    override fun convert(input: List<String>): Board<Char> = Board.from(input)

    override fun run1(board: Board<Char>): String =
        board.numbers()
            .filter { it.hasSymbolNeighbors(board) }
            .map { it.value }
            .sum()
            .toString()

    override fun run2(board: Board<Char>): String =
        board.all()
            .asSequence()
            .filter { it.value == '*' }
            .map { gear ->
                board
                    .numbers()
                    .filter { it.numberNeighbors().any { n -> n.x == gear.x && n.y == gear.y } }
                    .map { it.value }
            }
            .filter { it.size == 2 }
            .map { it.reduce { i1, i2 -> i1 * i2 } }
            .sum()
            .toString()

    private fun Map.Entry<Point, Int>.hasSymbolNeighbors(board: Board<Char>) =
        numberNeighbors()
            .mapNotNull { board.getOrNull(it.x, it.y) }
            .any { !it.value.isDigit() && it.value != '.' }

    private fun Board<Char>.numbers(): Map<Point, Int> {
        val numbers = mutableMapOf<Point, Int>()
        for (y in 0 until height) {
            var number = ""
            var startX = -1
            var startY = -1
            for (x in 0 until width) {
                val char = get(x, y).value
                if (char.isDigit()) {
                    if (number.isEmpty()) {
                        startX = x
                        startY = y
                    }
                    number += char
                } else {
                    if (number.isNotEmpty()) {
                        numbers[Point.from(startX, startY)] = number.toInt()
                        number = ""
                    }
                }
            }
            if (number.isNotEmpty()) {
                numbers[Point.from(startX, startY)] = number.toInt()
            }
        }
        return numbers
    }

    private fun Map.Entry<Point, Int>.numberNeighbors(): List<Point> {
        val neighbors = mutableListOf<Point>()
        val len = value.toString().length
        for (i in -1 .. 1) {
            neighbors.add(Point.from(key.x - 1, key.y + i))
            neighbors.add(Point.from(key.x + len, key.y + i))
        }
        for (numberLength in 0 until len) {
            neighbors.add(Point.from(key.x + numberLength, key.y - 1))
            neighbors.add(Point.from(key.x + numberLength, key.y + 1))
        }
        return neighbors
    }
}