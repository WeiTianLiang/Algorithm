package Tree

import structure.TreeNode
import structure.buildTree
import structure.changeTree

/**
 * 剑指OfferII 50 medium
 * 向下的路径节点之和
 */
private var count = 0
private fun pathSum(root: TreeNode?, targetSum: Int): Int {
    root ?: return 0
    calculate(root, targetSum)
    pathSum(root.left, targetSum)
    pathSum(root.right, targetSum)
    return count
}
private fun calculate(root: TreeNode?, targetSum: Int) {
    root ?: return
    if (targetSum == root.value) {
        count++
    }
    val newTarget = targetSum.minus(root.value as Int)
    calculate(root.left, newTarget)
    calculate(root.right, newTarget)
}
fun main() {
    val map = mutableMapOf<Int, Int>()
    map[0] = 10
    map[1] = 5
    map[2] = -3
    map[3] = 3
    map[4] = 2
    map[5] = 11
    map[6] = 3
    map[7] = -2
    map[8] = 1
    val preorder = intArrayOf(0, 1, 3, 6, 7, 4, 8, 2, 5)
    val inorder = intArrayOf(6, 3, 7, 1, 4, 8, 0, 2, 5)
    val root = buildTree(preorder, inorder)
    changeTree(root, map)
    print(pathSum(root, 8))
}