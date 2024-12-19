import kotlin.math.max
import kotlin.math.min

fun main() {
    val m = MaxChunksToMakeSorted()
    println(m.maxChunksToSorted(intArrayOf(1, 0, 2, 3, 4)))
}

class MaxChunksToMakeSorted {
    fun maxChunksToSorted(arr: IntArray): Int {
        val prefixMax = arr.scan(-1) { acc, e -> max(acc, e) }.toIntArray()
        val suffixMin = arr.reversed().scan(1000001) { acc, i -> min(acc, i) }.reversed().toIntArray()
        var chunk = 0
        for (i in arr.indices) {
            if (i == 0 && arr[i] == 0) chunk++
            else if (i > 0 && i < arr.size - 1 && prefixMax[i] <= i && suffixMin[i + 1] > i) chunk++
            else if(i == arr.size - 1) chunk++
        }
        return chunk
    }
}