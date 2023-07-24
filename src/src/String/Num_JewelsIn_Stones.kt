package String

/**
 * leetcode 771 easy
 * 宝石与石头
 */
private fun numJewelsInStones(jewels: String, stones: String): Int {
    var num = 0
    for (stone in stones) {
        if (jewels.contains(stone)) {
            num++
        }
    }
    return num
}

fun main() {
    print(numJewelsInStones("aA", "aAAbbbb"))
    println()
    print(numJewelsInStones("z", "ZZ"))
}