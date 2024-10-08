import kotlin.math.absoluteValue

fun main() {
    val m = MinNumSwapsMakeStrBalanced()
    println(m.minSwaps("][]["))
}

class MinNumSwapsMakeStrBalanced {
    fun minSwaps(s: String): Int {
        // itertools.accumulate on an array that is -1 if ] or +1 if [. Then take the absolute vale of the min.
        // Take the ceil of its half
        return Math.ceil(s.map { c -> if (c == ']') -1 else 1 }.scan(0) { acc, e -> acc + e }.min().absoluteValue.toDouble() / 2).toInt()
    }
}