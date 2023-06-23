package DoublePointer

/**
 * 剑指 OfferII 6 easy
 * 排序数组中两个数字之和
 */
private fun twoSum(numbers: IntArray, target: Int): IntArray {
    var startIndex = 0
    var endIndex = numbers.size - 1
    val arr = IntArray(2)
    while (startIndex < endIndex) {
        val startValue = numbers[startIndex]
        val endValue = numbers[endIndex]
        if (startValue + endValue > target) {
            endIndex--
        } else if (startValue + endValue < target) {
            startIndex++
        } else {
            arr[0] = startIndex
            arr[1] = endIndex
            return arr
        }
    }
    return arr
}

fun main() {
    val numbers = intArrayOf(1, 2, 4, 6, 10)
    twoSum(numbers, 8).forEach {
        print("$it ")
    }
}