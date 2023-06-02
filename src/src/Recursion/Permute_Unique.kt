package Recursion

/**
 * leedcode 47 medium
 * 全排列2
 */
fun permuteUnique(nums: IntArray): List<List<Int>> {
    val list = ArrayList<ArrayList<Int>>()
    permuteMerge(nums, list, 0)
    return list
}

fun permuteMerge(nums: IntArray, list: ArrayList<ArrayList<Int>>, n: Int) {
    if (n == nums.size) {
        list.add(nums.toList() as ArrayList<Int>)
        return
    }
    var temp: Int
    for (i in n until nums.size) {
        if (i > n && nums[i] == nums[i - 1]) {
            continue
        }
        temp = nums[i]
        nums[i] = nums[n]
        nums[n] = temp
        permuteMerge(nums, list, n + 1)
        temp = nums[i]
        nums[i] = nums[n]
        nums[n] = temp
    }
}

fun main() {
    val nums = IntArray(3)
    nums[0] = 1
    nums[1] = 3
    nums[2] = 2
    val list = permuteUnique(nums)
    list.forEach {
        it.forEach { it1 ->
            print("$it1 ")
        }
        println()
    }
}