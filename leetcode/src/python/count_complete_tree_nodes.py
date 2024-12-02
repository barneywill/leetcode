from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class CountCompleteTreeNodes:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        result = 0
        if root is not None:
            if root.left is None and root.right is None:
                result = 1
            else:
                if root.left is not None:
                    result += self.countNodes(root.left)
                if root.right is not None:
                    result += self.countNodes(root.right)
                result += 1
        return result