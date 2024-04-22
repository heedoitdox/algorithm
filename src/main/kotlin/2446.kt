fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    println("*".repeat(n*2-1))
    for(i in 2 until n) {
        println(" ".repeat(i-1) + "*".repeat(n*2-(i*2-1)))
    }

    if(n!=1) {
        println(" ".repeat(n-1) + "*")
    }


    for(i in n-1 downTo  2) {
        println(" ".repeat(i-1) + "*".repeat(n*2-(i*2-1)))
    }
    if(n!=1) {
        println("*".repeat(n*2-1))
    }
}