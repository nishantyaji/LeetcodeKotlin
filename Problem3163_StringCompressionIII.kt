fun main() {
    val s = StringCompressionIII()
    println(s.compressedString("abcde"))
    println(s.compressedString("aaaaaaaaaaaaaabb"))
}

class StringCompressionIII {
    fun compressedString(word: String): String {
        var count = 0
        var prev = "~"
        var res = ""

        var temp = ""
        for (i in word.indices) {
            if(count > 9) {
                temp += "9$prev"
                count-= 9
            }
            val thisChar = word.substring(i, i + 1)
            if (thisChar != prev && prev != "~") {
                if(count > 0) res += (temp + "$count$prev")
                count = 0
                temp = ""
            }
            count++
            prev = thisChar
        }
        if(count > 9) {
            temp += "9$prev"
            count-= 9
        }
        res += (temp + if(count > 0) "$count$prev" else "")
        return res
    }
}