package Tree

/**
 * leetcode 96 medium
 * 不同的二叉搜索树
 */
private var map = mutableMapOf<Int, Int>()
private fun numTrees(n: Int): Int {
    if (n == 0 || n == 1) {
        return 1
    }
    if (map.containsKey(n)) {
        return map.getValue(n)
    }
    var count = 0
    for (i in 1..n) {
        val leftNumber = numTrees(i - 1)
        val rightNumber = numTrees(n - i)
        count += leftNumber * rightNumber
    }
    map.put(n, count)
    return count
}

fun main() {
    print(numTrees(3))
}