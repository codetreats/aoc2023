package net.codetreats.aoc.common

import javax.xml.crypto.Data

open class Board<T>(val width: Int, val height: Int, private val initialValue: T)  {
    protected val content = mutableListOf<T>()

    init {
        for (x in 0 until width) {
            for (y in 0 until height) {
                content.add(initialValue)
            }
        }
    }

    fun set(x: Int, y: Int, value: T) {
        if (x in 0 until width && y in 0 until height) {
            content[y * width + x] = value
        }
    }

    fun get(x: Int, y: Int): DataPoint<T> = getOrNull(x, y)!!

    fun all() : List<DataPoint<T>> {
        val all = mutableListOf<DataPoint<T>>()
        for (x in 0 until width) {
            for (y in 0 until height) {
                all.add(get(x, y))
            }
        }
        return all
    }

    fun getOrNull(x: Int, y: Int) : DataPoint<T>? {
        if (x in 0 until width && y in 0 until height) {
            return DataPoint<T>(x, y, content[position(x,y)])
        }
        return null
    }

    fun position(x: Int, y: Int) = y * width + x

    fun neighbors(x: Int, y: Int, withDiag: Boolean = false, withSelf: Boolean = false) : List<DataPoint<T>> {
        val neighbors = mutableListOf<DataPoint<T>?>()
        neighbors.add(getOrNull(x - 1, y))
        neighbors.add(getOrNull(x + 1, y))
        neighbors.add(getOrNull(x, y - 1))
        neighbors.add(getOrNull(x, y + 1))
        if (withDiag) {
            neighbors.add(getOrNull(x - 1, y - 1))
            neighbors.add(getOrNull(x + 1, y + 1))
            neighbors.add(getOrNull(x - 1, y + 1))
            neighbors.add(getOrNull(x + 1, y - 1))
        }
        if (withSelf) {
            neighbors.add(getOrNull(x, y))
        }
        return neighbors.filterNotNull().map { it!! }
    }

    override fun toString(): String {
        var s = StringBuilder()
        var length = 0
        content.forEach {
            if (length % width == 0) {
                s.appendln()
            }
            length++
            s.append(valueToString(it))
        }
        return s.toString()
    }

    open fun valueToString(value: T) : String = value.toString()

    companion object {
        fun from(lines: List<String>) : Board<Char> {
            val width = lines[0].length
            val height = lines.size
            val board = Board(width, height, '.')
            for (y in 0 until width) {
                val line = lines[y]
                for (x in 0 until width) {
                    board.set(x, y, line[x])
                }
            }
            return board
        }
    }
}
