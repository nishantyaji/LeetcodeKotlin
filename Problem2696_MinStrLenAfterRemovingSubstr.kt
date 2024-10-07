import java.util.Stack

fun main() {
    val m = MinStrLenAfterRemovingSubstr()
    println(m.minLength("ABFCACDB"))
}

class MinStrLenAfterRemovingSubstr {
    fun minLength(s: String): Int {
        val stack = Stack<Char>()
        for(c in s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.add(c)
            } else {
                if((c == 'D' && stack.peek() == 'C') || (c == 'B' && stack.peek() == 'A')) {
                    stack.pop()
                } else{
                    stack.add(c)
                }
            }
        }
        return stack.size
    }
}