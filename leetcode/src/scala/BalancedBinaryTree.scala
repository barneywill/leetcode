/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object BalancedBinaryTree2 {
    def isBalanced(root: TreeNode): Boolean = {
        if (root == null) return true
        else return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
    }
    def maxDepth(root: TreeNode): Int = {
        if (root == null) return 0
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
    def main(args : Array[String]): Unit = {
        println(isBalanced(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))))
    }
}