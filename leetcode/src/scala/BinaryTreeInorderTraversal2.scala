/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object BinaryTreeInorderTraversal2 {
    def inorderTraversal(root: TreeNode): List[Int] = {
        var result : List[Int] = List()
        if (root != null) {
            if (root.left != null) result = inorderTraversal(root.left)
            result = result :+ root.value
            if (root.right != null) result = List.concat(result, inorderTraversal(root.right))
        }
        result
    }
}