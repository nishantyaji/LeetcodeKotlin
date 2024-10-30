import kotlin.math.max


class SegmentTree1671(val size: Int, val defaultValue: Int = 0, val invalidValue: Int = -100001) {
    val st = IntArray(4 * size) { defaultValue }

    private fun segOp(left: Int, right: Int): Int {
        return max(left, right)
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
            st[index] = max(st[index], amount)
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
            return 0
            // do not return invalid number
        }

        val mid: Int = (low + high) / 2
        val lowVal = queryRe(leftChild(index), low, mid, lQuery, rQuery)
        val highVal = queryRe(rightChild(index), mid + 1, high, lQuery, rQuery)
        return segOp(lowVal, highVal)
    }
}

fun main() {
    val m = MinNumOfRemovalsToMakeMountainArray()
    println(m.minimumMountainRemovals(intArrayOf(4, 3, 2, 1, 1, 2, 3, 1)))
    println(m.minimumMountainRemovals(intArrayOf(1, 3, 1)))
    println(m.minimumMountainRemovals(intArrayOf(2, 1, 1, 5, 6, 2, 3, 1)))
}

class MinNumOfRemovalsToMakeMountainArray {
    fun minimumMountainRemovals(nums: IntArray): Int {
        val compMap = mutableMapOf<Int, Int>()
        nums.toSet().sorted().mapIndexed { index, i -> compMap.put(i, index) }
        val st = SegmentTree1671(compMap.size)
        val revSt = SegmentTree1671(compMap.size)
        val values = IntArray(nums.size)
        for (i in 0 until values.size) {
            val left = st.query(0, compMap[nums[i]]!! - 1)
            st.update(compMap[nums[i]]!!, left + 1)
            val right = revSt.query(0, compMap[nums[values.size - 1 - i]]!! - 1)
            revSt.update(compMap[nums[values.size - 1 - i]]!!, right + 1)
            values[i] = if (left > 0) values[i] + left else -Integer.MAX_VALUE
            values[values.size - 1 - i] = if (right > 0) values[values.size - 1 - i] + right else -Integer.MAX_VALUE
        }
        return values.size - 1 - values.max()
    }
}

