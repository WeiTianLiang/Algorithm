package LinkedList

import structure.ListNode
import structure.createList
import structure.length
import structure.printListNode

/**
 * leetcode 25 hard
 * K 个一组翻转链表
 */
private fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    head ?: return null
    if (k == 0 || k == 1) return head

    val length = head.length()

    var startIndex = 1
    var endIndex = k
    var result = head
    while (endIndex <= length) {
        result = reverseBetween(result, startIndex, endIndex)
        startIndex = endIndex + 1
        endIndex = startIndex + k - 1
        if (endIndex > length) {
            break
        }
    }

    return result
}

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
    reverseKGroup(createList(1, 2, 3, 4, 5), 2).printListNode()
    println()
    reverseKGroup(createList(1, 2, 3, 4, 5), 3).printListNode()
    println()
    reverseKGroup(createList(1, 2), 2).printListNode()
}