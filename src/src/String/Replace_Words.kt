package String

/**
 * leetcode 648 medium
 * 单词替换
 */
private fun replaceWords(dictionary: List<String>, sentence: String): String {
    val arr = sentence.split(" ")
    val stringBuilder = StringBuilder()
    for (i in arr.indices) {
        stringBuilder.append(find(dictionary, arr[i]))
        if (i != arr.size - 1) {
            stringBuilder.append(" ")
        }
    }
    return stringBuilder.toString()
}

private fun find(dictionary: List<String>, sentence: String): String {
    val resultList = arrayListOf<String>()
    var minSize = Int.MAX_VALUE
    dictionary.forEach {
        val size = it.length
        if (size < sentence.length && sentence.substring(0, size) == it && minSize > size) {
            minSize = it.length
            resultList.add(it)
        }
    }
    return if (resultList.size == 0) {
        sentence
    } else {
        resultList.last()
    }
}

fun main() {
    println(replaceWords(arrayListOf("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"))
    println(replaceWords(arrayListOf("cat", "bat", "rat"), "the cattle was rattled by the battery"))
    println(replaceWords(arrayListOf("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"))
}