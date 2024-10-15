import kotlin.math.abs

fun main() {
    val s = SeparateBlackAndWhiteBalls()
    println(s.minimumSteps("101"))
    println(s.minimumSteps("100"))
    println(s.minimumSteps("0111"))
}

class SeparateBlackAndWhiteBalls {
    fun minimumSteps(s: String): Long {
        var numZeroes = 0
        for (c in s) {
            if (c == '0') numZeroes++
        }
        val onesOut = mutableListOf<Int>()
        val zeroesOut = mutableListOf<Int>()
        for ((index, c) in s.withIndex()) {
            if (c == '1' && (index <= numZeroes - 1)) onesOut.add(index)
            if (c == '0' && (index >= numZeroes)) zeroesOut.add(index)
        }
        var res: Long = 0
        for (i in 0 until onesOut.size) res += abs(onesOut[i] - zeroesOut[i])
        return res
    }
}