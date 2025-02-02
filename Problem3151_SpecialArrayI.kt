class SpecialArrayI {

    fun isArraySpecial(nums: IntArray): Boolean {
        for (i in 0..(nums.size - 2)) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) return false
        }
        return true
    }
}
