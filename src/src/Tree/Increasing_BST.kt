package Tree

import structure.TreeNode
import structure.buildTree

/**
 * 剑指OfferII 52 easy
 * 展平二叉搜索树
 */
private fun increasingBST(root: TreeNode?): TreeNode? {
    root ?: return null
    val list = arrayListOf<Int>()
    var tempRoot = TreeNode(-1)
    val newRoot = tempRoot
    mid(root, list)
    list.forEach {
        tempRoot.right = TreeNode(it)
        tempRoot = tempRoot.right!!
    }
    return newRoot.right
}

private fun mid(root: TreeNode?, list: ArrayList<Int>) {
    root ?: return
    mid(root.left, list)
    list.add(root.value as Int)
    mid(root.right, list)
}

fun main() {
    val pre = intArrayOf(5, 3, 2, 1, 4, 6, 7, 8, 9)
    val mid = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val root = buildTree(pre, mid)
    var head = increasingBST(root)
    while (head != null) {
        print("${head.value} ")
        head = head.right
    }
}