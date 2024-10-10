import kotlin.math.max
import kotlin.math.min

fun main() {
    val m = MaxWidthRamp()
    println(m.maxWidthRamp(intArrayOf(6, 0, 8, 2, 1, 5)))
    println(m.maxWidthRamp(intArrayOf(9, 8, 1, 0, 1, 9, 4, 0, 4, 1)))
}


class SegmentTree(val size: Int, val defaultValue: Int = Int.MAX_VALUE, val invalidValue: Int = Int.MAX_VALUE) {
    val st = IntArray(4 * size) { defaultValue }

    private fun segOp(left: Int, right: Int): Int {
        return min(left, right)
    }


    private fun leftChild(parent: Int): Int {
        // zero-indexed
        return 2 * parent + 1
    }

    private fun rightChild(parent: Int): Int {
        // zero-indexed
        return 2 * parent + 2
    }

    fun update(place: Int, amount: Int) {
        updateRe(0, 0, size - 1, place, amount)
    }

    private fun updateRe(index: Int, low: Int, high: Int, place: Int, amount: Int) {
        if (low == high) {
            st[index] = min(st[index], amount)
            return
        }

        val mid: Int = (low + high) / 2
        if (place in low..mid) {
            updateRe(leftChild(index), low, mid, place, amount)
        } else {
            updateRe(rightChild(index), mid + 1, high, place, amount)
        }

        st[index] = segOp(st[leftChild(index)], st[rightChild(index)])
    }

    fun query(lQuery: Int, rQuery: Int): Int {
        return queryRe(0, 0, size - 1, lQuery, rQuery)
    }

    private fun queryRe(index: Int, low: Int, high: Int, lQuery: Int, rQuery: Int): Int {
        if (low >= lQuery && high <= rQuery) {
            return st[index]
        }
        if (high < lQuery || low > rQuery) {
            return invalidValue
        }

        val mid: Int = (low + high) / 2
        val lowVal = queryRe(leftChild(index), low, mid, lQuery, rQuery)
        val highVal = queryRe(rightChild(index), mid + 1, high, lQuery, rQuery)
        return segOp(lowVal, highVal)
    }
}


class MaxWidthRamp {

    fun maxWidthRamp(nums: IntArray): Int {
        val coMap = mutableMapOf<Int, Int>()
        nums.toSet().sorted().mapIndexed { index, int -> coMap.put(int, index) }
        val segTree = SegmentTree(coMap.size)
        var res = 0
        for ((index, n) in nums.withIndex()) {
            val ans = segTree.query(0, coMap.getOrDefault(n, -1))
            if (ans != Int.MAX_VALUE) {
                res = max(res, (index - ans))
            }
            segTree.update(coMap.getOrDefault(n, -1), index)
        }
        return res
    }
}