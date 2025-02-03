class CourseScheduleIV {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val res = mutableListOf<Boolean>()
        val dp = Array(numCourses) { Array(numCourses) { false } }
        for (pre in prerequisites) {
            dp[pre[0]][pre[1]] = true
        }
        for (k in 0 until numCourses) {
            for (i in 0 until numCourses) {
                for (j in 0 until numCourses) {
                    dp[i][j] = dp[i][j] || (dp[i][k] && dp[k][j])
                }
            }
        }
        for (query in queries) {
            res.add(dp[query[0]][query[1]])
        }
        return res
    }
}