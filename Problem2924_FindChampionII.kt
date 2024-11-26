class FindChampionII {

    fun findChampion(n: Int, edges: Array<IntArray>): Int {
        if(n == 1) return 0
        val startSet = mutableSetOf<Int>(); val endSet = mutableSetOf<Int>()
        for(e in edges) {
            startSet.add(e[0])
            endSet.add(e[1])
        }
        return if(startSet.minus(endSet).size != 1 || startSet.union(endSet).size != n) -1 else startSet.minus(endSet).single()
    }
}