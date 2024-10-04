fun main() {
    val d = DividePlayersIntoTeamsOfEqSkill()
    println(d.dividePlayers(intArrayOf(3, 2, 5, 1, 3, 4)))
    println(d.dividePlayers(intArrayOf(3, 4)))
    println(d.dividePlayers(intArrayOf(1, 1, 2, 3)))
}

class DividePlayersIntoTeamsOfEqSkill {
    fun dividePlayers(skill: IntArray): Long {
        val allSum = skill.sum()
        val numPairs = skill.size / 2
        if (allSum % numPairs > 0) {
            return -1
        }

        val target = allSum / numPairs
        val counter = mutableMapOf<Int, Long>()
        skill.map { i -> counter[i] = counter.getOrDefault(i, 0) + 1 }

        val exclude = if (target % 2 == 1) setOf() else setOf(target / 2)
        for (x in skill) {
            if ((x in exclude && counter.getOrDefault(x, 0) % 2 == 1.toLong())
                || (x !in exclude && counter[x] != counter[target - x])) {
                return -1
            }
        }
        // Can reduce the following loop iterations by half
        return IntArray(skill.size).mapIndexed { i, _ -> skill[i] * (target - skill[i]).toLong() }.sum() / 2
    }
}