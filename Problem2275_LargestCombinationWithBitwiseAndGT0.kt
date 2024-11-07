fun main() {
    val l = LargestCombinationWithBitwiseAndGT0()
    println(l.largestCombination(intArrayOf(16,17,71,62,12,24,14)))

}

class LargestCombinationWithBitwiseAndGT0 {
    fun largestCombination(candidates: IntArray): Int {
        val counter = mutableMapOf<Int, Int>()
        for(c in candidates) {
            val binStr = c.toString(2).reversed()
            for((index, ch) in binStr.withIndex()){
                if(ch == '1') counter[index] = counter.getOrDefault(index, 0) + 1
            }
        }
        return counter.values.max()
    }
}