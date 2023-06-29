package String

/**
 * 剑指 OfferII 20
 * 回文子字符串的个数
 */
private fun countSubstrings(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }
    var maxCount = 0
    var startIndex = 0
    val sSize = s.length
    while (startIndex < sSize) {
        val tempStrBuild = StringBuilder()
        for (i in startIndex until sSize) {
            tempStrBuild.append(s[i])
            if (isPalindrome(tempStrBuild.toString())) {
                maxCount++
            }
        }
        startIndex++
    }
    return maxCount
}
private fun isPalindrome(s: String): Boolean {
    var startIndex = 0
    var endIndex = s.length - 1
    while (startIndex < endIndex) {
        val startValue = s[startIndex]
        val endValue = s[endIndex]
        startIndex++
        endIndex--
        if (startValue != endValue) {
            return false
        }
    }
    return true
}
fun main() {
    println(countSubstrings("abc"))
    print(countSubstrings("aaa"))
}