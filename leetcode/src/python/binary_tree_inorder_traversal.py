from typing import Optional
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BinaryTreeInorderTraversal:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root is not None:
            if root.left is not None:
                result += self.inorderTraversal(root.left)
            result.append(root.val)
            if root.right is not None:
                result += self.inorderTraversal(root.right)
        return result
