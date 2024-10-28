import kotlin.math.max

fun main() {
    val p = Problem2501_LongestSquareStreakInArray()
    println(p.longestSquareStreak(intArrayOf(3, 9, 81, 6561)))
}

class Problem2501_LongestSquareStreakInArray {

    fun longestSquareStreak(nums: IntArray): Int {
        val arr = nums.map { n -> n.toLong() }.toLongArray()
        val mp = mutableMapOf<Long, Int>()
        arr.map { n -> mp[n] = 1 }
        arr.sort()
        var mx = -1
        for (n in arr) {
            if (n * n in mp) {
                mp[n * n] = mp[n]!!.plus(1)
                mx = max(mx, mp[n * n]!!)
            }
        }
        return mx
    }
}