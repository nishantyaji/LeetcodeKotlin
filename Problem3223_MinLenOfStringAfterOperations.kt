fun main() {
    val m = MinLenOfStringAfterOperations()
    println(m.minimumLength("aabccabba"))
}

class MinLenOfStringAfterOperations {
    fun minimumLength(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }
        var res = 0
        for((_, v) in map) {
            if(v % 2 == 1) {
                res++
            } else{
                res += 2
            }
        }
        return res
    }
}