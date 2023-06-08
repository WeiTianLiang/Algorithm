package map


/**
 * leetcode 841 medium
 * 钥匙和房间
 */
private fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    // 进入过的房间
    val isEnterRoom = BooleanArray(rooms.size)
    dfs(rooms, isEnterRoom,0)
    return num == rooms.size
}

private var num: Int = 0

private fun dfs(rooms: List<List<Int>>, isEnterRoom: BooleanArray, x: Int) {
    isEnterRoom[x] = true
    num++
    for (i in rooms[x]) {
        if (!isEnterRoom[i]) {
            dfs(rooms, isEnterRoom, i)
        }
    }
}
fun main() {
    val list = arrayListOf(
        arrayListOf(1, 3),
        arrayListOf(3, 0, 1),
        arrayListOf(2),
        arrayListOf(0)
    )
    print(canVisitAllRooms(list))
}