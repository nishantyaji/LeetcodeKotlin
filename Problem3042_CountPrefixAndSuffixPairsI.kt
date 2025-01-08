fun main() {
    val c = CountPrefixAndSuffixPairsI()
    println(c.countPrefixSuffixPairs(arrayOf("a","aba","ababa","aa")))
}

class CountPrefixAndSuffixPairsI {
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var count = 0
        for(i in words.indices) {
            for(j in i + 1..words.lastIndex) {
                if(words[j].startsWith(words[i]) && words[j].reversed().startsWith(words[i].reversed())) count++
            }
        }
        return count
    }
}