package `단기간성장`

/**
 * #1655 가운데를 말해요
 * https://www.acmicpc.net/problem/1655
 * 최대힙, 최소힙
 */

import java.util.*

private var n = 0
private var maxPQ = PriorityQueue<Int>(Collections.reverseOrder())
private var minPQ = PriorityQueue<Int>()

fun main() {
    val sc = Scanner(System.`in`)

    n = sc.nextInt()

    for(i in 0 until n) {
        val num = sc.nextInt()

        if(maxPQ.size == minPQ.size) maxPQ.offer(num)
        else minPQ.offer(num)

        if(minPQ.isNotEmpty() && maxPQ.isNotEmpty()) {
            if(minPQ.peek() < maxPQ.peek()) {
                val temp = minPQ.poll()
                minPQ.offer(maxPQ.poll())
                maxPQ.offer(temp)
            }
        }
        println(maxPQ.peek())
    }
}