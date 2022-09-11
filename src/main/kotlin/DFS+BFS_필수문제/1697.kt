package `DFS+BFS_필수문제`

import java.util.*

// #1697 숨바꼭질

private val dx = listOf(1, -1, 2)

fun main () {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val k = sc.nextInt()

    val seconds = IntArray(100001) {0}

    if(n == k) println("0")
    else println(bfs(seconds, n, k))
}

fun bfs(seconds: IntArray, x: Int, k: Int): Int {
    val q = LinkedList<Int>()
    q.offer(x)
    seconds[x] = 1

    while(q.isNotEmpty()) {
        var now = q.poll()

        dx.forEach {
            var pos = if(it == 2) now * it else now + it

            if (pos == k) return seconds[now]

            if (pos in 0..100000 && seconds[pos] == 0) {
                q.offer(pos)
                seconds[pos] = seconds[now] + 1
            }
        }
    }
    return 0
}