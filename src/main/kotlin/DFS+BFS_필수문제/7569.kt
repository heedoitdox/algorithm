package `DFS+BFS_필수문제`

import java.lang.Integer.max
import java.util.*

/**
 * #7569 토마토
 * https://www.acmicpc.net/problem/7569
 */

private val q = LinkedList<Tomato>()

private class Tomato (
    var x: Int = 0,
    var y: Int = 0,
    var z: Int = 0
)

private var n = 0
private var m = 0
private var h = 0

private val dx = listOf(1, -1, 0, 0, 0, 0)
private val dy = listOf(0, 0, 0, 0, -1, 1)
private val dz = listOf(0, 0, 1, -1, 0, 0)

private var result = 0


fun main() {
    val sc = Scanner(System.`in`)

    m = sc.nextInt()
    n = sc.nextInt()
    h = sc.nextInt()

    val tomatoBox = mutableListOf<Array<IntArray>>()

    for(i in 0 until h) {
        val map = Array(n) {IntArray(m)}
        for(j in 0 until n) {
            for(k in 0 until m) {
                map[j][k] = sc.nextInt()
                if(map[j][k] == 1) q.offer(Tomato(j, k, i))
            }
        }
        tomatoBox.add(map)
    }

    println(bfs(tomatoBox))
}

private fun bfs(tomatoBow: MutableList<Array<IntArray>>): Int {
    while(q.isNotEmpty()) {
        val now = q.poll()

        dx.forEachIndexed { index, it ->
            val nx = now.x + it
            val ny = now.y + dy[index]
            val nz = now.z + dz[index]

            if(nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h) {
                if(tomatoBow[nz][nx][ny] == 0) {
                    q.offer(Tomato(nx, ny, nz))
                    tomatoBow[nz][nx][ny] = tomatoBow[now.z][now.x][now.y] + 1
                }
            }
        }
    }

    var result = Int.MIN_VALUE

    for(i in 0 until h) {
        for(j in 0 until n) {
            for (k in 0 until m) {
                if(tomatoBow[i][j][k] == 0) return -1
                result = max(result, tomatoBow[i][j][k])
            }
        }
    }

    return if(result == 1) 0 else result-1
}

