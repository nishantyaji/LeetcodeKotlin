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
        val cntr = mutableMapOf<String, Int>()
        IntArray(s1.length).mapIndexed { i, _ -> cntr[s1.substring(i, i + 1)] = cntr.getOrDefault(s1.substring(i, i + 1), 0) + 1 }

        val tempCntr = mutableMapOf<String, Int>()
        IntArray(s1.length).mapIndexed { i, _ ->
            tempCntr[s2.substring(i, i + 1)] = tempCntr.getOrDefault(s2.substring(i, i + 1), 0) + 1
        }

        if (counterEquals(cntr, tempCntr)) {
            return true
        }

        for (i in 1 until s2.length - s1.length + 1) {
            tempCntr[s2.substring(i - 1, i)] = tempCntr.getOrDefault(s2.substring(i - 1, i), 1) - 1
            if (tempCntr[s2.substring(i - 1, i)] == 0) {
                tempCntr.remove(s2.substring(i - 1, i))
            }
            tempCntr[s2.substring(i + s1.length - 1, i + s1.length)] =
                tempCntr.getOrDefault(s2.substring(i + s1.length - 1, i + s1.length), 0) + 1
            if (counterEquals(cntr, tempCntr)) {
                return true
            }
        }
        return false
    }
}