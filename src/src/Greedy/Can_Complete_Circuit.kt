package Greedy

/**
 * leetcode 134 medium
 * 加油站
 */
private fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    for (startIndex in gas.indices) {
        // 找到可以作为出发点的位置
        if (gas[startIndex] < cost[startIndex] || gas[startIndex] == 0) {
            continue
        }
        // 前后重复的起始节点可按同一节点处理
        if (startIndex > 0 && gas[startIndex] == gas[startIndex - 1] && cost[startIndex] == cost[startIndex - 1]) {
            continue
        }
        // 更新出发点的油量信息
        var allOilTank = gas[startIndex] - cost[startIndex]
        var curIndex = startIndex
        // 循环查看该出发点能否完成循环
        while (true) {
            curIndex++
            // 循环index
            if (curIndex > gas.size - 1) {
                curIndex -= gas.size
            }
            // 可以回到起点，返回起点信息
            if (curIndex == startIndex) {
                return startIndex
            }
            // 刷新油量数据
            allOilTank += gas[curIndex] - cost[curIndex]
            // 油量小于零，循环失败，不能回到起点
            if (allOilTank < 0) {
                break
            }
        }
    }
    return -1
}

fun main() {
    val gas = intArrayOf(1, 1, 1)
    val cost = intArrayOf(1, 1, 1)
    print(canCompleteCircuit(gas, cost))
}