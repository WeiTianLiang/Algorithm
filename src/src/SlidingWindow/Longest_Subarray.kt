package SlidingWindow

/**
 * leetcode 1493 medium
 * 删掉一个元素以后全为 1 的最长子数组
 */
private fun longestSubarray(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }
    var index = 0
    var preIndex = 0
    var zeroCount = 0
    var maxLength = 0
    while (index < nums.size) {
        if (nums[index] == 0) {
            if (zeroCount != 1) {
                zeroCount++
            } else {
                if (nums[preIndex] == 0) {
                    preIndex++
                } else {
                    preIndex++
                    continue
                }
            }
        }
        maxLength = maxLength.coerceAtLeast(index - preIndex + 1 - zeroCount)
        index++
    }
    return if (maxLength == nums.size) {
        maxLength - 1
    } else {
        maxLength
    }
}

fun main() {
    val nums = intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)
    print(longestSubarray(nums))
}