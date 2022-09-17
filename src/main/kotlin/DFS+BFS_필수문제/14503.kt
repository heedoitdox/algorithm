package `DFS+BFS_필수문제`

import java.util.*

/*
    로봇 청소기
    https://www.acmicpc.net/problem/14503
 */
private var n = 0
private var m = 0
private var cnt = 0

private val dx = listOf(-1, 0, 1, 0)
private val dy = listOf(0, 1, 0, -1)

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()

    val r = sc.nextInt()
    val c = sc.nextInt()
    val d = sc.nextInt()

    var map = Array(n) {IntArray(m) }
    for(i in 0 until n) {
        for(j in 0 until m){
            map[i][j] = sc.nextInt()
        }
    }

    dfs(map, r, c, d)
    println(cnt)
}

fun dfs(graph: Array<IntArray>, r: Int, c: Int, d: Int) {
    if(graph[r][c] == 0) {
        graph[r][c] = -1
        cnt++
    }

    var flag = false
    for(i in 0 until 4) {
        val nd = (d + 3 - i) % 4 // 왼쪽방향부터 차례대로 탐색
        val nx = r + dx[nd]
        val ny = c + dy[nd]

        // 청소가 안된 곳이 있으면 cnt++
        if(nx >= 0 && nx < n && ny >= 0 && ny < m ) {
            if( graph[nx][ny] == 0) {
                dfs(graph, nx, ny, nd)
                flag = true
                break
            }
        }
    }

    if(!flag) {
        var back = (d + 2) % 4
        var bx = r + dx[back]
        var by = c + dy[back]

        // 범위를 만족하면서 벽이아닐 때
        if (bx >= 0 && bx < n && by >= 0 && by < m  && graph[bx][by] != 1) {
            dfs(graph,bx, by, d)
        }
    }
}