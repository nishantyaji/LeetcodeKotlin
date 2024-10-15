fun main() {
    val k = KthSmallestInstructions()
    println(k.kthSmallestPath(intArrayOf(2, 3), 1))
    println(k.kthSmallestPath(intArrayOf(2, 3), 2))
    println(k.kthSmallestPath(intArrayOf(2, 3), 3))
}

class KthSmallestInstructions {
    fun kthSmallestPath(destination: IntArray, k: Int): String {
        return recurse(destination[0], destination[1], k.toLong())
    }

    fun recurse(r: Int, c: Int, k: Long): String {
        if (c == 0) {
            var temp = ""
            for (i in 0 until r) temp += "V"
            return temp
        } else if (r == 0) {
            var temp = ""
            for (i in 0 until c) temp += "H"
            return temp
        }
        var limit: Long = 1
        for (i in 1 until c) {
            limit = (limit * (r + i)) / i
        }
        if (k > limit) {
            return "V" + recurse(r - 1, c, k - limit)
        } else {
            return "H" + recurse(r, c - 1, k)
        }
    }
}