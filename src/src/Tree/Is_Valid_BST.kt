package Tree

import structure.TreeNode

/**
 * leetcode 98 medium
 * 验证二叉搜索树
 */
private var pre = Long.MIN_VALUE
private fun isValidBST(root: TreeNode?): Boolean {
    root ?: return true

    if (!isValidBST(root.left)) {
        return false
    }

    if (root.value as Int <= pre) {
        return false
    }

    pre = (root.value as Int).toLong()

    return isValidBST(root.right)
}
fun main() {
    val pre = intArrayOf(2, 1, 3)
    val mid = intArrayOf(1, 2, 3)
//    print(isValidBST(buildTree(pre, mid)))

    println()

    val pre1 = intArrayOf(5, 1, 4, 3, 6)
    val mid1 = intArrayOf(1, 5, 3, 4, 6)
//    print(isValidBST(buildTree(pre1, mid1)))

    println()

    val root = TreeNode(-2147483648)
    print(isValidBST(root))

    println()

    val pre2 = intArrayOf(5, 4, 6, 3, 7)
    val mid2 = intArrayOf(4, 5, 3, 6, 7)
//    print(isValidBST(buildTree(pre2, mid2)))
}