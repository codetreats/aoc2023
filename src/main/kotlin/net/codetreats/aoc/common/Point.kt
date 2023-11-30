package net.codetreats.aoc.common

interface Point {
    val x: Int
    val y: Int

    companion object {
        fun from(x: Int, y: Int): Point = SinglePoint(x,y)
    }
}

data class SinglePoint(override val x: Int, override val y: Int) : Point, Comparable<Point> {
    override fun toString(): String = "($x,$y)"

    override fun compareTo(other: Point): Int {
        if (x == other.x) {
            return y.compareTo(other.y)
        }
        return x.compareTo(other.x)
    }
}

data class DataPoint<T>(override val x: Int, override val y: Int, val value: T) : Point

typealias IntPoint = DataPoint<Int>