fun main() {
    val p = CountServersThatCommunicate()
    println(p.countServers(arrayOf(intArrayOf(1, 0), intArrayOf(1, 1))))
}

class CountServersThatCommunicate {

    fun countServers(grid: Array<IntArray>): Int {
        val rowLen = grid.size
        val colLen = grid[0].size
        val rowFlag = IntArray(rowLen)
        val colFlag = IntArray(colLen)
        var total = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    rowFlag[i]++
                    colFlag[j]++
                    total++
                }
            }
        }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1 && rowFlag[i] == 1 && colFlag[j] == 1) {
                    total--
                }
            }
        }
        return total
    }
}