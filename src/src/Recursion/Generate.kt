package Recursion

/**
 * leetcode 118 easy
 * 杨辉三角
 */
private fun generate(numRows: Int): List<List<Int>> {
    val list = arrayListOf<List<Int>>()
    if (numRows == 0) {
        return list
    }
    if (numRows == 1) {
        list.add(arrayListOf(1))
        return list
    }
    if (numRows == 2) {
        list.add(arrayListOf(1))
        list.add(arrayListOf(1, 1))
        return list
    }
    var index = 2
    list.add(arrayListOf(1))
    list.add(arrayListOf(1, 1))
    var centerList = arrayListOf(1, 1)
    while (index < numRows) {
        val tempList = arrayListOf<Int>()
        tempList.add(1)
        for (i in 0 until centerList.size - 1) {
            tempList.add(centerList[i] + centerList[i + 1])
        }
        tempList.add(1)
        centerList = tempList
        list.add(tempList)
        index++
    }

    return list
}

fun main() {
    generate(5).forEach {
        it.forEach { value ->
            print("$value ")
        }
        println()
    }
}