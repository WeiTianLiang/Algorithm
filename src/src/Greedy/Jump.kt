package Greedy

import kotlin.math.max

/**
 * leetcode 45 medium
 * 跳跃游戏 II
 */
fun jump(nums: IntArray): Int {
    if (nums.size == 1) {
        return 0
    }
    if (nums[0] >= nums.size - 1) {
        return 1
    }
    var times = 0
    var start = 0
    var end = 1

    while (end < nums.size) {
        var location = 0
        for (i in start until end) {
            location = max(location, i + nums[i])
        }
        start = end
        end = location + 1
        times++
    }

    return times
}

fun main() {
    val num = intArrayOf(1, 2, 3, 4)
    print(jump(num))
}