package LinkedList

import structure.ListNode
import structure.createList
import structure.printListNode

/**
 * leetcode 206 easy
 * 反转链表
 */
private fun reverseList(head: ListNode?): ListNode? {
    head ?: return null

    var pre: ListNode? = null
    var cur = head

    while (cur != null) {
        val temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }
    return pre
}

fun main() {
    val head = createList(
        ListNode(1),
        ListNode(2),
        ListNode(3),
        ListNode(4),
        ListNode(5)
    )

    reverseList(head).printListNode()
}