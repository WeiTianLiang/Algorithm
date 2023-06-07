package DoublePointer

import java.util.*

/**
 * leetcode 1679 medium
 * K 和数对的最大数目
 */
private fun maxOperations(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var startIndex = 0
    var endIndex = nums.size - 1
    var times = 0
    while (startIndex < endIndex) {
        if (nums[startIndex] + nums[endIndex] < k) {
            startIndex++
        } else if (nums[startIndex] + nums[endIndex] > k) {
            endIndex--
        } else {
            times++
            startIndex++
            endIndex--
        }
    }
    return times
}

fun main() {
    val nums = intArrayOf(3, 1, 3, 4, 3)
    print(maxOperations(nums, 6))
}