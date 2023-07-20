package Tree

import structure.TreeNode
import structure.buildTree
import structure.changeTree
import structure.prePrint

/**
 * 剑指 Offer II 47 medium
 * 二叉树剪枝
 */
private fun pruneTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    root.left = pruneTree(root.left)
    root.right = pruneTree(root.right)
    if (root.left == null && root.right == null && root.value == 0) {
        return null
    }
    return root
}

fun main() {
    val map = mutableMapOf<Int, Int>()
    map[0] = 1
    map[1] = 1
    map[2] = 1
    map[3] = 0
    map[4] = 1
    map[5] = 0
    map[6] = 0
    map[7] = 1
    val preorder = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7)
    val inorder = intArrayOf(3, 2, 1, 4, 0, 6, 5, 7)
    val root = buildTree(preorder, inorder)
    changeTree(root, map)
    val temp = pruneTree(root)
    temp.prePrint()
}