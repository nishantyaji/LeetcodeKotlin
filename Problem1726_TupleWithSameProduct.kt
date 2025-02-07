class TupleWithSameProduct {

    fun tupleSameProduct(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for(i in nums.indices){
            for(j in i+1 until nums.size){
                val prod = nums[i] * nums[j]
                map.computeIfAbsent(prod){0}  // Note
                map[prod] = map[prod]!! + 1
            }
        }

        var res = 0
        for((_, v) in map){   // Note
            if(v > 1){
                res += 4 * v * (v-1)
            }
        }
        return res
    }
}