import kotlin.math.max
import kotlin.math.min

/**
 * 两数之和
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    val num = IntArray(2)
    for (i in nums.indices) {
        if (map.containsKey(nums[i])) {
            num[0] = min(i, map[nums[i]]!!)
            num[1] = max(i, map[nums[i]]!!)
        } else if (!map.containsKey(nums[i])) {
            map[target - nums[i]] = i
        }
    }
    return num
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