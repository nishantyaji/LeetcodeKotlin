fun main() {
    val c = CheckIfPairsAreDivisibleByK()
    println(c.canArrange(intArrayOf(1, 2, 3, 4, 5, 6), 10))
}

class CheckIfPairsAreDivisibleByK {

    fun canArrange(arr: IntArray, k: Int): Boolean {
        val counter = mutableMapOf<Int, Int>()
        for (a in arr) {
            counter[((a % k) + k) % k] = counter.getOrDefault(((a % k) + k) % k, 0) + 1
        }
        val selfReflectiveIndices = mutableListOf<Int>(0)
        if (k % 2 == 0) {
            selfReflectiveIndices.add((k / 2))
        }

        for (i in 0 until k) {
            if (i in selfReflectiveIndices) {
                if (counter.getOrDefault(i, 0) % 2 != 0) {
                    return false
                }
            } else {
                if (counter.getOrDefault(i, 0) != counter.getOrDefault(k - i, 0)) {
                    return false
                }
            }
        }
        return true
    }

}