import structure.ListNode
import structure.getListNodeLength
import structure.printListNode

/**
 * 两数相加
 */
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var node1 = l1
    var node2 = l2
    val root = ListNode(0)
    var cursor = root
    if (node1 == null || node2 == null) {
        return null
    }
    if (getListNodeLength(node1) < getListNodeLength(node2)) {
        return addTwoNumbers(l2, l1)
    }
    var carry = 0
    while (node1 != null) {
        val nodeValue = if (node2 == null) {
            0
        } else {
            (node2.value as Int)
        }
        var ca: Int
        val temp = (node1.value as Int) + nodeValue
        val num = if (temp >= 10 || temp + carry >= 10) {
            ca = 1
            temp - 10 + carry
        } else {
            ca = 0
            temp + carry
        }
        carry = ca
        val numNode = ListNode(num)
        cursor.next = numNode
        cursor = numNode
        node1 = node1.next
        node2 = node2?.next
    }

    if (carry > 0) {
        cursor.next = ListNode(1)
    }

    return root.next
}

fun main() {
    val a = ListNode(2)
    val b = ListNode(4)
    val c = ListNode(3)
    a.next = b
    b.next = c

    val a1 = ListNode(5)
    val b1 = ListNode(6)
    val c1 = ListNode(4)
    val d1 = ListNode(4)
    a1.next = b1
    b1.next = c1
    c1.next = d1

    addTwoNumbers(a, a1)?.let { printListNode(it) }
}