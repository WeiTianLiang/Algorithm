package String

/**
 * 有效括号
 */
private fun isValid(s: String): Boolean {
    var str = s
    while (true) {
        val len = str.length
        // 此时循环会生成大量 String 对象，耗时且耗费资源。
        // 扩展 StringBuilder 方法实现字符串替换，代替 String。
        str = str.replace("()", "")
        str = str.replace("{}", "")
        str = str.replace("[]", "")
        if (len == str.length) {
            break
        }
    }
    return str.isEmpty()
}

fun main() {
    print(isValid("[()]"))
}