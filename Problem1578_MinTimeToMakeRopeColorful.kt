import java.util.*


fun main() {
    val m = MinTimeToMakeRopeColorful()

    println(m.minCost("abaac", intArrayOf(1, 2, 3, 4, 5)))
    println(m.minCost("abc", intArrayOf(1, 2, 3)))
    println(m.minCost("aabaa", intArrayOf(1, 2, 3, 4, 1)))
    println(m.minCost("bbbaaa", intArrayOf(4, 9, 3, 8, 8, 9)))
}

class MinTimeToMakeRopeColorful {

    fun minCost(colors: String, neededTime: IntArray): Int {
        var prev = "-"
        var res = 0
        var pq = PriorityQueue<Int>(Collections.reverseOrder()) // max heap

        for (i in 0..colors.length - 1) {
            if (colors.substring(i, i + 1).equals(prev)) {
                pq.add(neededTime[i])
            } else {
                if (pq.isNotEmpty()) {
                    pq.poll()
                    if (pq.isNotEmpty()) {
                        res += pq.stream().reduce { acc: Int, r: Int -> acc + r }.get()
                    }
                }
                pq = PriorityQueue<Int>(Collections.reverseOrder())  // max heap
                pq.add(neededTime[i])
                prev = colors.substring(i, i + 1)
            }
        }

        if (pq.isNotEmpty()) {
            pq.poll()
            if (pq.isNotEmpty()) {
                res += pq.stream().reduce { acc: Int, r: Int -> acc + r }.get()
            }
        }
        return res
    }
}