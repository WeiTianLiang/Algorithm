package Tree

import structure.TreeNode
import structure.buildTree
import java.util.*
import kotlin.collections.ArrayList

/**
 * leetcode 144 easy
 * 二叉树的前序遍历
 */
private fun preorderTraversal(root: TreeNode?): List<Int> {
    val list = arrayListOf<Int>()
    findWithStack(list, root)
    return list
}

/**
 * 递归
 */
private fun find(lis: ArrayList<Int>, root: TreeNode?) {
    root ?: return
    lis.add(root.value as Int)
    find(lis, root.left)
    find(lis, root.right)
}

/**
 * 栈
 */
private fun findWithStack(lis: ArrayList<Int>, root: TreeNode?) {
    root ?: return
    var tempRoot = root
    val rootStack = Stack<TreeNode>()
    while (rootStack.isNotEmpty() || tempRoot != null) {
        while (tempRoot != null) {
            lis.add(tempRoot.value as Int)
            rootStack.push(tempRoot)
            tempRoot = tempRoot.left
        }
        tempRoot = rootStack.pop()
        tempRoot = tempRoot.right
    }
}

fun main() {
    val preorder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)
    val root = buildTree(preorder, inorder)
    preorderTraversal(root).forEach {
        print("$it ")
    }
}