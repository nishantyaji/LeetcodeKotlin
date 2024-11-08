fun main() {
    val m = MaxXORForEachQuery()
    print(m.getMaximumXor(intArrayOf(0,1,1,3), 2))
}

class MaxXORForEachQuery {

    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        return nums.scan(0) { acc, e -> acc xor e }.map { i -> i xor ((Math.pow(2.0, maximumBit.toDouble()) - 1).toInt()) }.drop(1).reversed().toIntArray()
    }
}