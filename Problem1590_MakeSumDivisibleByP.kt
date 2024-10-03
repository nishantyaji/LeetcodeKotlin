fun main() {
    val m = MakeSumDivisibleByP()
    println(m.minSubarray(intArrayOf(1000000000,1000000000,1000000000), 3))
    println(m.minSubarray(intArrayOf(3, 1, 4, 2), 6))
    println(m.minSubarray(intArrayOf(6, 3, 5, 2), 9))
    println(m.minSubarray(intArrayOf(1, 2, 3), 3))
}

class MakeSumDivisibleByP {
    fun minSubarray(nums: IntArray, p: Int): Int {
        fun modp(numm: Long): Long {
            return ((numm % p) + p) % p
        }

        val allSum: Long = nums.sumOf { i -> i.toLong() }
        if (modp(allSum) == 0.toLong()) {
            return 0
        }

        val dp = mutableMapOf<Long, Long>()
        dp.put(0, -1)
        val toRemove = modp(allSum)
        var prefixSum: Long = 0
        var minVal = Long.MAX_VALUE
        for (i in nums.indices) {
            prefixSum += nums[i].toLong()
            val compl = modp(prefixSum - toRemove)
            if (compl in dp) {
                minVal = Math.min(minVal, i - dp.getOrDefault(compl, -Long.MAX_VALUE))
            }
            dp[modp(prefixSum)] = i.toLong()
        }

        return if (minVal == nums.size.toLong()) -1 else minVal.toInt()
    }

}