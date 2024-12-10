from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class InvertBinaryTree:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is not None:
            if root.left is not None or root.right is not None:
                tmp = root.left
                root.left = root.right
                root.right = tmp
                if root.left is not None:
                    self.invertTree(root.left)
                if root.right is not None:
                    self.invertTree(root.right)
        return root