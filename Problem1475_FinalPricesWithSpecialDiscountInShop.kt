import java.util.*

fun main() {
    val f = FinalPricesWithSpecialDiscountInShop()
    println(f.finalPrices(intArrayOf(8, 4, 6, 2, 3)))
}

class FinalPricesWithSpecialDiscountInShop {
    fun finalPrices(prices: IntArray): IntArray {
        val stack = Stack<Int>()
        val res = IntArray(prices.size) { prices[it] }
        for (i in prices.size - 1 downTo 0) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) stack.pop()
            if (!stack.isEmpty()) res[i] = prices[i] - stack.peek()
            stack.add(prices[i])
        }
        return res
    }
}