import java.util.*

fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ReverseOddLevelsOfBinTree {
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        val mp = mutableMapOf<Int, Deque<Int>>()
        if (root != null) {
            recurse(root, mp, 0)
            assign(root, mp, 0)
        }
        return root
    }

    fun recurse(node: TreeNode, mp: MutableMap<Int, Deque<Int>>, depth: Int) {
        if (depth !in mp) mp[depth] = LinkedList<Int>()
        mp[depth]?.add(node.`val`)
        if (node.left != null) recurse(node.left!!, mp, depth + 1)
        if (node.right != null) recurse(node.right!!, mp, depth + 1)
    }

    fun assign(node: TreeNode, mp: Map<Int, Deque<Int>>, depth: Int) {
        node.`val` = if (depth % 2 == 1) mp[depth]!!.pollLast() else mp[depth]!!.pollFirst()
        if (node.left != null) assign(node.left!!, mp, depth + 1)
        if (node.right != null) assign(node.right!!, mp, depth + 1)
    }
}