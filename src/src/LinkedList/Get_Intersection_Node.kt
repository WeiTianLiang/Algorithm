package LinkedList

import structure.ListNode
import structure.createList

/**
 * leetcode 160 easy
 * 相交链表
 */
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    headA ?: return null
    headB ?: return null

    val map = mutableMapOf<ListNode, Int>()
    var tempHeadA = headA
    while (tempHeadA != null) {
        map[tempHeadA] = 0
        tempHeadA = tempHeadA.next
    }

    var tempHeadB = headB
    while (tempHeadB != null) {
        if (map.containsKey(tempHeadB)) {
            return tempHeadB
        }
        tempHeadB = tempHeadB.next
    }
    return null
}

fun main() {
    val a1 = ListNode(8)
    val a2 = ListNode(4)
    val a3 = ListNode(5)
    val headA = createList(
        ListNode(4),
        ListNode(1),
        a1, a2, a3
    )
    val headB = createList(
        ListNode(5),
        ListNode(6),
        ListNode(1),
        a1, a2, a3
    )
    print(getIntersectionNode(headA, headB)?.value)
}