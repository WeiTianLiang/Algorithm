package DoublePointer

import kotlin.math.min

/**
 * leetcode 11 medium
 * 盛最多水的容器
 */
private fun maxArea(height: IntArray): Int {
    var maxArea = 0
    var startIndex = 0
    var endIndex = height.size - 1
    while (startIndex < endIndex) {
        maxArea = maxArea.coerceAtLeast(calculateArea(height, startIndex, endIndex))
        if (height[startIndex] <= height[endIndex]) {
            startIndex++
        } else {
            endIndex--
        }
    }
    return maxArea
}

private fun calculateArea(height: IntArray, index1: Int, index2: Int): Int {
    if (index1 >= index2) {
        return 0
    }
    val x = index2 - index1
    val y = min(height[index1], height[index2])
    return x * y
}

fun main() {
    val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    print(maxArea(height))
}