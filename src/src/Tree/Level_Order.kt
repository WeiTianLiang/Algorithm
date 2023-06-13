package Tree

import structure.TreeNode
import structure.buildTree
import java.util.concurrent.LinkedBlockingQueue

/**
 * leetcode 102 medium
 * 二叉树的层序遍历
 */
private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val resultList = arrayListOf<ArrayList<Int>>()
    root ?: return resultList

    val rootQueue = LinkedBlockingQueue<TreeNode?>()
    rootQueue.put(root)
    resultList.add(arrayListOf(root.value as Int))
    var lastSize = 1
    var curSize = 0
    while (true) {
        val list = arrayListOf<Int>()
        var i = 0
        while (i < lastSize) {
            val value = rootQueue.poll()
            val leftValue = value?.left
            val rightValue = value?.right
            if (leftValue != null) {
                list.add(leftValue.value as Int)
                rootQueue.put(leftValue)
                curSize++
            }
            if (rightValue != null) {
                list.add(rightValue.value as Int)
                rootQueue.put(rightValue)
                curSize++
            }
            i++
        }
        if (curSize == 0) {
            break
        }
        lastSize = curSize
        curSize = 0
        val cloneList = arrayListOf<Int>()
        list.forEach {
            cloneList.add(it)
        }
        resultList.addAll(listOf(cloneList))
        list.clear()
    }

    return resultList
}

fun main() {
    val pre = intArrayOf(3, 9, 20, 15, 7)
    val mid = intArrayOf(9, 3, 15, 20, 7)
    val root = buildTree(pre, mid)
    val list = levelOrder(root)
    list.forEach {
        it.forEach { value ->
            print("$value ")
        }
        println()
    }
}