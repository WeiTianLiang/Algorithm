package Tree

import structure.TreeNode
import structure.buildTree

/**
 * leetcode 104 easy
 * 二叉树的最大深度
 */
private fun maxDepth(root: TreeNode?): Int {
    root ?: return 0
    return maxDepth(root.left).coerceAtLeast(maxDepth(root.right)) + 1
}

fun main() {
    val pre = intArrayOf(3, 9, 20, 15, 7)
    val mid = intArrayOf(9, 3, 15, 20, 7)
    val root = buildTree(pre, mid)
    print(maxDepth(root))
}