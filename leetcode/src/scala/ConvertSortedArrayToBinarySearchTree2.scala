/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object ConvertSortedArrayToBinarySearchTree2 {
    def sortedArrayToBST(nums: Array[Int]): TreeNode = {
        var root : TreeNode = null
        if (nums.length == 1) root = new TreeNode(nums(0))
        else {
            val mid = nums.length / 2
            root = new TreeNode(nums(mid))
            if (mid - 1 >= 0) root.left = sortedArrayToBST(nums.slice(0, mid))
            if (mid + 1 <= nums.length - 1) root.right = sortedArrayToBST(nums.slice(mid + 1, nums.length))
        }
        root
    }
}