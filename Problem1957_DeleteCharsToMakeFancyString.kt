fun main() {
    val d = DeleteCharsToMakeFancyString()
    println(d.makeFancyString("leeetcode"))
    println(d.makeFancyString("aaabaaaa"))
    println(d.makeFancyString("aab"))
}

class DeleteCharsToMakeFancyString {
    fun makeFancyString(s: String): String {
         return s.filterIndexed { index, c -> !(index >= 2 && c == s[index-1] && c == s[index-2]) }
    }
}