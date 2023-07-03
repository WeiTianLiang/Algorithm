package LinkedList

import structure.ListNode
import structure.createList
import structure.length
import structure.printListNode

/**
 * leedcode 19 medium
 * 删除链表的倒数第 N 个结点
 */
private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    head ?: return null
    var tempNode = head
    val tempHead = tempNode
    var index = 0
    val listSize = tempNode.length()
    if (n > listSize) {
        return null
    } else if (n == listSize) {
        return head.next
    }
    val targetIndex = listSize - n - 1
    while (tempNode != null) {
        if (index == targetIndex) {
            tempNode.next = tempNode.next?.next
        } else {
            tempNode = tempNode.next
        }
        index++
    }
    return tempHead
}

fun main() {
    val head = createList(
        ListNode(1),
        ListNode(2),
        ListNode(3),
        ListNode(4),
        ListNode(5)
    )

    removeNthFromEnd(head, 1).printListNode()
}