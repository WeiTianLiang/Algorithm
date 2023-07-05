package LinkedList

import structure.ListNode
import structure.createList
import structure.printListNode
import java.util.*

/**
 * leetcode 24 medium
 * 两两交换链表中的节点
 */
private fun swapPairs(head: ListNode?): ListNode? {
    head ?: return null
    val stack = Stack<ListNode>()
    val resultHead = ListNode(-1)
    var tempResultHead = resultHead
    var tempHead = head
    while (tempHead != null || stack.isNotEmpty()) {
        if (stack.size == 2) {
            while (stack.isNotEmpty()) {
                val value = stack.pop()
                tempResultHead.next = value
                tempResultHead = tempResultHead.next!!
            }
        }
        if (tempHead == null) {
            break
        }
        stack.push(tempHead)
        tempHead = tempHead.next
    }
    if (stack.isNotEmpty()) {
        tempResultHead.next = stack.pop()
        tempResultHead = tempResultHead.next!!
    }
    tempResultHead.next = null
    return resultHead.next
}

fun main() {
    val head = createList(1, 2, 3, 4, 5)
    swapPairs(head).printListNode()
}