fun main() {
    val m = MaxNumOfIntegersToChooseFromRangeI()
    println(m.maxCount(intArrayOf(1,6,5), 5, 6))
    println(m.maxCount(intArrayOf(1,2,3,4,5,6,7), 8, 1))
    println(m.maxCount(intArrayOf(11), 7, 50))
}

class MaxNumOfIntegersToChooseFromRangeI {
    fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
        return (1..n).filter { it !in banned }.scan(0){acc, e -> e + acc}.drop(1).takeWhile { i -> i <= maxSum }.count()
    }
}