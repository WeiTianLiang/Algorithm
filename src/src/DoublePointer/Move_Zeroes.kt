package DoublePointer

/**
 * leetcode 283 easy
 * 移动零
 */
private fun moveZeroes(nums: IntArray) {
    if (nums.isEmpty() || nums.size == 1) {
        return
    }
    var index = 0
    var j = 0
    var zeroCount = 0
    while (index < nums.size) {
        if (nums[index] == 0) {
            zeroCount++
        } else {
            nums[j] = nums[index]
            j++
        }
        index++
    }
    for (i in j until nums.size) {
        nums[i] = 0
    }
}

fun main() {
    val arr = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(arr)
    arr.forEach {
        print("$it ")
    }
}