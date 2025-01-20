fun main() {
    val f = FirstCompletelyPaintedRowOrColumn()
    println(f.firstCompleteIndex(intArrayOf(1, 3, 4, 2), arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))
}

class FirstCompletelyPaintedRowOrColumn {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val rowColumn = IntArray(mat.size) { mat[0].size }
        val colColumn = IntArray(mat[0].size) { mat.size }
        val rowLabel = IntArray(arr.size) { 0 }
        val colLabel = IntArray(arr.size) { 0 }
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                rowLabel[mat[i][j] - 1] = i
                colLabel[mat[i][j] - 1] = j
            }
        }
        for ((i, x) in arr.withIndex()) {
            rowColumn[rowLabel[x - 1]]--
            colColumn[colLabel[x - 1]]--
            if (rowColumn[rowLabel[x - 1]] == 0 || colColumn[colLabel[x - 1]] == 0) {
                return i
            }
        }
        return (mat.size * mat[0].size) - 1
    }
}