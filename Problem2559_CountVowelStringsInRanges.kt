fun main() {
    val c = CountVowelStringsInRanges()
    println(c.vowelStrings(arrayOf("aba","bcb","ece","aa","e"), arrayOf(
        intArrayOf(0,2),
        intArrayOf(1,4),
        intArrayOf(1,1)
    )))

}

class CountVowelStringsInRanges {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val res = IntArray(queries.size) { 0 }
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        fun isVowel(s: String): Int {
            if (s[0] in vowels && s[s.length - 1] in vowels) return 1
            return 0
        }

        val acc = words.map { s -> isVowel(s) }.scan(0) { acc, i -> acc + i }
        for ((i, q) in queries.withIndex()) res[i] = acc[q[1] + 1] - acc[q[0]]
        return res
    }
}