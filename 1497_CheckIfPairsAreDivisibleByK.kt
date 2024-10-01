fun main() {
    val c = CheckIfPairsAreDivisibleByK()
    println(c.canArrange(intArrayOf(1, 2, 3, 4, 5, 10, 6, 7, 8, 9), 5))
    println(c.canArrange(intArrayOf(1, 2, 3, 4, 5, 6), 10))
}

class CheckIfPairsAreDivisibleByK {

    fun canArrange(arr: IntArray, k: Int): Boolean {
        val counter = mutableMapOf<Int, Int>()
        arr.map { a -> counter[((a % k) + k) % k] = counter.getOrDefault(((a % k) + k) % k, 0) + 1 }
        val selfReflectiveIndices = mutableListOf<Int>(0)
        if (k % 2 == 0) {
            selfReflectiveIndices.add((k / 2))
        }
        val refl = selfReflectiveIndices.map { i -> counter.getOrDefault(i, 0) % 2 == 0 }.fold(true) { res, b -> res && b }
        // can be IntArray(k/2 + 1) below
        val others = IntArray(k) { it }
            .filter { i -> i !in selfReflectiveIndices }
            .map { i -> counter.getOrDefault(i, 0) == counter.getOrDefault(k - i, 0) }
            .fold(true) { res, b -> res && b }
        return refl && others
    }

}