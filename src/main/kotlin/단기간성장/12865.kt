package 단기간성장

import java.util.*
import kotlin.math.max

/**
 * #12865 평범한 배낭
 * https://www.acmicpc.net/problem/12865
 */

private var k = 0
private var n = 0

fun main() {
    val sc = Scanner(System.`in`)

    n = sc.nextInt()
    k = sc.nextInt()

    val w = Array(n+1) {0}
    val v = Array(n+1) {0}
    val dp = Array(n+1) {IntArray(k+1) {0} }

    for(i in 1 .. n) {
        w[i] = sc.nextInt()
        v[i] = sc.nextInt()
    }

    for(i in 1..n) {
        for(j in 1..k) {
            // 무게를 더 담을 수 있는 경우
            if(w[i] > j) dp[i][j] = dp[i-1][j]
            // 무게를 더 담을 수 없는 경우
            else dp[i][j] = max(dp[i-1][j], dp[i-1][j-w[i]] + v[i])
        }
    }

    println(dp[n][k])
}