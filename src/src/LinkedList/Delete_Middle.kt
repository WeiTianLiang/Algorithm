package LinkedList

import structure.ListNode
import structure.createList
import structure.length
import structure.printListNode

/**
 * leetcode 2095 medium
 * 删除链表中间节点
 */
private fun deleteMiddle(head: ListNode?): ListNode? {
    head ?: return null
    val size = head.length()
    if (size == 1) {
        return null
    }
    val middleIndex = size / 2
    var tempHead = head
    var curIndex = 0
    while (tempHead != null) {
        if (curIndex == middleIndex - 1) {
            curIndex++
            tempHead.next = tempHead.next?.next
        } else {
            curIndex++
        }
        tempHead = tempHead.next
    }
    return head
}

fun main() {
    val head = createList(2)
    printListNode(deleteMiddle(head))
}