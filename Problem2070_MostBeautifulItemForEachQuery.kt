import kotlin.math.max

fun main() {
    val m = MostBeautifulItemForEachQuery()
    println(m.maximumBeauty(arrayOf(intArrayOf(1,2),
        intArrayOf(3,2),
        intArrayOf(2,4),
        intArrayOf(5,6),
        intArrayOf(3,5)), intArrayOf(1,2,3,4,5,6)
    ))
}



class MostBeautifulItemForEachQuery {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        val res = IntArray(queries.size)
        val newItems = items.toMutableList()
        queries.forEachIndexed { index, i -> newItems.add(intArrayOf( i+1, -(index+1))) }
        newItems.sortWith(compareBy ({ it[0]}, {it[1]}))
        var thisMax = 0
        for(item in newItems) {
            if(item[1] < 0) {
                res[-(item[1] + 1)] = thisMax
            } else{
                thisMax = max(thisMax, item[1])
            }
        }
        return res
    }
}