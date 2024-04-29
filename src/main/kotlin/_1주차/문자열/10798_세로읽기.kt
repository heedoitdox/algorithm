fun main() = with(System.`in`.bufferedReader()) {

    var list = List(5) {
        readLine()
    }

    for(i in 0 until 15) {
        for( j in 0 until 5) {
            if (i < list[j].length)
                print(list[j][i])
        }
    }
}