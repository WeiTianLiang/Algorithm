fun main() {
    val arr = IntArray(11)
    arr[0] = 4
    arr[1] = 0
    arr[2] = 4
    arr[3] = 2
    arr[4] = 2
    arr[5] = 0
    arr[6] = 1
    arr[7] = 3
    arr[8] = 3
    arr[9] = 0
    arr[10] = 3
    print(canJump(arr))
}

/**
 * 跳跃游戏
 */
fun canJump(nums: IntArray): Boolean {
    val length = nums.size
    if (nums[0] == 0 && nums.size > 1) {
        return false
    }
    if (nums.size == 1) {
        return true
    }
    if (nums[0] == length - 1) {
        return true
    }
    var maxFar = nums[0]
    for (i in 1 until length) {
        if (i <= maxFar) {
            if (i + nums[i] > maxFar) {
                maxFar = nums[i] + i
            }
        }
    }
    return maxFar >= length - 1
}