package SlidingWindow

/**
 * leetcode 1004 medium
 * 最大连续1的个数III
 */
private fun longestOnes(nums: IntArray, k: Int): Int {
    if (nums.size == 1) {
        return 1
    }
    var maxLength = 0
    var zeroCount = 0
    var index = 0
    var preIndex = 0
    while (index < nums.size) {
        if (nums[index] != 0) {
            maxLength = maxLength.coerceAtLeast(index - preIndex + 1)
            index++
            continue
        }
        if (zeroCount == k) {
            if (nums[preIndex] == 1) {
                preIndex++
                continue
            }
            preIndex++
        } else {
            zeroCount++
        }
        maxLength = maxLength.coerceAtLeast(index - preIndex + 1)
        index++
    }
    return maxLength
}

fun main() {
    val nums = intArrayOf(1,1,1,0,0,0,1,1,1,1,0)
    print(longestOnes(nums, 2))
}