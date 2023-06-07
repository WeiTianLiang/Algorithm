package LinkedList

import structure.ListNode
import structure.createList
import structure.printListNode

/**
 * leetcode 148 medium
 * 链表排序
 */

/**
 * 归并递归
 * 1.使用快慢指针寻找中心点
 * 2.从中心点将原有链表进行分割
 * 3.对多个分割后的链表进行有序链表合并
 * 4.返回排序好的链表
 */
private fun sortList(head: ListNode?): ListNode? {
    head?.next ?: return head
    var slow = head
    var fast = head.next
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    val rightHead = slow?.next
    slow?.next = null
    println("right ${rightHead?.value}")
    println("left ${head.value}")
    val left = sortList(head)
    val right = sortList(rightHead)
    return merge(left, right)
}

/**
 * 合并两个有序链表
 */
private fun merge(left: ListNode?, right: ListNode?): ListNode? {
    if (left == null && right == null) {
        return null
    }
    left ?: return right
    right ?: return left
    val cur = ListNode(-1)
    var tempHead = cur
    var tempLeft = left
    var tempRight = right
    while (tempLeft != null && tempRight != null) {
        val leftValue = tempLeft.value as Int
        val rightValue = tempRight.value as Int
        if (leftValue < rightValue) {
            tempHead.next = tempLeft
            tempLeft = tempLeft.next
        } else {
            tempHead.next = tempRight
            tempRight = tempRight.next
        }
        tempHead = tempHead.next!!
    }
    if (tempLeft != null) {
        tempHead.next = tempLeft
    }
    if (tempRight != null) {
        tempHead.next = tempRight
    }
    return cur.next
}

fun main() {
    val head = createList(
        ListNode(5),
        ListNode(4),
        ListNode(2),
        ListNode(1),
        ListNode(3)
    )

    val result = sortList(head)
    printListNode(result)
}