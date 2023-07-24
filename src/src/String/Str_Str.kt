package String

/**
 * leetcode 28 easy
 * 找出字符串中第一个匹配项的下标
 */
private fun strStr(haystack: String, needle: String): Int {
    if (haystack == needle) {
        return 0
    }
    val needSize = needle.length
    for (i in 0 until (haystack.length - needSize + 1)) {
        val value = haystack[i]
        if (value == needle[0] && haystack.substring(i, i + needSize) == needle) {
            return i
        } else {
            continue
        }
    }
    return -1
}

fun main() {
    print(strStr("sadbutsad", "sad"))
    println()
    print(strStr("leetcode", "leeto"))
    println()
    print(strStr("sahbutsad", "sad"))
}