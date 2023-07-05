package LinkedList

import structure.ListNode
import structure.createList
import structure.printListNode

/**
 * leetcode 83 easy
 * 删除排序链表中的重复元素
 */
private fun deleteDuplicates(head: ListNode?): ListNode? {
    head ?: return null
    var tempHead = head
    val resultHead = tempHead
    while (tempHead != null) {
        if (tempHead.value == tempHead.next?.value) {
            tempHead.next = tempHead.next?.next
            continue
        }
        tempHead = tempHead.next
    }
    return resultHead
}

fun main() {
    val head = createList(1, 1, 2, 3, 3)
    deleteDuplicates(head).printListNode()
}