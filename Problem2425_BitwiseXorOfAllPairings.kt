fun main() {
    val b = BitwiseXorOfAllPairings()
    print(b.xorAllNums(intArrayOf(1, 2, 3), intArrayOf(10, 2, 5, 0))) // 13
}

class BitwiseXorOfAllPairings {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        val x1 = nums1.reduce { acc, r -> acc xor r }
        val x2 = nums2.reduce { acc, r -> acc xor r }
        return (if (nums2.size % 2 == 1) x1 else 0) xor (if (nums1.size % 2 == 1) x2 else 0)
    }
}