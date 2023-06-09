package map

/**
 * 剑指offerII 115 medium
 * 重建序列
 */
private fun sequenceReconstruction(nums: IntArray, sequences: Array<IntArray>): Boolean {
    val map = mutableMapOf<Int, Int>()
    var count = 0
    for (i in 0 until nums.size - 1) {
        map[nums[i]] = nums[i + 1]
        count++
    }
    sequences.forEach {
        for (i in 0 until it.size - 1) {
            if (map[it[i]] == it[i + 1]) {
                count--
                map[it[i]] = -1
            }
        }
    }
    return count == 0
}

fun main() {
    val nums = intArrayOf(1, 4, 2, 3)
    val sequences = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(4, 2)
    )
    print(sequenceReconstruction(nums, sequences))
}