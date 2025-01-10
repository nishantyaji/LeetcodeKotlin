fun main() {
    val w = WordSubsets()
    println(w.wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("e", "o")))
}

class WordSubsets {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val unifiedMap = mutableMapOf<Char, Int>()
        for(w in words2) {
            val thisMap = mutableMapOf<Char, Int>()
            for(c in w) {
                thisMap[c] = thisMap.getOrDefault(c, 0) + 1
            }
            for(key in thisMap.keys){
                if(thisMap[key]!! > unifiedMap.getOrDefault(key, 0)) {
                    unifiedMap[key] = thisMap[key]!!
                }
            }
        }
        val res = mutableListOf<String>()
        for(w in words1) {
            val thisMap = mutableMapOf<Char, Int>()
            for(c in w) {
                thisMap[c] = thisMap.getOrDefault(c, 0) + 1
            }
            var skip = false
            for(key in unifiedMap.keys) {
                if(key !in thisMap || thisMap[key]!! < unifiedMap[key]!!) {
                    skip = true
                    break
                }
            }
            if(!skip) {
                res.add(w)
            }
        }
        return res
    }
}