fun main() {
    val c = CheckIfNAndItsDoubleExist()
    println(c.checkIfExist(intArrayOf(10,2,5,3)))
}

class CheckIfNAndItsDoubleExist {
    fun checkIfExist(arr: IntArray): Boolean {
        var numZeros = 0
        val st = mutableSetOf<Int>()
        for(a in arr) {
            if(a == 0) numZeros++
            else st.add(a)
        }
        for(a in arr) {
            if(2 * a in st) return true
        }
        return numZeros > 1
    }
}