package `DFS+BFS_필수문제`

import java.lang.Math.abs
import java.util.*

/*
    #9205 맥주 마시면서 걸어가기
    https://www.acmicpc.net/problem/9205
 */

private var result : MutableList<String> = mutableListOf()

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt() // 테스트 케이스 수

    for(tt in 0 until t) {
        val n = sc.nextInt() // 편의점 수

        // 집, 편의점, 페스티벌 좌표
        var coods = Array(n+2) { Pair(0, 0) }
        for(i in 0 until n+2) {
            coods[i] = Pair(sc.nextInt(), sc.nextInt())
        }

        val graph = mutableListOf<MutableList<Int>>()
        for (i in 0 until n+2) {
            graph.add(mutableListOf())
        }

        for(i in 0 until n + 2) {
            for(j in i+1 until n+2) {
                if(getDistance(coods[i], coods[j]) <= 1000) {
                    graph[i].add(j)
                    graph[j].add(i)
                }
            }
        }

        result.add(if (bfs(graph, n)) "happy" else "sad")
    }

    result.forEach {
        println(it)
    }
}

private fun getDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int {
    return abs(p1.first - p2.first) + abs(p1.second - p2.second)
}

private fun bfs(graph: MutableList<MutableList<Int>>, n: Int): Boolean {
    val q = LinkedList<Int>()
    q.offer(0)

    val visited = BooleanArray(n+2) { false }
    visited[0] = true

    while (q.isNotEmpty()) {
        val now = q.poll()

        if(now == n + 1) {
            return true
        }

        graph[now].forEach {
            if (!visited[it]) {
                visited[it] = true
                q.offer(it)
            }
        }
    }

    return false
}