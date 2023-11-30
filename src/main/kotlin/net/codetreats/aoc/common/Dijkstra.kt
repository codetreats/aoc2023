package net.codetreats.aoc.common

class Dijkstra {
    /**
     * Calculate the minimum distance between startNode and endNode.
     * The algorithm expects, that there are exactly [nodeCount] nodes with names from 0 to [nodeCount - 1]
     * @param: nodeCount the total number of nodes
     * @param: startNOde the name of the start node
     * @param: endNode the name of the end node
     * @param: edges defines all edges. An edge starts at the key of the map and ends in 0 .. n other nodes.
     *         A target node is of type [EdgeDistance],
     *         which contains the name of the target node and the distance between the key and the target
     */
    fun shortestPath(nodeCount: Int, startNode: Int, endNode: Int, edges: Map<Int, Set<EdgeDistance>>) : DijkstraResult {
        val distances  = IntArray(nodeCount) { Integer.MAX_VALUE}
        val preds = IntArray(nodeCount) { -1 }
        distances[startNode] = 0
        val queue : MutableList<Int> = mutableListOf(0)
        val added = mutableSetOf<Int>(0)
        while(queue.isNotEmpty()) {
            val u : Int = queue.minBy { distances[it] }!!
            queue.remove(u)
            if (u == endNode) {
                return DijkstraResult(preds, distances[u])
            }
            edges[u]!!.forEach { v ->
                if (v.node !in queue && v.node !in added) {
                    queue.add(v.node)
                    added.add(v.node)
                }
                if (v.node in queue) {
                    val newDistance = distances[u] + v.weight
                    if (newDistance < distances[v.node]) {
                        distances[v.node] = newDistance
                        preds[v.node] = u
                    }
                }
            }
        }
        throw IllegalStateException("Algorithm finished without result")
    }
}

data class EdgeDistance(val node: Int, val weight: Int)

data class DijkstraResult(val preds: IntArray, val length: Int) {
    fun shortestPath(from: Int, to: Int) : List<Int> {
        val path = mutableListOf(to)
        while (path.last() != from) {
            path.add(preds[path.last()])
        }
        return path.reversed()
    }
}