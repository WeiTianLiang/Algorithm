/**
 * leetcode 387 easy
 * 字符串中的第一个唯一字符
 */
private fun firstUniqChar(s: String): Int {
    val map = mutableMapOf<Char, Int>()
    for (i in s.indices) {
        val value = s[i]
        if (map.containsKey(value)) {
            map[value] = -1
        } else {
            map[value] = i
        }
    }
    map.forEach(action = {
        if (it.value != -1) {
            return it.value
        }
    })
    return -1
}

fun main() {
    print(firstUniqChar("aabb"))
}