package Greedy

/**
 * leetcode 397 medium
 * 整数替换
 */
private fun integerReplacement(n: Int): Int {
    if (n == 1) {
        return 0
    }
    var tempN = n
    var times = 0
    while (tempN != 1) {
        tempN = if (tempN % 2 == 0) {
            times++
            tempN / 2
        } else if (tempN % 4 == 1) {
            times += 2
            tempN / 2
        } else {
            if (tempN == 3) {
                times += 2
                1
            } else {
                times += 2
                tempN / 2 + 1
            }
        }
    }
    return times
}

fun main() {
    print(integerReplacement(2147483647))
}