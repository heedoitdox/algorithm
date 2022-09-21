package `DFS+BFS_필수문제`

import java.util.*

/**
 * #5014 스타트링크
 * https://www.acmicpc.net/problem/5014
 */

// (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000)
private var F = 0
private var S = 0
private var G = 0

private val q = LinkedList<Int>()
private val d = Array(2) {0}

fun main() {
    val sc = Scanner(System.`in`)

    F = sc.nextInt()
    S = sc.nextInt()
    G = sc.nextInt()

    d[0] = sc.nextInt()
    d[1] = -sc.nextInt()

    val visited = IntArray(F+1) {0}

    bfs(visited, S)
}

fun bfs(visited: IntArray, start: Int) {
    val check = BooleanArray(F+1) {false}
    q.add(start)
    check[start] = true

    while(q.isNotEmpty()) {
        val now = q.poll()

        if(now == G) {
            println(visited[now])
            return
        }

        d.forEach {
            val next = now + it

            if(next in 1..F) {
                if(!check[next]) {
                    check[next] = true
                    visited[next] = visited[now] + 1
                    q.offer(next)
                }
            }
        }
    }

    println("use the stairs")
}