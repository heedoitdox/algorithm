fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    for(i in 0 until n) {
        print(" ".repeat(n-i-1))
        for(j in 0 .. i) {
            print("*")
            if(i != j) {
                print(" ")
            }
        }
        println()
    }
}