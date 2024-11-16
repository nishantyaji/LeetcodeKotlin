fun main() {
    val f = FindPowKSizeSubarrayI()
    f.resultsArray(intArrayOf(1,2,3,4,3,2,5), 3).forEach { i -> println(i) }
}

class FindPowKSizeSubarrayI {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        if(k == 1) return nums
        val res = IntArray(nums.size - k + 1) { -1}
        val diffs = nums.mapIndexed { index, i -> if(index > 0) i - nums[index-1] else 0 }.drop(1)
        var count = 0
        for((index, d) in diffs.withIndex()) {
            count = if(d == 1) count+1 else 0
            if(count == k-1) {
                res[index + 1 - k + 1] = nums[index - (k-2)] + k - 1
                count--
            }
        }
        return res
    }
}