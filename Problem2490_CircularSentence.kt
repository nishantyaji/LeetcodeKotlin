fun main() {
    val p = CircularSentence()
    println(p.isCircularSentence("leetcode exercises sound delightful"))
    println(p.isCircularSentence("eetcode"))
    println(p.isCircularSentence("leetcode"))
    println(p.isCircularSentence("Leetcode is cool"))
}


class CircularSentence {
    fun isCircularSentence(sentence: String): Boolean {
        val words = sentence.split(" ")
        return words.filterIndexed{index, s -> s.last() != words[(index + 1) % words.size].first()}.isEmpty()
    }
}