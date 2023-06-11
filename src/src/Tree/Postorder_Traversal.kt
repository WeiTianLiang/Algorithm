package Tree

import structure.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * leetcode 145 easy
 * 二叉树的后序遍历
 */
private fun postorderTraversal(root: TreeNode?): List<Int> {
    val list = arrayListOf<Int>()
    findWithStack(list, root)
    return list
}

/**
 * 栈
 */
private fun findWithStack(lis: ArrayList<Int>, root: TreeNode?) {
    root ?: return
    var tempRoot = root
    val rootStack = Stack<TreeNode>()
    var curRoot: TreeNode? = null
    while (rootStack.isNotEmpty() || tempRoot != null) {
        while (tempRoot != null) {
            rootStack.push(tempRoot)
            tempRoot = tempRoot.left
        }
        val value = rootStack.peek()
        if (value.right == null || value.right == curRoot) {
            lis.add(value.value as Int)
            rootStack.pop()
            curRoot = value
        } else {
            tempRoot = value.right
        }
    }
}

fun main() {
    val root = TreeNode(1)
    val right = TreeNode(2)
    val left = TreeNode(3)
    root.right = right
    right.left = left
    postorderTraversal(root).forEach {
        print("$it ")
    }
}