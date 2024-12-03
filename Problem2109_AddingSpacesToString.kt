fun main() {
    val a = AddingSpacesToString()
    println(a.addSpaces("LeetcodeHelpsMeLearn", intArrayOf(8,13,15)))
    println(a.addSpaces("icodeinpython", intArrayOf(1,5,7,9)))
    println(a.addSpaces("spacing", intArrayOf(0,1,2,3,4,5,6)))
}

class AddingSpacesToString {
    fun addSpaces(s: String, spaces: IntArray): String {
        spaces.sort()
        val spaces = intArrayOf(0)+ spaces + intArrayOf(s.length)
        return spaces.mapIndexed{ index, i -> if(index == 0) "" else s.substring(spaces[index-1], i)  }.drop(1).joinToString(" ")
    }
}