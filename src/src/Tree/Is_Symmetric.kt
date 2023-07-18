package Tree

import structure.TreeNode
import structure.buildTree
import structure.changeTree

/**
 * leetcode 101 easy
 * 对称二叉树
 */
private fun isSymmetric(root: TreeNode?): Boolean {
    root ?: return true
    return merge(root.left, root.right)
}

private fun merge(rootLeft: TreeNode?, rootRight: TreeNode?): Boolean {
    if (rootLeft == null && rootRight == null) {
        return true
    }
    if (rootLeft == null || rootRight == null) {
        return false
    }
    if (rootLeft.value != rootRight.value) {
        return false
    }
    return merge(rootLeft.left, rootRight.right) && merge(rootLeft.right, rootRight.left)
}

fun main() {
    val map = mutableMapOf<Int, Int>()
    map[0] = 1
    map[1] = 2
    map[2] = 3
    map[3] = 4
    map[4] = 2
    map[5] = 4
    map[6] = 3
    val preorder = intArrayOf(0, 1, 2, 3, 4, 5, 6)
    val inorder = intArrayOf(2, 1, 3, 0, 5, 4, 6)
    val root = buildTree(preorder, inorder)
    changeTree(root, map)
    print(isSymmetric(root))
}