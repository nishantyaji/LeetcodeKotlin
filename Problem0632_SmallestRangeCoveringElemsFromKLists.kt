import java.util.*
import kotlin.math.max

fun main() {
    val s = SmallestRangeCoveringElemsFromKLists()
    println(
        s.smallestRange(
            mutableListOf(
                mutableListOf(4, 10, 15, 24, 26),
                mutableListOf(0, 9, 12, 20),
                mutableListOf(5, 18, 22, 30)
            )
        )
    )
    println(s.smallestRange(mutableListOf(mutableListOf(1, 2, 3), mutableListOf(1, 2, 3), mutableListOf(1, 2, 3))))
}

class SmallestRangeCoveringElemsFromKLists {

    fun smallestRange(nums: List<List<Int>>): IntArray {

        val pq = PriorityQueue<GroupInfoFirst>()

        for ((index, n) in nums.withIndex()) {
            val dq = LinkedList(n)
            val first = dq.pollFirst()
            val group = GroupInfoFirst(first, index, dq)
            pq.add(group)
        }

        var maxValue = -Int.MAX_VALUE
        for(n in nums){
            maxValue = max(maxValue, n[0])
        }

        var res = Int.MAX_VALUE; var lBound = -Int.MAX_VALUE; var uBound = -Int.MAX_VALUE
        while (!pq.isEmpty()) {
            val elem = pq.poll()
            if(maxValue - elem.firstElem < res) {
                res = maxValue - elem.firstElem
                lBound = elem.firstElem
                uBound = maxValue
            }
            if(elem.group.isEmpty()) {
                break
            }
            val newVal = elem.group.pollFirst()
            maxValue = max(maxValue, newVal)
            val newElem = GroupInfoFirst(newVal, elem.groupId, elem.group)
            pq.add(newElem)
        }
        return intArrayOf(lBound, uBound)
    }
}


class GroupInfoFirst(val firstElem: Int, val groupId: Int, var group: LinkedList<Int>) : Comparable<GroupInfoFirst> {
    override fun compareTo(other: GroupInfoFirst): Int {
        return firstElem - other.firstElem
    }
}