fun main() {
    val r = RotateString()
    println(r.rotateString("abcde", "cdeab"))
    println(r.rotateString("abcde", "abced"))
    println(r.rotateString("abcde", "abcdef"))
}

class RotateString {
    fun rotateString(s: String, goal: String): Boolean {
        val ss = s + s
        return IntArray(s.length).filterIndexed{ index, _ -> ss.subSequence(index, index + s.length) == goal }.isNotEmpty()
    }
}