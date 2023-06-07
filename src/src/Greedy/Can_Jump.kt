package Greedy

/**
 * leetcode 55 medium
 * 跳跃游戏
 */
private fun canJump(nums: IntArray): Boolean {
    val length = nums.size
    if (nums[0] == 0 && nums.size > 1) {
        return false
    }
    if (nums.size == 1) {
        return true
    }
    if (nums[0] == length - 1) {
        return true
    }
    var maxFar = nums[0]
    for (i in 1 until length) {
        if (i <= maxFar && i + nums[i] > maxFar) {
            maxFar = nums[i] + i
        }
    }
    return maxFar >= length - 1
}

fun main() {
    val num = intArrayOf(3, 2, 1, 0, 4)
    print(canJump(num))
}