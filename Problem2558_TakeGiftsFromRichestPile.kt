import java.util.*
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    val t = TakeGiftsFromRichestPile()
    println(t.pickGifts(intArrayOf(25,64,9,4,100), 4))

}

class TakeGiftsFromRichestPile {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        var res: Long = 0
        for(g in gifts) pq.add(g)
        for(i in 0 until k) {
            val g = pq.poll()
            if(g == 1) return gifts.size.toLong()
            val newG: Int = floor(sqrt(g!!.toDouble())).toInt()
            pq.add(newG)
        }
        while (!pq.isEmpty()) res += pq.poll()
        return res
    }
}