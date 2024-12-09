fun main() {
    val s = SpecialArrayII()
    println(s.isArraySpecial(intArrayOf(3, 4, 1, 2, 6), arrayOf(intArrayOf(0, 4))))
    println(s.isArraySpecial(intArrayOf(4, 3, 1, 6), arrayOf(intArrayOf(0, 2), intArrayOf(2, 3))))
}


class SpecialArrayII {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val nums2 = intArrayOf(nums[0] + 1) + nums
        val flags = nums2.mapIndexed { index, i -> if (index > 0) 1 - ((i + nums2[index - 1]) % 2) else 0 }.drop(1)
            .scan(0) { acc, e -> acc + e }.drop(1).toIntArray()
        return queries.map { q -> flags[q[1]] - flags[q[0]] == 0 }.toBooleanArray()
    }
}