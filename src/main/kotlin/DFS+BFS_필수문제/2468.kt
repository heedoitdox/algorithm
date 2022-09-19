package `DFS+BFS_필수문제`

import java.util.*

/*
    #2468 안전영역
    https://www.acmicpc.net/problem/2468
 */

private var n = 0

// 동서남북
private val dx = listOf(0, 0, 1, -1)
private val dy = listOf(1, -1, 0, 0)

fun main() {
    val sc = Scanner(System.`in`)

    n = sc.nextInt()
    val map = Array(n) {IntArray(n) {0} }

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    for(i in 0 until n) {
        for(j in 0 until n) {
            val num = sc.nextInt()
            map[i][j] = num
            max = if(max < num) num else max
            min = if(min > num) num else min
        }
    }

    var result = 0
    for(h in min .. max) {
        var cnt = 0
        val visited = Array(n) {BooleanArray(n) {false} }
        for(i in 0 until n) {
            for (j in 0 until n) {
                if(!visited[i][j] && map[i][j] > h) {
                    dfs(map, visited,  h, i, j)
                    cnt++
                }
            }
        }
        result = if(cnt > result) cnt else result
    }
    println(if(result==0) 1 else result)
}

private fun dfs(map: Array<IntArray>, visited: Array<BooleanArray>, h: Int, x: Int, y: Int) {
    visited[x][y] = true

    if(map[x][y] > h) {
        dx.forEachIndexed { index, it ->
            val nx = x + it
            val ny = y + dy[index]

            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(!visited[nx][ny] && map[nx][ny] > h) {
                    dfs(map, visited, h, nx, ny)
                }
            }
        }
    }
}