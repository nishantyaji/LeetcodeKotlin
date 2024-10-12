import java.util.*

fun main() {
    val d = DivideIntervalsIntoMinNumGroups()
    println(
        d.minGroups(
            arrayOf(
                intArrayOf(5, 10), intArrayOf(6, 8), intArrayOf(1, 5), intArrayOf(2, 3),
                intArrayOf(1, 10),
            )
        )
    )
    println(d.minGroups(arrayOf(intArrayOf(1, 3), intArrayOf(5, 6), intArrayOf(8, 10), intArrayOf(11, 13))))
}

class GroupInfo(val lastElem: Int, var group: MutableList<List<Int>>) : Comparable<GroupInfo> {
    override fun compareTo(other: GroupInfo): Int {
        return lastElem - other.lastElem
    }
}

class DivideIntervalsIntoMinNumGroups {
    fun minGroups(intervals: Array<IntArray>): Int {
        intervals.sortBy { i -> 1000000 * i[0].toLong() + i[1].toLong() }
        val pq = PriorityQueue<GroupInfo>()
        for (i in intervals) {
            if (pq.isEmpty() || pq.peek().lastElem >= i[0]) pq.add(GroupInfo(i[1], mutableListOf(i.toList())))
            else {
                val thisGroup = pq.poll()!!.group
                thisGroup.add(i.toList())
                pq.add(GroupInfo(i[1], thisGroup))
            }
        }
        return pq.size
    }
}