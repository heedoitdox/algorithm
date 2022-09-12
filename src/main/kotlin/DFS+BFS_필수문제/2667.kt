package `DFS+BFS_필수문제`

import java.util.*

/* #2667 단지 번호 붙이기
https://www.acmicpc.net/problem/2667 */

private val complexes: MutableList<Int> = mutableListOf()
private var n = 0
private val dx = listOf(0, 0, 1, -1)
private val dy = listOf(1, -1, 0, 0)
private var cnt = 0;

fun main () {
    var sc = Scanner(System.`in`)

    n = sc.nextInt()
    var graph = Array(n) {IntArray(n) }
    var visited = Array(n) {BooleanArray(n) {false} }

    for (i in 0 until n) {
        val line = sc.next().chunked(1).map { it.toInt() }
        line.forEachIndexed { index, it ->
            graph[i][index] = it
        }
    }

    for(i in graph.indices) {
        for(j in graph[i].indices) {
            if(graph[i][j] == 1 && !visited[i][j]) {
                cnt = 1
                dfs(graph, visited, i, j)
                complexes.add(cnt)
            }
        }
    }

    println(complexes.size)
    complexes.sorted().forEach { println(it) }
}

fun dfs(graph: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int) {
    visited[x][y] = true

    dx.forEachIndexed { index, it ->
        var dx = x +  it
        var dy = y +  dy[index]

        if (dx < 0 || dx >= n || dy < 0 || dy >= n) return@forEachIndexed

        if(!visited[dx][dy] && graph[dx][dy] == 1) {
            cnt++
            dfs(graph, visited, dx, dy)
        }
    }
}