from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class MaximumDepthOfBinaryTree:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        result = 0
        if root is not None:
            left_depth = 1 + self.maxDepth(root.left)
            right_depth = 1 + self.maxDepth(root.right)
            result = max(left_depth, right_depth)
        return result