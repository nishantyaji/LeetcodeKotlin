fun main() {
    val m = MinAddToMakeParenthesisValid()
    println(m.minAddToMakeValid("(()"))
}

class MinAddToMakeParenthesisValid {

    fun minAddToMakeValid(s: String): Int {
        val stack = java.util.Stack<Char>()
        var count = 0
        for(c in s.toCharArray()){
            if(c == ')'){
                if(stack.isEmpty()) count++
                else stack.pop()
            }
            else stack.push(c)
        }
        return count + stack.size
    }
}