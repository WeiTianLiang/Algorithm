package Tree

import structure.TreeNode
import structure.buildTree
import kotlin.text.StringBuilder

/**
 * 剑指OfferII 49 medium
 * 从根节点到叶节点的路径数字之和
 */
private fun sumNumbers(root: TreeNode?): Int {
    root ?: return 0
    if (root.left == null && root.right == null) {
        return root.value as Int
    }
    sum(root, StringBuilder())
    return sum
}

private var sum = 0

private fun sum(root: TreeNode?, tempNumber: StringBuilder) {
    if (root == null) {
        return
    }
    tempNumber.append(root.value)
    if (root.left == null && root.right == null) {
        sum = sum.plus(tempNumber.toString().toInt())
    }
    sum(root.left, tempNumber)
    sum(root.right, tempNumber)
    tempNumber.delete(tempNumber.lastIndex, tempNumber.length)
}

fun main() {
    val pre = intArrayOf(4, 9, 1, 0)
    val mid = intArrayOf(9, 1, 4, 0)
    val root = buildTree(pre, mid)
    print(sumNumbers(root))
}