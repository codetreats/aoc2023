package net.codetreats.aoc.common

interface Point3 : Point {
    val z: Int

    companion object {
        fun from(x: Int, y: Int, z: Int): Point3 = SinglePoint3(x,y, z)
    }
}

data class SinglePoint3(override val x: Int, override val y: Int, override val z: Int) : Point3, Comparable<Point3> {
    override fun toString(): String = "($x,$y,$z)"

    override fun compareTo(other: Point3): Int {
        if (x == other.x && y == other.y) {
            return z.compareTo(other.z)
        }
        if (x == other.x ) {
            return y.compareTo(other.y)
        }
        return x.compareTo(other.x)
    }
}