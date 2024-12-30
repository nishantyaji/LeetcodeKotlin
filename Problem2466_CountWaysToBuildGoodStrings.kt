import kotlin.math.max
import kotlin.math.min

fun main() {
    val c = CountWaysToBuildGoodStrings()
    println(c.countGoodStrings(3,3,1,1))
    println(c.countGoodStrings(2,3,1,2))
}


class CountWaysToBuildGoodStrings {
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val base = 1000000007
        val mx = max(zero, one)
        val mn = min(zero, one)
        val dp = IntArray(high + mx + 1){0}
        dp[mn] += 1
        dp[mx] += 1
        for(i in mn..high) {
            if(dp[i] > 0) {
                dp[i+zero] = (dp[i+zero] + dp[i]) % base
                dp[i+one] = (dp[i+one] + dp[i]) % base
            }
        }

        var res = 0
        for(i in low..high) {
            res = (res + dp[i]) % base
        }
        return res
    }
}