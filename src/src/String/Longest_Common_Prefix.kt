package String

import java.lang.StringBuilder
import kotlin.math.min
/**
 * 最长公共前缀
 */
private fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }
    var mid = strs[0]
    strs.forEach {
        mid = twoWordCommonPrefix(mid, it)
    }
    return mid
}

private fun twoWordCommonPrefix(str1: String, str2: String): String {
    val builder = StringBuilder()
    for (i in 0 until min(str1.length, str2.length)) {
        if (str1[i] == str2[i]) {
            builder.append(str1[i])
        }
        if (str1[i] != str2[i]) {
            break
        }
    }
    return builder.toString()
}

fun main() {
    print(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}