fun main() {
    val m = MinNumOpsToMoveAllBallToEachBox()
    println(m.minOperations("0"))
    println(m.minOperations("110"))
}


class MinNumOpsToMoveAllBallToEachBox {
    fun minOperations(boxes: String): IntArray {
        val ones = boxes.mapIndexedNotNull { index, c -> if (c == '1') index else null }.toMutableList()
        if(ones.isEmpty()) return IntArray(boxes.length){0}
        val total = ones.reduce { acc, i -> acc + i }
        var right = ones.size
        val length = ones.size
        if (ones.isNotEmpty() && ones[0] == 0) {
            right--
            ones.removeAt(0)
        }
        val res = IntArray(boxes.length)
        res[0] = total
        for (i in 1..<boxes.length) {
            var thisVal = res[i - 1]
            var exclude = 0
            if (ones.isNotEmpty() && ones[0] == i) {
                right--
                ones.removeAt(0)
                thisVal--
                exclude = 1
            }
            thisVal = thisVal - right + (length - right - exclude)
            res[i] = thisVal
        }
        return res
    }
}