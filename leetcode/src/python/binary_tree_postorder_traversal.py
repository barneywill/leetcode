from typing import Optional
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BinaryTreePostorderTraversal:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root is not None:
            result += self.postorderTraversal(root.left)
            result += self.postorderTraversal(root.right)
            result.append(root.val)
        return result