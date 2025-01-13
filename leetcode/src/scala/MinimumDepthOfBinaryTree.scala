/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks._
object MinimumDepthOfBinaryTree2 {
    def minDepth(root: TreeNode): Int = {
        var result = 0
        var list = new ArrayBuffer[TreeNode]()
        var nextList = new ArrayBuffer[TreeNode]()
        if (root != null) {
            nextList.append(root)
            breakable {
                while (true) {
                    if (nextList.isEmpty) break
                    else {
                        list.clear
                        list = nextList
                        nextList = new ArrayBuffer[TreeNode]()
                        result += 1
                    }
                    for (node <- list) {
                        if (node.left == null && node.right == null) break
                        else {
                            if (node.left != null) nextList.append(node.left)
                            if (node.right != null) nextList.append(node.right)
                        }
                    }
                }
            }
            
        }
        result
    }
}