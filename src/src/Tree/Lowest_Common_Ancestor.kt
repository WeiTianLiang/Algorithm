package Tree

import structure.TreeNode
import structure.buildTree
import structure.findByValue

/**
 * leetcode 236 medium
 * 二叉树的最近公共祖先
 */
private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    root ?: return null
    p ?: return null
    q ?: return null
    if (root == p || root == q) {
        return root
    }
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)
    if (left == null) {
        return right
    }
    if (right == null) {
        return left
    }
    return root
}

fun main() {
    val pre1 = intArrayOf(3, 5, 6, 2, 7, 4, 1, 0, 8)
    val mid1 = intArrayOf(6, 5, 7, 2, 4, 3, 0, 1, 8)
    val root1 = buildTree(pre1, mid1)
    val p = findByValue(root1, 5)
    val q = findByValue(root1, 1)
    val result = lowestCommonAncestor(root1, p, q)
    print(result?.value)
}