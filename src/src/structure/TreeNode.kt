package structure

/**
 * 二叉树的数据结构
 */
class TreeNode(var value: Any) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * leetcode 105 medium
 * 从前序与中序遍历序列构造二叉树
 * 注：每个节点元素不同
 */
fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val map = mutableMapOf<Int, Int>()
    for (i in inorder.indices) {
        map[inorder[i]] = i
    }
    return buildTreeHelp(map, preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1)
}

private fun buildTreeHelp(
    map: Map<Int, Int>,
    preorder: IntArray,
    pStart: Int,
    pEnd: Int,
    inorder: IntArray,
    iStart: Int,
    iEnd: Int
): TreeNode? {
    if (pStart > pEnd) {
        return null
    }
    val rootValue = preorder[pStart]
    val root = TreeNode(rootValue)
    val midIndex = map[rootValue]
    val leftNum = midIndex!! - iStart
    root.left = buildTreeHelp(map, preorder, pStart + 1, pStart + leftNum, inorder, iStart, midIndex - 1)
    root.right = buildTreeHelp(map, preorder, pStart + 1 + leftNum, pEnd, inorder, midIndex + 1, iEnd)
    return root
}

/**
 * 后续遍历
 */
fun postPrint(root: TreeNode?) {
    root ?: return
    postPrint(root.left)
    postPrint(root.right)
    print("${root.value as Int} ")
}

/**
 * 前续遍历
 */
fun prePrint(root: TreeNode?) {
    root ?: return
    print("${root.value as Int} ")
    prePrint(root.left)
    prePrint(root.right)
}

/**
 * 中续遍历
 */
fun midPrint(root: TreeNode?) {
    root ?: return
    midPrint(root.left)
    print("${root.value as Int} ")
    midPrint(root.right)
}

fun changeTree(root: TreeNode?, map: Map<Int, Int>) {
    root ?: return
    root.value = map[root.value]!!
    changeTree(root.left, map)
    changeTree(root.right, map)
}