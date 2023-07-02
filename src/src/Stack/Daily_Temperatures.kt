package Stack

import java.util.Stack

/**
 * 剑指 OfferII 38 medium
 * 每日温度
 */
private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val resultArr = IntArray(temperatures.size)
    val stack = Stack<Int>()
    for (i in resultArr.indices) {
        while (stack.isNotEmpty() && temperatures[stack.peek()] < temperatures[i]) {
            val index = stack.pop()
            resultArr[index] = i - index
        }
        stack.push(i)
    }
    return resultArr
}

fun main() {
    val arr = dailyTemperatures(intArrayOf(30, 60, 90))
    arr.forEach {
        print("$it ")
    }
}