package Array

/**
 * leetcode 26 medium
 * 删除有序数组中的重复项
 */
private fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty() || nums.size == 1) {
        return nums.size
    }
    var pre = 0
    var cur = 1
    while (cur < nums.size) {
        if (nums[cur] == nums[pre]) {
            cur++
        } else {
            nums[pre + 1] = nums[cur]
            pre++
        }
    }
    return pre + 1
}

fun main() {
    print(removeDuplicates(intArrayOf(1, 1, 2)))
    println()
    print(removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4)))
    println()
    print(removeDuplicates(intArrayOf(1)))
    println()
    print(removeDuplicates(intArrayOf()))
}