package `DFS+BFS_필수문제`

// #2178 미로탐색

import java.util.*

private var n = 0
private var m = 0

// 동서남북
private val dx = listOf(0, 0, 1, -1)
private val dy = listOf(1, -1, 0, 0)

fun main() {
    val sc = Scanner(System.`in`)

    n = sc.nextInt()
    m = sc.nextInt()

    val graph = Array(n) {IntArray(m) {0} }
    val visited = Array(n) {BooleanArray(m) {false} }

    for (i in 0 until n) {
        val line = sc.next().chunked(1).map { it.toInt() }
        line.forEachIndexed { index, it ->
            graph[i][index] = if (it == 1) 1 else 0
        }
    }

    println(bfs(graph, visited,0, 0))

}

fun bfs(graph: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int): Int {
    val q = LinkedList<Pair<Int, Int>>()
    q.offer(Pair(x,y))
    visited[x][y] = true

    while(q.isNotEmpty()) {
        val pos = q.poll()

        dx.forEachIndexed { index, dx ->
            if (pos.first + dx < 0 || pos.first + dx >= n ||
                pos.second + dy[index] < 0 || pos.second + dy[index] >= m) return@forEachIndexed

            val col = pos.first + dx
            val row = pos.second + dy[index]

            if (graph[col][row] == 0 || visited[col][row]) return@forEachIndexed

            graph[col][row] = graph[pos.first][pos.second] + 1
            q.offer(Pair(col, row))
            visited[col][row] = true
        }
    }

    return graph[n-1][m-1]
}