/**
 * 最后一个单词的长度
 */
fun lengthOfLastWord(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }
    val arr = s.split(" ")
    if (arr.isEmpty()) {
        return 0
    }
    if (arr.size == 1) {
        return arr[0].length
    }
    for (i in arr.size - 1 downTo 0) {
        if (arr[i].isNotEmpty()) {
            return arr[i].length
        }
    }
    return arr[arr.size - 1].length
}

fun main() {
    val size = lengthOfLastWord("a  ")
    print("size : $size");
}