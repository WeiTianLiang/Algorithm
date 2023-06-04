package `Fast-SlowPointer`

/**
 * leetcode 202 easy
 * 快乐数
 */
fun isHappy(n: Int): Boolean {
    if (n == 0) {
        return false
    }
    if (n == 1) {
        return true
    }
    var slow = n
    var fast = n
    do {
        slow = doHappy(slow)
        fast = doHappy(fast)
        fast = doHappy(fast)
    } while (slow != fast)

    return slow == 1
}

fun doHappy(n: Int): Int {
    var sum = 0
    var number = n
    while (number != 0) {
        val temp = number % 10
        sum += temp * temp
        number /= 10
    }
    return sum
}

fun main() {
    print(isHappy(2))
}