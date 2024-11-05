fun main() {
    val m = MinNumChangesMakeBinStringBeautiful()
    println(m.minChanges("1001"))
}

class MinNumChangesMakeBinStringBeautiful {
    fun minChanges(s: String): Int {
        var numChanges = 0
        for(i in 0 until s.length/2){
            if(s.substring(2*i, 2 *i + 1) != s.substring(2*i+1, 2*i+2)) numChanges++
        }
        return numChanges
    }
}