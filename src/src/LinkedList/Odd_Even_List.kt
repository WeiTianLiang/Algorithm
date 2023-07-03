package LinkedList

import structure.ListNode
import structure.createList
import structure.printListNode

/**
 * leetcode 328 medium
 * 奇偶链表
 */
private fun oddEvenList(head: ListNode?): ListNode? {
    head ?: return null
    // 奇数表头
    val oddHead = ListNode(-1)
    var tempOddHead = oddHead
    // 偶数表头
    val eventHead = ListNode(-1)
    var tempEventHead = eventHead
    var tempHead = head
    var index = 1
    while (tempHead != null) {
        if (index % 2 == 0) {
            tempEventHead.next = tempHead
            tempEventHead = tempEventHead.next!!
        } else {
            tempOddHead.next = tempHead
            tempOddHead = tempOddHead.next!!
        }
        index++
        tempHead = tempHead.next
    }
    tempOddHead.next = null
    tempEventHead.next = null
    tempOddHead.next = eventHead.next
    return oddHead.next
}

fun main() {
    val head = createList(2, 1, 3, 5, 6, 4, 7)
    oddEvenList(head).printListNode()
}