fun main() {
    val c = CheckIfParenthesesStringCanBeValid()
    println(c.canBeValid("))()))", "010100"))
}

class CheckIfParenthesesStringCanBeValid {
    fun canBeValid(s: String, locked: String): Boolean {
        if(s.length % 2 == 1) return false

        val n = s.length
        var opc = 0
        var clc = 0

        for((i, c) in locked.withIndex()) {
            if(c == '1') {
                if(s[i] == '(') {
                    opc++
                } else {
                    clc++
                }
            }
            if(opc > n / 2 || clc > (i+1) / 2) return false
        }
        val revl = locked.reversed()
        val revs = s.reversed()
        opc = 0
        clc = 0
        for((i, c) in revl.withIndex()) {
            if(c == '1') {
                if(revs[i] == '(') {
                    opc++
                } else {
                    clc++
                }
            }
            if(clc > n / 2 || opc > (i+1) / 2) return false
        }
        return true
    }
}