from typing import Optional
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BinaryTreePreorderTraversal:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root is not None:
            result.append(root.val)
            result += self.preorderTraversal(root.left)
            result += self.preorderTraversal(root.right)
        return result