class CustomStack(val maxSize: Int) {
    val q = mutableListOf<Int>()

    fun push(x: Int) {
        if(q.size < maxSize) {
            q.add(x)
        }
    }

    fun pop(): Int {
        if(q.size > 0) {
            return q.removeLast()
        }
        return -1
    }

    fun increment(k: Int, `val`: Int) {
        val limit = Math.min(k, q.size)
        for(i in 0 until limit) {
            q[i] += `val`
        }
    }

}
