class CountNumOfBadPairs {
    fun countBadPairs(nums: IntArray): Long {
        val map = mutableMapOf<Int, Int>()
        var res: Long = 0
        for ((i, n) in nums.withIndex()) map[n - i] = map.getOrDefault(n - i, 0) + 1
        for ((_, v) in map) res += (nums.size - v) * v
        return res / 2
    }
}