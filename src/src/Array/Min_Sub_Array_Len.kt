package Array

/**
 * 剑指 OfferII 8 medium
 * 和大于等于 target 的最短子数组
 */
private fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var minSize = 0

    var curIndex = 0
    var preIndex = 0

    var sum = 0
    while (preIndex < nums.size) {
        sum += nums[preIndex]
        if (sum >= target) {
            minSize = if (minSize == 0) {
                preIndex - curIndex + 1
            } else {
                minSize.coerceAtMost(preIndex - curIndex + 1)
            }
            curIndex++
            preIndex = curIndex
            sum = 0
        } else {
            preIndex++
        }
    }

    return minSize
}

fun main() {
    print(minSubArrayLen(4, intArrayOf(1,4,4)))
}