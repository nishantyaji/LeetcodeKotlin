fun main() {
    val s = SentenceSimilarityIII()
    println(s.areSentencesSimilar("a","ab"))
    println(s.areSentencesSimilar("My name is Haley","My Haley"))
    println(s.areSentencesSimilar("of","A lot of words"))
    println(s.areSentencesSimilar("Eating right now","Eating"))
}

class SentenceSimilarityIII {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        val s1 = if(sentence1.length < sentence2.length) sentence1 else sentence2
        val s2 = if(s1 == sentence1) sentence2 else sentence1
        var w1 = s1.split(" ")
        var w2 = s2.split(" ")
        var consumed = 0
        w1 = w1.dropWhile {  it == w2[consumed++] }
        w2 = w2.drop(consumed)
        consumed = 0
        w1 = w1.dropLastWhile { w2.size - 1 - consumed >= 0 && it == w2[w2.size - 1 - (consumed++)] }
        return w1.isEmpty()
    }
}