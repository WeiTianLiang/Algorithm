package LinkedList

import structure.ListNode
import structure.createList
import structure.length
import structure.printListNode

/**
 * leetcode 21 easy
 * 合并两个有序链表
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null && list2 == null) {
        return null
    }
    list1 ?: return list2
    list2 ?: return list1

    var cur = ListNode(-1)
    val curHead = cur
    var tempList1 = list1
    var tempList2 = list2
    while (tempList1 != null && tempList2 != null) {
        val temp1 = tempList1.value as Int
        val temp2 = tempList2.value as Int
        if (temp1 < temp2) {
            cur.next = tempList1
            tempList1 = tempList1.next
        } else {
            cur.next = tempList2
            tempList2 = tempList2.next
        }
        cur = cur.next!!
    }
    if (tempList2 != null) {
        cur.next = tempList2
    }
    if (tempList1 != null) {
        cur.next = tempList1
    }
    return curHead.next
}

fun main() {
    val head1 = createList(
        ListNode(1),
        ListNode(2),
        ListNode(4),
        ListNode(6)
    )
    val head2 = createList(
        ListNode(1),
        ListNode(3),
        ListNode(4)
    )
    printListNode(mergeTwoLists(head1, head2))
}