package structure
/**
 * 单链表数据结构
 */
class ListNode(var value: Any) {
    var next: ListNode? = null
}

/**
 * 打印单链表
 */
fun printListNode(node: ListNode?) {
    var temp = node
    while (temp != null) {
        print("${temp.value} ")
        temp = temp.next
    }
}

/**
 * 获取链表长度
 */
fun ListNode.length(): Int {
    var count = 1
    var temp = this
    while (temp.next != null) {
        count++
        temp.next?.let {  temp = it }
    }
    return count
}
fun createList(vararg nodes: ListNode): ListNode? {
    var temp: ListNode? = null
    var head: ListNode? = null
    for (node in nodes) {
        if (temp == null) {
            temp = node
            head = temp
        } else {
            temp.next = node
            temp = temp.next
        }
    }
    return head
}
