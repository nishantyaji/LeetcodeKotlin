class MinRecolorsToGetKConsecutiveBlackBlocks {

    fun minimumRecolors(blocks: String, k: Int): Int {
        val arr = blocks.toCharArray().map { if (it == 'B') 1 else 0 }
        var window = arr.subList(0, k).sum()
        var res = window
        for(i in k until arr.size) {
            window = window + arr[i] - arr[i - k]
            res = maxOf(res, window)
        }
        return k - res
    }
}