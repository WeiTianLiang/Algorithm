package LinkedList

import structure.ListNode

/**
 * 剑指 OfferII 22 medium
 * 链表中环的入口节点
 */
private fun detectCycle(head: ListNode?): ListNode? {
    head ?: return null
    val list = arrayListOf<ListNode>()
    var tempNode = head
    while (tempNode != null) {
        if (!list.contains(tempNode)) {
            list.add(tempNode)
            tempNode = tempNode.next
        } else {
            return tempNode
        }
    }
    return null
}

fun main() {
    val node1 = ListNode(3)
    val node2 = ListNode(2)
    val node3 = ListNode(0)
    val node4 = ListNode(-4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2
    print(detectCycle(node1)?.value)
}