fun main() {
    val i = IdentifyLargestOutlierInArray()
    println(i.getLargestOutlier(intArrayOf(6,-31,50,-35,41,37,-42,13)))
    println(i.getLargestOutlier(intArrayOf(1,1,1,1,1,5,5)))
}

class IdentifyLargestOutlierInArray {
    fun getLargestOutlier(nums: IntArray): Int {
        val mp = mutableMapOf<Int, Int>()
        nums.forEach { n -> mp[n] = mp.getOrDefault(n, 0) + 1 }
        val arr = nums.sortedArrayDescending()
        val sum = nums.sum()
        return arr.find { i -> (sum - i) % 2 == 0 && (sum - i) / 2 in mp && (((sum - i)/2 != i) or (mp[(sum - i)/2]!! > 1))}!!
    }
}