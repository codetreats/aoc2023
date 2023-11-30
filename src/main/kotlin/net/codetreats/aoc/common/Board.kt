package net.codetreats.aoc.common

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
}
