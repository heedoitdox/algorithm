package `DFS+BFS_필수문제`

// #2606 바이러스

import java.util.*

private val visited = BooleanArray(101) {false}

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val m = sc.nextInt()

    val graph = mutableListOf<MutableList<Int>>()
    for (i in 0 until n) {
        graph.add(mutableListOf())
    }

    for (i in 0 until m) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        graph[a-1].add(b-1)
        graph[b-1].add(a-1)
    }

    print(bfs(graph, 0))

}

fun bfs(graph: MutableList<MutableList<Int>>, x: Int): Int {
    val q = LinkedList<Int>()
    q.offer(x)
    visited[x] = true

    var cnt = 0

    while (q.isNotEmpty()) {
        val now = q.poll()

        for (i in graph[now].indices) {
            val node = graph[now][i]
            if (!visited[node]) {
                q.offer(node)
                visited[node] = true
                cnt++
            }
        }
    }

    return cnt
}
