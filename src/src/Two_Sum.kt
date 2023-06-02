/**
 * leetcode 1 easy
 * 两数之和
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val value = target - nums[i]
        if (map.containsKey(value)) {
            return intArrayOf(map[value]!!, i)
        }
        map[nums[i]] = i
    }
    throw IllegalAccessException("Wrong")
}

fun main() {
    val nums = IntArray(4)
    nums[0] = 2
    nums[1] = 11
    nums[2] = 7
    nums[3] = 15
    val target = 9
    twoSum(nums, target).forEach {
        print(" $it")
    }
}