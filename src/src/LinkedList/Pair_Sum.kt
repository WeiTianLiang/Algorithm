package LinkedList

import structure.ListNode
import structure.createList

/**
 * leetcode 2130 medium
 * 链表最大孪生和
 */
fun pairSum(head: ListNode?): Int {
    head ?: return 0
    var tempHead = head
    var slow = head
    var fast = head.next
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    var newHead = reverseThisList(slow?.next)
    slow?.next = newHead

    var max = 0
    while (tempHead != null && newHead != null) {
        val value1 = tempHead.value as Int
        val value2 = newHead.value as Int
        max = max.coerceAtLeast(value1 + value2)
        tempHead = tempHead.next
        newHead = newHead.next
    }

    return max
}

fun reverseThisList(head: ListNode?): ListNode? {
    var preHead = head
    var curHead: ListNode? = null
    while (preHead != null) {
        val temp = preHead.next
        preHead.next = curHead
        curHead = preHead
        preHead = temp
    }
    return curHead
}

fun main() {
    val head = createList(5, 4, 2, 1)
    print(pairSum(head))
}