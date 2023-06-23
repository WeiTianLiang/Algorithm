package Tree

import structure.TreeNode
import structure.buildTree

/**
 * leetcode 1448 medium
 * 统计二叉树中好节点的数目
 */
private var count = 0
private fun goodNodes(root: TreeNode?): Int {
    root ?: return 0
    findNum(root, root.value as Int)
    return count
}

private fun findNum(root: TreeNode?, max: Int) {
    if (root == null) {
        return
    }
    val value = root.value as Int
    var maxNum = max
    if (value >= max) {
        print(value)
        count++
        maxNum = value
    }
    findNum(root.left, maxNum)
    findNum(root.right, maxNum)
}

fun main() {
    val pre = intArrayOf(2, 4, 10, 8, 3)
    val mid = intArrayOf(2, 10, 4, 3, 8)
    val root = buildTree(pre, mid)
    print(goodNodes(root))
}