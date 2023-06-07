package LinkedList

import structure.ListNode
import structure.createList
import structure.length
import structure.printListNode

/**
 * leetcode 2 medium
 * 两数相加
 */
private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    l1 ?: return null
    l2 ?: return null
    val root = ListNode(0)
    var cursor = root

    var node1 = l1
    var node2 = l2
    if (l1.length() < l2.length()) {
        return addTwoNumbers(l2, l1)
    }

    var carry = 0
    while (node1 != null) {
        val value1 = node1.value as Int
        val value2 = if (node2 == null) 0 else (node2.value as Int)
        val allValue = value1 + value2
        var tempCarry: Int
        val realValue = if (allValue >= 10) {
            tempCarry = 1
            allValue - 10 + carry
        } else {
            tempCarry = 0
            allValue + carry
        }
        carry = tempCarry

        val newNode = ListNode(realValue)
        cursor.next = newNode
        cursor = newNode
        node1 = node1.next
        node2 = node2?.next
    }
    return root.next
}

fun main() {
    val head1 = createList(
        ListNode(2),
        ListNode(4),
        ListNode(3)
    )
    val head2 = createList(
        ListNode(5),
        ListNode(6),
        ListNode(4),
        ListNode(4)
    )

    addTwoNumbers(head1, head2)?.let { printListNode(it) }
}