import java.util.TreeSet

fun main() {
    val n = NumSmallestOccupiedChair()
    println(n.smallestChair(arrayOf(intArrayOf(1,4), intArrayOf(2,3), intArrayOf(4,6)), 1))
    println(n.smallestChair(arrayOf(intArrayOf(3,10), intArrayOf(1,5), intArrayOf(2,6)), 0))

    println(n.smallestChair(arrayOf(
        intArrayOf(33889,98676),
        intArrayOf(80071,89737),
        intArrayOf(44118,52565),
        intArrayOf(52992,84310),
        intArrayOf(78492,88209),
        intArrayOf(21695,67063),
        intArrayOf(84622,95452),
        intArrayOf(98048,98856),
        intArrayOf(98411,99433),
        intArrayOf(55333,56548),
        intArrayOf(65375,88566),
        intArrayOf(55011,62821),
        intArrayOf(48548,48656),
        intArrayOf(87396,94825),
        intArrayOf(55273,81868),
        intArrayOf(75629,91467)), 6
    ))
}

class NumSmallestOccupiedChair {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val timeline = mutableListOf<Triple<Int, Int, Boolean>>()
        times.mapIndexed { index, arrAndDep -> timeline.add(Triple(arrAndDep[0], index, true)); timeline.add(Triple(arrAndDep[1], index, false))}
        timeline.sortBy { (t, _, a) -> 10 * t + (if(a) 1 else 0) }
        val unoccupied = TreeSet<Int>((IntArray(times.size){it}).toSet())
        val seat = mutableMapOf<Int, Int>()
        for((_, friend, isArrive) in timeline) {
            if(isArrive){
                seat[friend] = unoccupied.pollFirst()!!
                if(friend == targetFriend) {
                    return seat.getOrDefault(friend, Int.MAX_VALUE)
                }
            } else{
                unoccupied.add(seat.remove(friend)!!)
            }
        }
        return -1
    }
}