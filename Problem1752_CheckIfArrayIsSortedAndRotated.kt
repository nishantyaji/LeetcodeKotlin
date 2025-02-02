class CheckIfArrayIsSortedAndRotated {
    fun check(nums: IntArray): Boolean {
        var first = 0
        val numsSize = nums.size
        for (i in nums.indices) {
            if (nums[(i - 1 + numsSize) % numsSize] > nums[i]) {
                first = i
                break
            }
        }
        var arr = IntArray(2 * numsSize) { nums[it % numsSize] }

        for (i in first until first + numsSize - 1) {
            if (arr[i] > arr[i + 1]) {
                return false
            }
        }
        return true
    }
}