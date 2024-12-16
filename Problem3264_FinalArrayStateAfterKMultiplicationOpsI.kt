import java.util.*

fun main() {
    val f = FinalArrayStateAfterKMultiplicationOpsI()
    println(f.getFinalState(intArrayOf(2, 1, 3, 5, 6), 5, 2))
}

// This is how to implement an interface in Kotlin
class PairCustom(val value: Int, val index: Int) : Comparable<PairCustom> {
    override fun compareTo(other: PairCustom): Int {
        if (value == other.value) {
            return index - other.index
        }
        return value - other.value
    }
}

class FinalArrayStateAfterKMultiplicationOpsI {

    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val pq = PriorityQueue<PairCustom>()
        for ((index, n) in nums.withIndex())
            pq.add(PairCustom(n, index))

        for (i in 0 until k) {
            val p = pq.poll()
            pq.add(PairCustom(multiplier * p.value, p.index))
        }
        val res = IntArray(nums.size) { 0 }
        while (!pq.isEmpty()) {
            val p = pq.poll()
            res[p.index] = p.value
        }
        return res
    }
}