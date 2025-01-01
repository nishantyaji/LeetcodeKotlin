import kotlin.math.max

fun main() {
    val m = MaxScoreAfterSplittingString()
    println(m.maxScore("011101"))
    println(m.maxScore("00111"))
    println(m.maxScore("1111"))
    println(m.maxScore("00"))
}

class MaxScoreAfterSplittingString {
    fun maxScore(s: String): Int {
        var zeroes = 0
        var ones = 0
        var res = -501
        for (i in s.indices) {
            if (s[i] == '0') zeroes++
            else ones++
            if (i < s.length - 1) res = max(res, zeroes - ones)
        }
        return res + ones
    }
}
