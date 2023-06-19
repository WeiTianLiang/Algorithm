package Tree

import structure.TreeNode
import structure.buildTree
import java.util.concurrent.LinkedBlockingQueue

/**
 * leetcode 1161 medium
 * 最大层内元素和
 */
private fun maxLevelSum(root: TreeNode?): Int {
    root ?: return 0

    val queue = LinkedBlockingQueue<TreeNode>()
    queue.put(root)
    var size = 0
    var lastSize = 1

    var maxSum = Int.MIN_VALUE
    var resultLevel = 0
    var tempLevel = 1

    val list = arrayListOf<Int>()
    list.add(root.value as Int)
    val listSum = list.sum()
    if (maxSum < listSum) {
        resultLevel = tempLevel
        maxSum = listSum
    }

    while (true) {
        var index = 0
        list.clear()
        while (index < lastSize) {
            val tempRoot = queue.poll()
            if (tempRoot.left != null) {
                queue.put(tempRoot.left!!)
                list.add(tempRoot.left!!.value as Int)
                size++
            }
            if (tempRoot.right != null) {
                queue.put(tempRoot.right!!)
                list.add(tempRoot.right!!.value as Int)
                size++
            }
            index++
        }
        if (size == 0) {
            break
        }
        val listSumNumber = list.sum()
        tempLevel++
        if (maxSum < listSumNumber) {
            resultLevel = tempLevel
            maxSum = listSumNumber
        }
        lastSize = size
        size = 0
    }

    return resultLevel
}

private fun ArrayList<Int>.sum(): Int {
    var sum = 0
    for (i in this) {
        sum += i
    }
    return sum
}

fun main() {
//    val pre = intArrayOf(1, 7, 6, -8, 0)
//    val mid = intArrayOf(6, 7, -8, 1, 0)
    val pre = intArrayOf(-100, -200, -20, -5, -300, -10)
    val mid = intArrayOf(-20, -200, -5, -100, -10, -300)
//    val pre = intArrayOf(1)
//    val mid = intArrayOf(1)
//    val pre = intArrayOf(989, 10250, 98693, -89388, -32127)
//    val mid = intArrayOf(989, 98693, 10250, -89388, -32127)
    val root = buildTree(pre, mid)
    print(maxLevelSum(root))
}