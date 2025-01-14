fun main() {
    val f = FindPrefixCommonArrayOfTwoArrays()
    println(f.findThePrefixCommonArray(intArrayOf(1,3,2,4), intArrayOf(3,1,2,4)).contentToString()) // [0,2,3,4]
}

class FindPrefixCommonArrayOfTwoArrays {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val aSet = mutableSetOf<Int>()
        val bSet = mutableSetOf<Int>()
        val res = IntArray(A.size)
        res[A.size - 1] = A.size
        for(i in A.size - 1 downTo 1) {
            if(A[i] in bSet && B[i] in aSet) res[i-1] = res[i]
            else if(A[i] == B[i] || A[i] in bSet || B[i] in aSet) res[i-1] = res[i] - 1
            else res[i-1] = res[i] - 2
            aSet.add(A[i])
            bSet.add(B[i])
        }
        return res
    }
}