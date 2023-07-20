package Tree

import structure.TreeNode
import structure.buildTree
import structure.prePrint

/**
 * 剑指OfferII 54 medium
 * 所有大于等于节点的值之和
 */
private var sum = 0
private fun convertBST(root: TreeNode?): TreeNode? {
    root ?: return null
    change(root)
    return root
}

private fun change(root: TreeNode?) {
    root ?: return
    change(root.right)
    sum += root.value as Int
    root.value = sum
    change(root.left)
}

fun main() {
    val pre = intArrayOf(4, 1, 0, 2, 3, 6, 5, 7, 8)
    val mid = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
    val root = buildTree(pre, mid)
    val newRoot = convertBST(root)
    newRoot.prePrint()
}