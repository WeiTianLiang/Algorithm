package Recursion

/**
 * 数组合并排序
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    if (nums1.size < nums2.size) {
        merge(nums2, n, nums1, m)
    }
    if (n == 0) {
        return
    }
    val length = m + n
    var j = 0
    for (i in 0 until length) {
        if (nums1[i] == 0 && i == length - n + j - 1) {
            break
        }
        if (j == n) {
            break
        }
        if (nums1[i] > nums2[j]) {
            var k = length - 1
            while (k >= i + 1) {
                nums1[k] = nums1[k - 1]
                k--
            }
            nums1[i] = nums2[j]
            j++
        }
    }
    for (i in j until n) {
        nums1[length - n + i] = nums2[i]
    }
}

fun main() {
    val num1 = IntArray(9)
    val num2 = IntArray(6)

    num1[0] = 0
    num1[1] = 0
    num1[2] = 3
    num1[3] = 0
    num1[4] = 0
    num1[5] = 0
    num1[6] = 0
    num1[7] = 0
    num1[8] = 0

    num2[0] = -1
    num2[1] = 1
    num2[2] = 1
    num2[3] = 1
    num2[4] = 2
    num2[5] = 3

    merge(num1, 3, num2, num2.size)
    num1.forEach {
        print(it)
    }
}