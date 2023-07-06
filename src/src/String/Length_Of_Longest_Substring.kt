package String

/**
 * leetcode 3 medium
 * 无重复字符的最长子串
 */
private fun lengthOfLongestSubstring(s: String): Int {
    if (s.length == 1 || s.isEmpty()) {
        return s.length
    }
    var curIndex = 0
    var preIndex = 0
    var maxSize = Int.MIN_VALUE
    var str = ""
    while (preIndex < s.length) {
        val value = s[preIndex]
        if (str.contains(value)) {
            maxSize = maxSize.coerceAtLeast(preIndex - curIndex)
            curIndex++
            str = str.removeRange(0, 1)
        } else {
            str += value
            preIndex++
        }
    }
    maxSize = if (maxSize == Int.MIN_VALUE) {
        s.length
    } else {
        maxSize.coerceAtLeast(preIndex - curIndex)
    }

    return maxSize
}
fun main() {
    print(lengthOfLongestSubstring("aab"))
}