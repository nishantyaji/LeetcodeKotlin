fun main() {
    val c = CountingWordsWithGivenPrefix()
    println(c.prefixCount(arrayOf("apple", "app", "apricot", "banana", "apricot"), "ap"))
}

class CountingWordsWithGivenPrefix {
    fun prefixCount(words: Array<String>, pref: String): Int {
        return words.map { w -> if (w.startsWith(pref)) 1 else 0 }.sum()

    }
}