import kotlin.math.min

fun main() {
    val s = ShortestDistanceAfterRoadAdditionQueriesI()
    println(
        s.shortestDistanceAfterQueries(
            5, arrayOf(
                intArrayOf(2, 4),
                intArrayOf(0, 2),
                intArrayOf(0, 4),
            )
        )
    )
}

class ShortestDistanceAfterRoadAdditionQueriesI {

    fun updateAll(dp: IntArray, out: MutableMap<Int, MutableList<Int>>, v: Int) {
        if (v in out && out.isNotEmpty()) {
            for (nei in out.getOrDefault(v, mutableListOf())) {
                val prev = dp[nei]
                dp[nei] = min(dp[nei], dp[v] + 1)
                if (prev != dp[nei]) {
                    updateAll(dp, out, nei)
                }
            }
        }
    }

    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val out = mutableMapOf<Int, MutableList<Int>>()
        IntArray(n - 1).forEachIndexed { index, i -> out[index] = mutableListOf(index + 1) }
        val dp = IntArray(n).mapIndexed { index, i -> index }.toIntArray()
        val res = mutableListOf<Int>()

        for (query in queries) {
            dp[query[1]] = min(dp[query[1]], 1 + dp[query[0]])
            out[(query[0])]?.add(query[1])
            updateAll(dp, out, query[1])
            res.add(dp[n - 1])
        }
        return res.toIntArray()
    }
}