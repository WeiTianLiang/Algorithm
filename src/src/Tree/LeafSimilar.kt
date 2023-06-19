package Tree

import structure.TreeNode
import structure.buildTree

/**
 * leetcode 872 medium
 * 叶子相似的树
 */
private fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val str1 = find(root1, StringBuilder())
    val str2 = find(root2, StringBuilder())
    return str1.toString() == str2.toString()
}

private fun find(root: TreeNode?, str: StringBuilder): StringBuilder {
    if (root == null) {
        return str
    }
    if (root.left == null && root.right == null) {
        str.append(root.value).append(".")
    }
    find(root.left, str)
    find(root.right, str)
    return str
}

fun main() {
    val pre1 = intArrayOf(3, 5, 6, 2, 7, 4, 1, 9, 8)
    val mid1 = intArrayOf(6, 5, 7, 2, 4, 3, 9, 1, 8)
//    val pre1 = intArrayOf(1, 2, 3)
//    val mid1 = intArrayOf(2, 1, 3)
    val root1 = buildTree(pre1, mid1)

    val pre2 = intArrayOf(3, 5, 6, 7, 1, 4, 2, 9, 8)
    val mid2 = intArrayOf(6, 5, 7, 3, 4, 1, 9, 2, 8)
//    val pre2 = intArrayOf(1, 3, 2)
//    val mid2 = intArrayOf(3, 1, 2)
    val root2 = buildTree(pre2, mid2)

    print(leafSimilar(root1, root2))
}