package LinkedList

import structure.ListNode
import structure.createList
import structure.printListNode

/**
 * leetcode 23 hard
 * 合并 K 个升序链表
 */
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) {
        return null
    }
    if (lists.size == 1) {
        return lists[0]
    }
    var startIndex = 0
    var endIndex = fetchEndIndex(lists)
    if (endIndex == -1) {
        return null
    }
    if (endIndex == 0) {
        return lists[0]
    }
    while (true) {
        lists[startIndex] = mergeThisTwoList(lists[startIndex], lists[endIndex])
        lists[endIndex] = null
        startIndex++
        endIndex--
        if (startIndex >= endIndex) {
            startIndex = 0
            endIndex = fetchEndIndex(lists)
            if (endIndex == 0) {
                return lists[0]
            }
        }
    }
}

fun fetchEndIndex(lists: Array<ListNode?>): Int {
    for (i in lists.size - 1 downTo 0) {
        if (lists[i] != null) {
            return i
        }
    }
    return 0
}

fun mergeThisTwoList(firstNode: ListNode?, secondNode: ListNode?): ListNode? {
    if (firstNode == null && secondNode == null) {
        return null
    }
    firstNode ?: return secondNode
    secondNode ?: return firstNode
    var curNode = ListNode(-1)
    val curHead = curNode
    var firstTemp = firstNode
    var secondTemp = secondNode
    while (firstTemp != null && secondTemp != null) {
        val value1 = firstTemp.value as Int
        val value2 = secondTemp.value as Int
        if (value1 < value2) {
            curNode.next = firstTemp
            firstTemp = firstTemp.next
        } else {
            curNode.next = secondTemp
            secondTemp = secondTemp.next
        }
        curNode = curNode.next!!
    }
    if (firstTemp != null) {
        curNode.next = firstTemp
    }
    if (secondTemp != null) {
        curNode.next = secondTemp
    }
    return curHead.next
}

fun main() {
//    val head1 = createList()
//    val head2 = createList()
//    val head3 = createList()
//    val head4 = createList(ListNode(1))
//    val head1 = createList(ListNode(1), ListNode(4), ListNode(5))
//    val head2 = createList(ListNode(1), ListNode(3), ListNode(4))
    val head3 = createList(ListNode(-2), ListNode(-1), ListNode(-1), ListNode(-1))
    val head4 = createList(ListNode(-2))
    val lists = arrayOf(head3, head4)
    printListNode(mergeKLists(lists))
}