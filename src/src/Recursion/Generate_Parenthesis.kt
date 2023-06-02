package Recursion


/**
 * leetcode 22 medium
 * 括号生成
 */
fun generateParenthesis(n: Int): List<String> {
    val strList = arrayListOf<String>()
    val str = ""
    merge(str, strList, n, n, n)
    return strList
}

fun merge(str: String, strList: ArrayList<String>, leftCount: Int, rightCount: Int, count: Int) {
    if (rightCount < leftCount) {
        return
    }
    if (leftCount == 0 && rightCount == 0) {
        strList.add(str)
        return
    }
    if (leftCount > 0) {
        merge("$str(", strList, leftCount - 1, rightCount, count)
    }
    if (rightCount > 0) {
        merge("$str)", strList, leftCount, rightCount - 1, count)
    }
}

fun main() {
    val list = generateParenthesis(3)
    list.forEach {
        print("$it  ")
    }
}