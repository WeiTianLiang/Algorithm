package LinkedList

/**
 * leedcode 138 medium
 * 复制带随机指针的链表
 */
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

fun copyRandomList(node: Node?): Node? {
    node ?: return null
    val map = mutableMapOf<Node, Node>()
    var tempNode = node

    while (tempNode != null) {
        map[tempNode] = Node(tempNode.`val`)
        tempNode = tempNode.next
    }

    map.forEach(action = {
        it.value.random = map[it.key.random]
        it.value.next = map[it.key.next]
    })

    return map.values.toList()[0]
}

fun main() {
    val a1 = Node(7)
    val a2 = Node(13)
    val a3 = Node(11)
    val a4 = Node(10)
    val a5 = Node(1)

    a1.next = a2
    a2.next = a3
    a2.random = a1
    a3.next = a4
    a3.random = a5
    a4.next = a5
    a4.random = a3
    a5.random = a1

    var node = copyRandomList(a1)
    while (node != null) {
        println("[${node.`val`} ${node.random?.`val`}]")
        node = node.next
    }
}