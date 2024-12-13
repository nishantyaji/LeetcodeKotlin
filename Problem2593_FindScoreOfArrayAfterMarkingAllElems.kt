import java.util.PriorityQueue

fun main() {
    val f = FindScoreOfArrayAfterMarkingAllElems()
    println(f.findScore(intArrayOf(2,1,3,4,5,2)))
}

class FindScoreOfArrayAfterMarkingAllElems {
    fun findScore(nums: IntArray): Long {
        val pq = PriorityQueue<Long> ()
        val marked = mutableSetOf<Long>()
        for((index, num) in nums.withIndex() ) {
            val temp = (1000001 * num.toLong() + index.toLong())
            println(temp)
            pq.add(temp)
        }
        var count = 0
        var res: Long = 0
        while (count < nums.size) {
            val temp: Long = pq.poll().toLong()
            val n: Long = temp / 1000001
            val i: Long = temp % 1000001
            if(i !in marked) {
                marked.add(i)
                res += n
                count++
                if(i - 1 >= 0 && i -1 !in marked) {
                    marked.add(i-1)
                    count++
                }
                if(i + 1 < nums.size && i + 1 !in marked) {
                    marked.add(i+1)
                    count++
                }
            }
        }
        return res
    }
}