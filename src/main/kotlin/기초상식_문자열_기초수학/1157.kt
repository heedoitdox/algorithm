package 기초상식_문자열_기초수학

const val S=1000001
fun main(){
    val b = ByteArray(S)
    var p = 0
    System.`in`.read(b, 0, S)
    val a = IntArray(123)
    while (b[p] > 64.toByte()) a[b[p++].toInt()]++
    var m = 0;
    var c = 0;
    var r = 0
    for (i in 65..90) {
        val v = a[i] + a[i + 32]
        if (m == v) c++
        else if (m < v) {
            m = v; r = i; c = 1
        }
    }
    print(if (c == 1) r.toChar() else '?')
}