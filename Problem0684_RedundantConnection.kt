import kotlin.math.max

class RedundantConnection {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        var mx = -1
        for(i in edges.indices) {
            mx = max(edges[i][0], mx)
            mx = max(edges[i][1], mx)
        }
        val dsu = DSU(mx+1)
        val set = mutableSetOf<Int>()
        val res = IntArray(2){-1}
        for(edge in edges){
            if(edge[0] in set && edge[1] in set && dsu.find(edge[0]) == dsu.find(edge[1])){
                res[0] = edge[0]
                res[1] = edge[1]
            } else{
                set.add(edge[0])
                set.add(edge[1])
                dsu.union(edge[0], edge[1])
            }
        }
        return res
    }

}


class DSU(len: Int) {
    private val parent = IntArray(len){it}
    private val size = IntArray(len){1}

    fun find(i: Int): Int{
        if(parent[i] != i) parent[i] = find(parent[i])
        return parent[i]
    }

    fun union(i: Int, j: Int) {
        val iPar = find(i)
        val jPar = find(j)
        if(iPar == jPar){
            return
        }

        val iSize = size[i]
        val jSize = size[j]
        if(iSize < jSize) {
            parent[iPar] = jPar
            size[jPar] += size[iPar]
        } else{
            parent[jPar] = iPar
            size[iPar] += size[jPar]
        }
    }
}