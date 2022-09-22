package `DFS+BFS_필수문제`

import java.util.*
import kotlin.math.max

/**
 * #2579 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()

    val dp = Array(n+1) {0}
    val array = Array(n+1) {0}

    for (i in 1 .. n) {
        array[i] = sc.nextInt()
    }

    dp[1] = array[1]

    if(n >= 2) {
        dp[2] = array[1] + array[2]
    }

    for(i in 3..n) {
        dp[i] = max(dp[i-2], dp[i-3] + array[i-1]) + array[i]
    }

    println(dp[n])
}