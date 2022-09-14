import java.util.*

private var n = 0
private val graph = IntArray(11)
private val operator = IntArray(4) {0}

private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()

    for(i in 0 until n) {
        graph[i] = sc.nextInt()
    }

    for(i in 0 until 4) {
        operator[i] = sc.nextInt()
    }

    dfs(graph[0], 1)
    println(max)
    println(min)

}

fun dfs(x: Int, index: Int) {
    if(index == n) {
        max = Math.max(max, x)
        min = Math.min(min, x)
        return
    }

    for(i in operator.indices) {
        if (operator[i] > 0) {
            operator[i]--

            when(i) {
                0 -> dfs(x + graph[index], index + 1)
                1 -> dfs(x - graph[index], index + 1)
                2 -> dfs(x * graph[index], index + 1)
                3 -> dfs(x / graph[index], index + 1)
            }

            operator[i]++
        }
    }
}