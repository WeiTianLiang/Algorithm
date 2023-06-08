package map


/**
 * 剑指offerII 115 medium
 * 重建序列
 */
private fun sequenceReconstruction(nums: IntArray, sequences: Array<IntArray>): Boolean {
    // 建图
    val map = mutableMapOf<Int, ArrayList<Int>>()
    for (num in nums) {
        map[num] = arrayListOf()
    }
    sequences.forEach {
        var i = 0
        while (i < it.size - 1) {
            map[it[i]]?.add(nums[i + 1])
            i++
        }
    }

    // 寻找根节点, 统计各节点对应的数量
    var rootNumber = 0
    val isSearchMap = mutableMapOf<Int, Boolean>()
    map.forEach(action = {
        if (it.value.size == 0) {
            rootNumber = it.key
            return@forEach
        }
        isSearchMap[it.key] = false
    })

    // 深度遍历图
    dfs(map, isSearchMap, rootNumber)
    print("depth: $depth")

    return depth == nums.size
}

private var depth = 0

private fun dfs(map: Map<Int, ArrayList<Int>>, isSearchMap: MutableMap<Int, Boolean>, root: Int) {
    isSearchMap[root] = true
    depth++
    map.forEach(action = {
        if (!isSearchMap[it.key]!!) {
            dfs(map, isSearchMap, it.key)
        }
    })
}

fun main() {
    val nums = intArrayOf(1, 2, 3)
    val sequences = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 3)
    )
    print(sequenceReconstruction(nums, sequences))
}