package Recursion

/**
 * leetcode 39 medium
 * 组合总和
 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val list = ArrayList<ArrayList<Int>>()
    val tempList = ArrayList<Int>()
    merge(0, 0, tempList, list, candidates, target)
    return list
}

fun merge(
    num: Int,
    begin: Int,
    tempList: ArrayList<Int>,
    list: ArrayList<ArrayList<Int>>,
    candidates: IntArray,
    target: Int
) {
    if (num == target) {
        list.add(ArrayList(tempList))
        return
    }
    if (num > target) {
        return
    }
    for (i in begin until candidates.size) {
        val value = candidates[i]
        tempList.add(value)
        merge(num + value, i, tempList, list, candidates, target)
        tempList.removeLast()
    }
}

fun main() {
    val candidates = IntArray(4)
    candidates[0] = 2
    candidates[1] = 3
    candidates[2] = 5
    candidates[3] = 7
    val list = combinationSum(candidates, 7)
    list.forEach {
        it.forEach { it1 ->
            print("$it1 ")
        }
        println()
    }
}