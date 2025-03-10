import java.util.*

class ClearDigits {

    fun clearDigits(s: String): String {
        val stack = Stack<Char>()
        for(c in s){
            if(c.isDigit()) stack.pop()
            else stack.push(c)
        }
        return stack.joinToString("")
    }
}