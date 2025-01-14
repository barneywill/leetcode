/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import scala.collection.mutable.ArrayBuffer
object PathSum2 {
    def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
        var result = false
        if (root != null) {
            val arr = ArrayBuffer(root)
            while (arr.nonEmpty) {
                val node = arr.remove(0)
                if (node.left != null) {
                    node.left.value += node.value
                    arr.append(node.left)
                }
                if (node.right != null) {
                    node.right.value += node.value
                    arr.append(node.right)
                }
                if (node.left == null && node.right == null) {
                    if (node.value == targetSum) {
                        result = true
                        arr.clear
                    }
                }
            }
        }
        result
    }
}