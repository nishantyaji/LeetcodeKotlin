fun main() {
    val m = MakeStringSubseqUsingCyclicIncrements()
    println(m.canMakeSubsequence("abc", "ad"))
    println(m.canMakeSubsequence("zc", "ad"))
    println(m.canMakeSubsequence("ab", "d"))
}

class MakeStringSubseqUsingCyclicIncrements {
    fun canMakeSubsequence(str1: String, str2: String): Boolean {

        fun nextChar(c: Char): Char{
            return when(c) {
                'z' -> 'a'
                in 'a'..'y' -> c + 1
                else -> c
            }
        }
        val str1Inc = str1.map { c -> nextChar(c) }.joinToString("")
        var cIdx = 0
        for(i in 0 until str1.length) {
            if(str2[cIdx] == str1[i] || str2[cIdx] == str1Inc[i]) {
                cIdx++
                if(cIdx == str2.length) {
                    return true
                }
            }
        }
        return cIdx == str2.length
    }
}