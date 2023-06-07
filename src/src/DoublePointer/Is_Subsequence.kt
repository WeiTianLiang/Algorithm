package DoublePointer

/**
 * leetcode 392 easy
 * 判断子序列
 */
private fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) {
        return true
    }
    if (s.length > t.length) {
        return false
    }
    if (s.length == t.length) {
        return s == t
    }
    var sIndex = 0
    var tIndex = 0

    while (tIndex < t.length) {
        if (s[sIndex] == t[tIndex]) {
            sIndex++
        }
        tIndex++
        if (sIndex == s.length) {
            return true
        }
    }

    return false
}
fun main() {
    print(isSubsequence("axc", "ahbgdc"))
}