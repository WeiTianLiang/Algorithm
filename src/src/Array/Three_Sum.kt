package Array

import java.util.Arrays

/**
 * leetcode 15 medium
 * 三数之和
 */
private fun threeSum(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<List<Int>>()
    Arrays.sort(nums)
    for (first in nums.indices) {
        if (first > 0 && nums[first] == nums[first - 1]) {
            continue
        }
        val target = -nums[first]
        var second = first + 1
        var third = nums.size - 1
        while (second < third) {
            if (second > first + 1 && nums[second] == nums[second - 1]) {
                second++
                continue
            }
            if (nums[second] + nums[third] < target) {
                second++
            } else if (nums[second] + nums[third] > target) {
                third--
            } else {
                val tempList = arrayListOf<Int>()
                tempList.add(nums[first])
                tempList.add(nums[second])
                tempList.add(nums[third])
                result.add(tempList)
                second++
            }
        }
    }
    return result
}

fun main() {
    threeSum(intArrayOf(-1,0,1,2,-1,-4)).forEach {
        it.forEach { value ->
            print("$value ")
        }
        println()
    }
}