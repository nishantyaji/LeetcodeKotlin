import kotlin.math.max

class MaxAscendingSubarraySum {

    fun maxAscendingSum(nums: IntArray): Int {
        var cumu = 0
        var prev = -1
        var res = -1

        for (n in nums) {
            res = max(res, cumu)
            cumu = if (n > prev) cumu + n else n
            prev = n
        }
        return max(res, cumu)
    }
}