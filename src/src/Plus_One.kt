/**
 * 加一数组
 */
fun plusOne(digits: IntArray): IntArray {
    val length = digits.size
    var i = length - 1
    var temp = 1
    while (i >= 0) {
        if (digits[i] + temp > 9) {
            digits[i] = 0
            temp = 1
            i--
        } else {
            digits[i] = digits[i] + temp
            temp = 0
            break
        }
    }
    if (temp == 1) {
        val num = IntArray(length + 1)
        num[0] = temp
        for (j in 0 until length) {
            num[j + 1] = digits[j]
        }
        return num
    }
    return digits
}

fun main() {
    val num = IntArray(1)
    num[0] = 2
    plusOne(num).forEach {
        print(it)
    }
}