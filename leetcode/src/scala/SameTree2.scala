/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object SameTree2 {
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
        var result = true
        if (p == null && q == null) result = true
        else if (p != null && q == null) result = false
        else if (p == null && q != null) result = false
        else {
            if (p.value == q.value) {
                if (!isSameTree(p.left, q.left)) result = false
                else if (!isSameTree(p.right, q.right)) result = false
                else result = true
            } else result = false
        }
        result
    }
}