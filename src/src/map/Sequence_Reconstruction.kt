package map

import java.util.Stack
import kotlin.math.max

/**
 * 剑指offerII 115 medium
 * 重建序列
 */
private fun sequenceReconstruction(nums: IntArray, sequences: Array<IntArray>): Boolean {
    // 建图
    val map = mutableMapOf<Int, ArrayList<Int>>()
    sequences.forEach {
        var i = 0
        while (i < it.size - 1) {
            var list = map[it[i]]
            if (list == null) {
                list = arrayListOf()
                map[it[i]] = list
            }
            list.add(nums[i + 1])
            i++
        }
    }

    // 寻找根节点, 统计各节点对应的数量
    val rootStack = Stack<Int>()
    val countMap = mutableMapOf<Int, Int>()
    map.forEach(action = {
        if (it.value.size == 0) {
            rootStack.push(it.key)
        } else {
            countMap[it.key] = it.value.size
        }
    })

    // 深度遍历有向图
    var maxDepth = 0
    var depth = 0
    // 用于遍历的栈
    val loopStack = Stack<Int>()
    while (true) {
        if (loopStack.isEmpty()) {
            // 添加根节点
            maxDepth = maxDepth.coerceAtLeast(depth)
            depth = 0
            if (rootStack.isEmpty()) {
                break
            }
            loopStack.push(rootStack.pop())
        }
        val key = loopStack.pop()
        depth++
        map.forEach(action = {
            if (key == it.key && countMap[key] != 0) {
                loopStack.push(it.value[it.value.size - countMap[key]!!])
            }
        })
    }
    print("maxDepth : $maxDepth    ")

    return maxDepth == nums.size
}

fun main() {
    val nums = intArrayOf(1, 4, 2, 3)
    val sequences = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(4, 2)
    )
    print(sequenceReconstruction(nums, sequences))
}