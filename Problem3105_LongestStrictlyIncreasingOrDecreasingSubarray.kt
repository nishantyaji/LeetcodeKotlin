import kotlin.math.abs

class LongestStrictlyIncreasingOrDecreasingSubarray {

    fun longestMonotonicSubarray(nums: IntArray): Int {
        var prev = nums[0]
        var cumu = 1
        var res = -1

        for (i in 1 until nums.size) {
            res = if (abs(cumu) > res) abs(cumu) else res
            cumu = if (nums[i] > prev) {
                if (cumu <= 0) 2 else cumu + 1
            } else if (nums[i] < prev) {
                if (cumu >= 0) -2 else cumu - 1
            } else {
                0
            }
            prev = nums[i]
        }
        return if (abs(cumu) > res) abs(cumu) else res
    }
}