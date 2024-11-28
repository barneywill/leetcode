from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BalancedBinaryTree:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        else:
            is_left_balanced = self.isBalanced(root.left)
            is_right_balanced = self.isBalanced(root.right)
            if is_left_balanced and is_right_balanced:
                left_depth = self.maxDepth(root.left)
                right_depth = self.maxDepth(root.right)
                return abs(left_depth - right_depth) <= 1
            else:
                return False
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        result = 0
        if root != None:
            left_depth = 1 + self.maxDepth(root.left)
            right_depth = 1 + self.maxDepth(root.right)
            result = max(left_depth, right_depth)
        return result