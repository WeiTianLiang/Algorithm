package String

import kotlin.math.max

/**
 * 最大连续字串和
 */
private fun maxSubArray(nums: IntArray): Int {
    var nowNumber = nums[0]
    var tempNumber = 0
    nums.forEach {
        if (tempNumber >= 0) {
            tempNumber += it
        } else {
            tempNumber = it
        }
        nowNumber = max(nowNumber, tempNumber)
    }

    return nowNumber
}

fun main() {
    val arr = IntArray(9)
    arr[0] = -2
    arr[1] = 1
    arr[2] = -3
    arr[3] = 4
    arr[4] = -1
    arr[5] = 2
    arr[6] = 1
    arr[7] = -5
    arr[8] = 4
    print(maxSubArray(arr))
}