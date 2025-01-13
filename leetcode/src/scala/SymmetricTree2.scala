/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object SymmetricTree2 {
    def isSymmetric(root: TreeNode): Boolean = {
        if (root.left == null && root.right == null) return true
        else if (root.left == null && root.right != null) return false
        else if (root.left != null && root.right == null) return false
        else if (root.left.value != root.right.value) return false
        else {
            println("left + " + travel(root.left, true))
            println("right + " + travel(root.right, false))
            return travel(root.left, true).equals(travel(root.right, false))
        }
    }
    def travel(root: TreeNode, isLeftFirst: Boolean): String = {
        var result = ""
        if (root == null) {
            result = "null"
        } else if (root.left == null && root.right == null) {
            result += root.value
        } else if (isLeftFirst) {
            result += travel(root.left, isLeftFirst)
            result += root.value
            result += travel(root.right, isLeftFirst)
        } else {
            result += travel(root.right, isLeftFirst)
            result += root.value
            result += travel(root.left, isLeftFirst)
        }
        result
    }
    def main(args : Array[String]): Unit = {
        print(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(2)), new TreeNode(2, new TreeNode(2)))))
    }    
}