package Array

import kotlin.math.min

/**
 * leetcode 54 medium
 * 螺旋矩阵
 */
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val list = arrayListOf<Int>()

    val size = min(matrix.size, matrix[0].size)
    val level = if (size % 2 == 0) {
        size / 2 - 1
    } else {
        size / 2
    }
    var levelIndex = 0

    while (levelIndex <= level) {
        for (i in levelIndex until matrix[0].size - levelIndex) {
            list.add(matrix[levelIndex][i])
        }
        var topToBottomKey = 0
        for (i in levelIndex + 1 until matrix.size - levelIndex) {
            topToBottomKey = matrix[0].size - levelIndex - 1
            if (topToBottomKey >= 0) {
                list.add(matrix[i][topToBottomKey])
            }
        }
        for (i in matrix[0].size - levelIndex - 2 downTo levelIndex) {
            val key = matrix.size - levelIndex - 1
            if (key != levelIndex) {
                list.add(matrix[key][i])
            }
        }
        for (i in matrix.size - levelIndex - 2 downTo levelIndex + 1) {
            val key = levelIndex
            if (key != topToBottomKey && key < matrix[0].size) {
                list.add(matrix[i][key])
            }
        }
        levelIndex++
    }
    return list
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(6, 7, 8, 9, 10),
        intArrayOf(11, 12, 13, 14, 15),
        intArrayOf(16, 17, 18, 19, 20),
    )
    val matrix1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    val matrix2 = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12)
    )
    val matrix3 = arrayOf(
        intArrayOf(7),
        intArrayOf(9),
        intArrayOf(6)
    )
    val matrix4 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4),
        intArrayOf(5, 6)
    )
    val matrix5 = arrayOf(
        intArrayOf(1, 11),
        intArrayOf(2, 12),
        intArrayOf(3, 13),
        intArrayOf(4, 14),
        intArrayOf(5, 15),
        intArrayOf(6, 16),
        intArrayOf(7, 17),
        intArrayOf(8, 18),
        intArrayOf(9, 19),
        intArrayOf(10, 20)
    )
    spiralOrder(matrix5).forEach {
        print("$it ")
    }
}