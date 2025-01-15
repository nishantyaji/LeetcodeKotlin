import java.util.*

fun main() {
    val m = MinimizeXOR()
    println(m.minimizeXor(3, 5))  //3
    println(m.minimizeXor(1, 12))  // 3
}

class MinimizeXOR {

    fun minimizeXor(num1: Int, num2: Int): Int {
        val len1 = num1.toString(2).length
        val ones2 = num2.toString(2).map { it.toString().toInt() }.sum()

        var res = 0
        var base = Math.pow(2.toDouble(), (len1-1).toDouble()).toInt()
        var newBase = Math.pow(2.toDouble(), len1.toDouble()).toInt()
        var i = 0
        val stack = Stack<Int>()
        while(i < ones2 && base > 0){
            if((num1 and base) > 0){
                res = res or base
                i++
            } else{
                stack.push(base)
            }
            base = base shr 1
        }
        while(i < ones2){
            if(stack.isNotEmpty()) res = res or stack.pop()
            else {
                res = res or newBase
                newBase = newBase shl 1
            }
            i++
        }
        return res
    }
}