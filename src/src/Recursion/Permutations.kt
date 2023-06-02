package Recursion

/**
 * leedcode 46 medium
 * 全排列
 */
val list = arrayListOf<List<Int>>()

fun permute(nums: IntArray): List<List<Int>> {
    permute2(nums, 0)
    return list.toList()
}

fun permute2(nums: IntArray, n: Int) {
    if (nums.isEmpty()) {
        return
    }
    if (n == nums.size) {
        list.add(nums.toList())
        return
    }
    var temp: Int
    for (i in n until nums.size) {
        temp = nums[i]
        nums[i] = nums[n]
        nums[n] = temp
        permute2(nums, n + 1)
        temp = nums[i]
        nums[i] = nums[n]
        nums[n] = temp
    }
}

fun main() {
    val nums = IntArray(5)
    nums[0] = 1
    nums[1] = 2
    nums[2] = 3
    nums[3] = 4
    nums[4] = 5
    val list = permute(nums)
    list.forEach {
        it.forEach { it1 ->
            print("$it1 ")
        }
        println()
    }
}