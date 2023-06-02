package Recursion

import java.util.Arrays

/**
 * leetcode 40 medium
 * 组合总和 2
 */
fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val list = ArrayList<ArrayList<Int>>()
    val tempList = ArrayList<Int>()
    Arrays.sort(candidates)
    merge2(0, 0, tempList, list, candidates, target)
    return list
}

fun merge2(
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
        if (i > begin && candidates[i] == candidates[i - 1]) {
            continue
        }
        tempList.add(candidates[i])
        merge2(num + candidates[i], i + 1, tempList, list, candidates, target)
        tempList.removeLast()
    }
}

fun main() {
    val candidates = IntArray(7)
    candidates[0] = 10
    candidates[1] = 1
    candidates[2] = 2
    candidates[3] = 7
    candidates[4] = 6
    candidates[5] = 1
    candidates[6] = 5
    val list = combinationSum2(candidates, 8)
    list.forEach {
        it.forEach { it1 ->
            print("$it1 ")
        }
        println()
    }
}