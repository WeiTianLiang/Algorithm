package Tree

import structure.TreeNode
import structure.buildTree
import java.util.concurrent.LinkedBlockingQueue

/**
 * 剑指OfferII 46 medium
 * 二叉树的右侧视图
 */
private fun rightSideView(root: TreeNode?): List<Int> {
    val resultList = arrayListOf<Int>()
    root ?: return resultList

    val rootQueue = LinkedBlockingQueue<TreeNode?>()
    rootQueue.put(root)
    resultList.add(root.value as Int)
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
        resultList.add(list[list.size - 1])
        list.clear()
    }

    return resultList
}

fun main() {
    val pre = intArrayOf(1, 2, 5, 3, 4)
    val mid = intArrayOf(2, 5, 1, 3, 4)
    val root = buildTree(pre, mid)
    rightSideView(root).forEach {
        print("$it ")
    }
}