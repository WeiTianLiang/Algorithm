package Tree

import structure.TreeNode
import structure.buildTree

/**
 * leetcode 662 medium
 * 二叉树最大宽度
 */
private fun widthOfBinaryTree(root: TreeNode?): Int {
    root ?: return 0
    var list = arrayListOf<Pair<TreeNode?, Int>>()
    list.add(Pair(root, 1))
    var maxWidth = 1
    while (list.isNotEmpty()) {
        val temp = arrayListOf<Pair<TreeNode?, Int>>()
        list.forEach {
            val node = it.first
            val index = it.second
            if (node?.left != null) {
                temp.add(Pair(node.left, 2 * index))
            }
            if (node?.right != null) {
                temp.add(Pair(node.right, 2 * index + 1))
            }
        }
        if (temp.isEmpty()) {
            break
        }
        maxWidth = maxWidth.coerceAtLeast(temp.last().second - temp.first().second + 1)
        list = temp
    }
    return maxWidth
}

fun main() {
    val pre = intArrayOf(1, 3, 5, 6, 2, 9, 7)
    val mid = intArrayOf(6, 5, 3, 1, 2, 7, 9)
    val root = buildTree(pre, mid)
    print(widthOfBinaryTree(root))
}