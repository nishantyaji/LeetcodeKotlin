fun main() {
    val c = CheckIfWordOccursAsPrefixOfAnyWordInSentence()
    println(c.isPrefixOfWord("i love eating burger", "burg"))
    println(c.isPrefixOfWord("this problem is an easy problem", "pro"))
    println(c.isPrefixOfWord("i am tired", "you"))
}


class CheckIfWordOccursAsPrefixOfAnyWordInSentence {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        return sentence.split(" ").indexOfFirst { s -> s.startsWith(searchWord) }.let{ if(it < 0) -1 else it + 1}
    }
}