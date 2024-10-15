import java.util.*

class MaxScoreAfterApplyingKOps {
    fun maxKelements(nums: IntArray, k: Int): Long {
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        for (n in nums) pq.add(n)
        var res: Long = 0
        for (i in 0 until k) {
            val popped = pq.poll()
            res += popped
            pq.add(Math.ceil(popped.toDouble() / 3).toInt())
        }
        return res
    }
}