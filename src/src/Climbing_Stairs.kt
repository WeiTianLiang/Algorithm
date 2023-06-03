/**
 * leetcode 70 easy
 * 爬楼梯
 */
fun climbStairs(n: Int): Int {
    return when {
        n <= 1 -> {
            1
        }
        n == 2 -> {
            2
        }
        else -> {
            var res = 0
            var i = 1
            var j = 2
            var k = 3
            while (k <= n) {
                res = i + j
                i = j
                j = res
                k++
            }
            res
        }
    }
}

fun main() {
    print(climbStairs(5))
}