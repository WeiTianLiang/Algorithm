package SlidingWindow

/**
 * leetcode 643 easy
 * 子数组最大平均数 I
 */
private fun findMaxAverage(nums: IntArray, k: Int): Double {
    if (nums.size == 1) {
        return nums[0].toDouble()
    }
    var maxValue = calculateAll(nums, 0, k - 1)
    var secondIndex = k
    var oldFirstIndex = 0
    var value = maxValue

    while (secondIndex < nums.size) {
        value = value - nums[oldFirstIndex] + nums[secondIndex]
        maxValue = maxValue.coerceAtLeast(value)
        oldFirstIndex++
        secondIndex++
    }
    return maxValue / k
}

private fun calculateAll(nums: IntArray, firstIndex: Int, secondIndex: Int): Double {
    var all = 0.0
    for (i in firstIndex..secondIndex) {
        all += nums[i]
    }
    return all
}

fun main() {
    val nums = intArrayOf(0, 4, 0, 3, 2)
    print(findMaxAverage(nums, 1))
}