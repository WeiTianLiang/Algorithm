package Tree

import structure.TreeNode
import structure.buildTree
import java.util.concurrent.LinkedBlockingQueue

/**
 * 剑指OfferII 45 medium
 * 二叉树最底层最左边的值
 */
private fun findBottomLeftValue(root: TreeNode?): Int {
    root ?: return 0
    val rootQueue = LinkedBlockingQueue<TreeNode?>()
    rootQueue.put(root)
    var result = root.value as Int
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
        result = list[0]
        list.clear()
    }
    return result
}

fun main() {
    val pre = intArrayOf(1, 2, 4, 3, 5, 7, 6)
    val mid = intArrayOf(4, 2, 1, 7, 5, 3, 6)
    val root = buildTree(pre, mid)
    print(findBottomLeftValue(root))
}