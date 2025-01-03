from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if root is None:
            return False
        elif root.left is None and root.right is None:
            return root.val == targetSum
        else:
            if root.left is not None:
                root.left.val += root.val
                if self.hasPathSum(root.left, targetSum):
                    return True
            if root.right is not None:
                root.right.val += root.val
                if self.hasPathSum(root.right, targetSum):
                    return True
        return False
