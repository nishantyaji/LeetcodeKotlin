import java.util.Stack

fun main() {
    val c = ConstructStringWithRepeatLimit()
    println(c.repeatLimitedString("cczazcc", 3))
    println(c.repeatLimitedString("aababab", 2))
    println(c.repeatLimitedString("cccccccccc", 3))
}

class ConstructStringWithRepeatLimit {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val a = 'a'
        val arr = IntArray(26)
        s.toCharArray().forEach { c -> arr[c.code-a.code]++ }
        val l = arr.mapIndexed { index, i -> Pair<Char, Int>((a.code + index).toChar(), i) }.filter { p -> p.second > 0 }.toList()
        val stack = Stack<Pair<Char, Int>>()
        stack.addAll(l)

        val builder: StringBuilder = StringBuilder()  // stringbuilder is faster than simple add s += "a"
        var count = 0
        for(x in 0 until s.length) {
            if(count == repeatLimit) {
                val large = stack.pop()
                if(!stack.isEmpty()) {
                    builder.append(stack.peek().first)
                    if(stack.peek().second == 1) {
                        stack.pop()
                    }else{
                        stack.set(stack.size-1, Pair(stack.peek().first, stack.peek().second-1))
                    }
                    count = 0
                }else{
                    break
                }
                stack.add(large)
            } else{
                val large = stack.peek()
                builder.append(large.first)
                if(large.second > 1) {
                    count++
                    stack.set(stack.size-1, Pair(stack.peek().first, stack.peek().second-1))
                } else{
                    stack.pop()
                    count = 0
                }
            }
        }
        return builder.toString()
    }
}