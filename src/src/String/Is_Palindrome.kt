package String

/**
 * 剑指 Offer II 18 easy
 * 有效的回文
 */
private fun isPalindrome(s: String): Boolean {
    var startIndex = 0
    var endIndex = s.length - 1
    while (startIndex < endIndex) {
        val startValue = s[startIndex]
        val endValue = s[endIndex]
        if (!startValue.isDigit() && !startValue.isLetter()) {
            startIndex++
            continue
        }
        if (!endValue.isDigit() && !endValue.isLetter()) {
            endIndex--
            continue
        }
        startIndex++
        endIndex--
        if (startValue.lowercaseChar() != endValue.lowercaseChar()) {
            return false
        }
    }
    return true
}

fun main() {
    print(isPalindrome("A man, a plan, a canal: Panama"))
}