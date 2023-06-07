package map

import java.util.concurrent.LinkedBlockingQueue

/**
 * 剑指offerII 113 medium
 * 课程排序
 */
private fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    // 建图 key:当前需要对象 value:当前对象需要依赖的对象
    val originMap = mutableMapOf<Int, ArrayList<Int>>()
    for (i in 0 until numCourses) {
        originMap[i] = arrayListOf()
    }
    prerequisites.forEach {
        val list = originMap[it[0]]
        list?.add(it[1])
    }

    // 将入度为 0 的节点当作根节点
    val rootQueue = LinkedBlockingQueue<Int>()
    val degreeSizeMap = mutableMapOf<Int, Int>()
    originMap.forEach(action = {
        if (it.value.size == 0) {
            rootQueue.add(it.key)
        } else {
            degreeSizeMap[it.key] = it.value.size
        }
    })
    if (rootQueue.size == 0) {
        return intArrayOf()
    }
    // 广度遍历
    val result = arrayListOf<Int>()
    while (rootQueue.isNotEmpty()) {
        val root = rootQueue.remove()
        result.add(root)
        originMap.forEach(action = {
            val key = it.key
            val value = it.value
            value.forEach { replyDegree ->
                if (replyDegree == root) {
                    degreeSizeMap[key] = degreeSizeMap[key]!! - 1
                    if (degreeSizeMap[key] == 0) {
                        rootQueue.add(key)
                    }
                }
            }
        })
    }
    if (result.size != originMap.size) {
        return intArrayOf()
    }
    return result.toIntArray()
}

fun main() {
    val arr = arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(0, 1))
    val result = findOrder(3, arr)
    result.forEach {
        print("$it ")
    }
}