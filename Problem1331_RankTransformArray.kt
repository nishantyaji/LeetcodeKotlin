fun main() {
    val r = RankTransformArray()
    println(r.arrayRankTransform(intArrayOf(37,12,28,9,100,56,80,5,12)))
}

class RankTransformArray {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val rankMap = mutableMapOf<Int, Int>()
        arr.toSet().sorted().mapIndexed { index, i ->  rankMap.put(i, index+1)}
        val res = IntArray(arr.size)
        arr.mapIndexed { index, i -> res[index] = rankMap.getOrDefault(i, -1) }
        return res
    }
}