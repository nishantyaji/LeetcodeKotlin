import kotlin.math.log2

fun main() {
    val m = MinArrayEndd()
    println(m.minEnd(2, 7))
    println(m.minEnd(3, 4))
}

class MinArrayEndd {

    fun minEnd(n: Int, x: Int): Long {
        var base = 0
        var res: Long = x.toLong()
        var n1: Long = (n - 1).toLong()
        for (i in 0 until log2(x.toDouble()).toInt() + 1) {
            if (((1 shl base) and x) == 0 && n1 > 0) {
                res += ((n1 and 1) shl base)
                n1 = n1 shr 1
            }
            base++
        }
        while (n1 > 0) {
            res += ((n1 and 1) shl base)
            n1 = n1 shr 1
            base++
        }
        return res
    }
}