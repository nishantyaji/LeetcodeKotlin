class CheckIfOneStringSwapCanMakeStringsEqual {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        if(s1.length != s2.length) return false
        val counter1 = IntArray(26){0}
        val counter2 = IntArray(26){0}
        for(i in s1.indices){
            counter1[s1[i] - 'a']++
            counter2[s2[i] - 'a']++
        }
        for(i in 0 until 26){
            if(counter1[i] != counter2[i]) return false
        }
        var count = 0
        for(i in s1.indices){
            if(s1[i] != s2[i]) count++
            if(count > 2) return false
        }
        return true
    }
}