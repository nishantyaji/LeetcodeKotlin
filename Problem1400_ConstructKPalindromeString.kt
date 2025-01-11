fun main() {
    val c = ConstructKPalindromeString()
    println(c.canConstruct("annabelle", 2))
}

class ConstructKPalindromeString {
    fun canConstruct(s: String, k: Int): Boolean {
        if(s.length < k) return false
        val mp = mutableMapOf<String, Int>()
        var odds = 0
        for (c in s) {
            mp[c.toString()] = mp.getOrDefault(c.toString(), 0) + 1
            if (mp[c.toString()]!! % 2 == 0) {
                odds--
            } else {
                odds++
            }
        }
        return odds <= k
    }
}