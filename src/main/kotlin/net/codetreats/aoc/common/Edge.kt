package net.codetreats.aoc.common

data class Edge(val start : Node, val end : Node) {
    override fun toString(): String = "$start -> $end"
}