package LinkedList

import structure.ListNode
import structure.createList
import structure.printListNode

/**
 * leetcode 92 medium
 * 反转链表 II
 */
private fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head?.next == null || left == right) {
        return head
    }
    val leftHead = ListNode(-1)
    leftHead.next = head
    var pre = leftHead

    for (i in 0 until left - 1) {
        pre = pre.next!!
    }

    var rightNode = pre
    for (i in left .. right) {
        rightNode = rightNode.next!!
    }

    val leftNode = pre.next
    val end = rightNode.next

    pre.next = null
    rightNode.next = null

    reverse(leftNode)
    pre.next = rightNode
    leftNode?.next = end

    return leftHead.next
}

private fun reverse(head: ListNode?): ListNode? {
    head ?: return null
    var cur = head
    var pre: ListNode? = null
    while (cur != null) {
        val temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }
    return pre
}

fun main() {
    val head1 = createList(1, 2, 3, 4, 5)
    reverseBetween(head1, 2, 4).printListNode()
    println()
    val head = createList(3, 5)
    reverseBetween(head, 1, 2).printListNode()
}