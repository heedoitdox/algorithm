package `DFS+BFS_필수문제`

import java.util.*

private var n = 0

private val graph = mutableListOf<MutableList<Int>>()
private val visited = BooleanArray(101) { false }
private val d = IntArray(101) { 0 }

fun main () {
    val sc = Scanner(System.`in`)

    n = sc.nextInt()

    for (i in 0..n) {
        graph.add(mutableListOf())
    }

    val p1 = sc.nextInt()-1
    val p2 = sc.nextInt()-1
    val k = sc.nextInt()

    for(i in 0 until k){
        val x = sc.nextInt()-1
        val y = sc.nextInt()-1
        graph[x].add(y)
        graph[y].add(x)
    }

    dfs(graph, p1, p2)
    println(if (d[p2] == 0) -1 else d[p2] )
}

private fun dfs(graph: MutableList<MutableList<Int>>, x: Int, y: Int) {
    visited[x] = true

    for(i in graph[x].indices) {
        if(!visited[graph[x][i]]) {
            d[graph[x][i]] += d[x] + 1
            dfs(graph, graph[x][i], y)
        }
    }
}