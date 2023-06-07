package String

/**
 * leetcode 1768 easy
 * 交替合并字符串
 */
private fun mergeAlternately(word1: String, word2: String): String {
    var index = 0
    val stringBuilder = StringBuilder()
    while (index < word1.length && index < word2.length) {
        stringBuilder.append(word1[index]).append(word2[index])
        index++
    }
    if (index < word1.length) {
        stringBuilder.append(word1.subSequence(index, word1.length))
    }
    if (index < word2.length) {
        stringBuilder.append(word2.subSequence(index, word2.length))
    }
    return stringBuilder.toString()
}

fun main() {
    print(mergeAlternately("abc", "eee"))
}