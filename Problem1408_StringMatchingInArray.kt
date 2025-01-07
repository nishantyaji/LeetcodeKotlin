fun main() {
    val s = StringMatchingInArray()
    println(s.stringMatching(arrayOf("mass","as","hero","superhero")))
}


class StringMatchingInArray {
    fun stringMatching(words: Array<String>): List<String> {
        words.sortBy { it.length }  // sort by length
        val res = mutableListOf<String>()
        for(i in words.indices) {
            for(j in i+1 until words.size) {
                if(words[j].contains(words[i])) {
                    res.add(words[i])
                    break
                }
            }
        }
        return res
    }
}