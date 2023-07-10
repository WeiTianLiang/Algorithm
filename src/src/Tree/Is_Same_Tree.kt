package Tree

import structure.TreeNode
import structure.buildTree

/**
 * leetcode 100 easy
 * 相同的树
 */
private var isSame = true
private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    merge(p, q)
    return isSame
}

private fun merge(p: TreeNode?, q: TreeNode?) {
    if (p == null && q == null) {
        return
    }
    if (p?.value != q?.value) {
        isSame = false
    }
    merge(p?.left, q?.left)
    merge(p?.right, q?.right)
}

fun main() {
    val pre = intArrayOf(1, 2)
    val mid = intArrayOf(2, 1)
    val root1 = buildTree(pre, mid)
    val pre1 = intArrayOf(1, 2)
    val mid1 = intArrayOf(1, 2)
    val root2 = buildTree(pre1, mid1)
    print(isSameTree(root1, root2))
}