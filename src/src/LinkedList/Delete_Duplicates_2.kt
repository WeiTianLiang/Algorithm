package LinkedList

import structure.ListNode
import structure.createList
import structure.printListNode

/**
 * leetcode 82 medium
 * 删除排序链表中的重复元素 II
 */
private fun deleteDuplicates(head: ListNode?): ListNode? {
    head ?: return null
    val dummy = ListNode(0)
    dummy.next = head

    var cur = dummy
    while (cur.next != null && cur.next!!.next != null) {
        if (cur.next!!.value == cur.next!!.next?.value) {
            val x = cur.next!!.value
            while (cur.next != null && cur.next!!.value == x) {
                cur.next = cur.next!!.next;
            }
        } else {
            cur = cur.next!!
        }
    }
    return dummy.next
}

fun main() {
    deleteDuplicates(createList(1, 2, 3, 3, 4, 4, 5)).printListNode()
}