fun main() {
    val c = PermutationInString()
    println(c.checkInclusion("ab","eidbaooo"))
    println(c.checkInclusion("ab", "eidboaoo"))
}

private class PermutationInString {
    fun counterEquals(m1: Map<String, Int>, m2: Map<String, Int>): Boolean {
        if (m1.size != m2.size) {
            return false
        }
        for (k in m1.keys) {
            if (m1[k] != m2[k]) {
                return false
            }
        }
        return true
    }

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) {
            return false
        }
        val counter = mutableMapOf<String, Int>()
        IntArray(s1.length).mapIndexed { i, _ -> counter[s1.substring(i, i + 1)] = counter.getOrDefault(s1.substring(i, i + 1), 0) + 1 }

        val tempCounter = mutableMapOf<String, Int>()
        IntArray(s1.length).mapIndexed { i, _ ->
            tempCounter[s2.substring(i, i + 1)] = tempCounter.getOrDefault(s2.substring(i, i + 1), 0) + 1
        }

        if (counterEquals(counter, tempCounter)) {
            return true
        }

        for (i in 1 until s2.length - s1.length + 1) {
            tempCounter[s2.substring(i - 1, i)] = tempCounter.getOrDefault(s2.substring(i - 1, i), 1) - 1
            if (tempCounter[s2.substring(i - 1, i)] == 0) {
                tempCounter.remove(s2.substring(i - 1, i))
            }
            tempCounter[s2.substring(i + s1.length - 1, i + s1.length)] =
                tempCounter.getOrDefault(s2.substring(i + s1.length - 1, i + s1.length), 0) + 1
            if (counterEquals(counter, tempCounter)) {
                return true
            }
        }
        return false
    }
}