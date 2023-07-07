package Recursion

/**
 * 剑指 OfferII 79 medium
 * 所有子集
 */
private fun subsets(nums: IntArray): List<List<Int>> {
    merge(0, nums)
    return result
}

private val temp by lazy { arrayListOf<Int>() }
private val result by lazy { arrayListOf<ArrayList<Int>>() }
private fun merge(index: Int, nums: IntArray) {
    if (index == nums.size) {
        result.add(temp.clone() as ArrayList<Int>)
        return
    }
    temp.add(nums[index])
    merge(index + 1, nums)
    temp.removeAt(temp.size - 1)
    merge(index + 1, nums)
}

fun main() {
    val list = subsets(intArrayOf(1, 2, 3))
    list.forEach {
        it.forEach { it1 ->
            print("$it1 ")
        }
        println()
    }
}