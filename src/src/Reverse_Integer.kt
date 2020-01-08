/**
 * 整数翻转
 */
fun reverse(x: Int): Int {
    var symbol = 1
    var temp = 0
    var num = x
    if (num < 0) {
        symbol = -1
        num *= -1
    }
    var first = 0
    while (num >= 1) {
        if (first == 0 && num % 10 != 0) {
            first = num % 10
        }
        temp = temp * 10 + num % 10
        num /= 10
        if ((temp > 1000000000 || temp > 214748364) && num != 0) {
            return 0
        } else if (temp <= 214748364 &&  num > 7 && temp >= 100000000) {
            return 0
        }
    }

    return temp * symbol
}

fun main() {
    print(reverse(1056389759))
}