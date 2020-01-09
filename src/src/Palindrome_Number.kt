/**
 * 回文数
 */
fun isPalindrome(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    var temp = 0
    var num = x
    if (num < 0) {
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
            return false
        } else if (temp <= 214748364 && num > 7 && temp >= 100000000) {
            return false
        }
    }
    if (temp == x) {
        return true
    }
    return false
}

fun main() {
    print(isPalindrome(121))
}