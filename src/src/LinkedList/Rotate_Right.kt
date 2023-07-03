package LinkedList

import structure.ListNode
import structure.createList
import structure.length
import structure.printListNode

/**
 * leedcode 61 medium
 * 旋转链表
 */
private fun rotateRight(head: ListNode?, k: Int): ListNode? {
    head ?: return null
    var tempNode = head
    val tempHead = tempNode

    var splitIndex = k
    val listSize = tempNode.length()
    if (listSize == 1 || k == listSize || k == 0 || k % listSize == 0) {
        return head
    } else if (k > listSize) {
        splitIndex = k % listSize
    }

    // 找到新的表头
    var tempMedium = head
    for (i in 0 until listSize - splitIndex) {
        tempMedium = tempMedium?.next
    }

    var tempTail = tempMedium
    while (tempTail?.next != null) {
        tempTail = tempTail.next
    }

    var index = 1
    while (tempNode != null) {
        if (index == listSize - splitIndex) {
            tempNode.next = null
            break
        } else {
            tempNode = tempNode.next
        }
        index++
    }
    tempTail?.next = tempHead

    return tempMedium
}

fun main() {
    val head = createList(
        ListNode(1),
        ListNode(2),
        ListNode(3),
        ListNode(4),
        ListNode(5)
    )

    rotateRight(head, 10).printListNode()
}