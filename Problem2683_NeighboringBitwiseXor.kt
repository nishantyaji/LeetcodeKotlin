class NeighboringBitwiseXor {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        return 0 == derived.reduce { acc, r -> acc xor r }
    }
}
fun main() {
    val n = NeighboringBitwiseXor()
    println(n.doesValidArrayExist(intArrayOf(1, 2, 3))) // true
    println(n.doesValidArrayExist(intArrayOf(1, 2, 4))) // false
}