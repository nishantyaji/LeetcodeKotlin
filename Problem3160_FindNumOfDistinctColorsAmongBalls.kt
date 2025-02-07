class FindNumOfDistinctColorsAmongBalls {

    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val mp = mutableMapOf<Int, Int>()
        val latest = mutableMapOf<Int, Int>()

        var counter = 0
        fun change(index: Int, value: Int): Int {
            if (index in latest) {
                val prevValue = latest[index]!!
                mp[prevValue] = mp[prevValue]!! - 1
                if (mp[prevValue] == 0) {
                    counter--
                    mp.remove(prevValue)
                }
            }
            if (value !in mp) {
                counter++
                mp[value] = 0
            }
            mp[value] = mp[value]!! + 1
            latest[index] = value
            return counter
        }

        val res = IntArray(queries.size)
        for ((i, query) in queries.withIndex()) {
            res[i] = (change(query[0], query[1]))
        }
        return res
    }
}