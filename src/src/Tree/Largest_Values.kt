package Tree

import structure.TreeNode
import java.util.concurrent.LinkedBlockingQueue

/**
 * 剑指OfferII 44 medium
 * 二叉树每层的最大值
 */
private fun largestValues(root: TreeNode?): List<Int> {
    val list = arrayListOf<Int>()
    root ?: return list

    list.add(root.value as Int)
    var curSize = 0
    var lastSize = 1
    val queue = LinkedBlockingQueue<TreeNode>()
    queue.put(root)
    while (true) {
        var levelMaxValue = Int.MIN_VALUE
        var i = 0
        while (i < lastSize) {
            val value = queue.poll()
            val left = value.left
            val right = value.right
            if (left != null) {
                levelMaxValue = levelMaxValue.coerceAtLeast(left.value as Int)
                curSize++
                queue.put(left)
            }
            if (right != null) {
                levelMaxValue = levelMaxValue.coerceAtLeast(right.value as Int)
                curSize++
                queue.put(right)
            }
            i++
        }
        if (curSize == 0) {
            break
        }
        lastSize = curSize
        curSize = 0
        list.add(levelMaxValue)
    }

    return list
}

fun main() {
    val root = TreeNode(-2147483648)
    val left = TreeNode(-2147483648)
    root.left = left
    largestValues(root).forEach {
        print("$it ")
    }
}