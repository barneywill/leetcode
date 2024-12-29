from typing import List, Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BinaryTreePaths:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if root.left is None and root.right is None:
            return [str(root.val)]
        else:
            result = []
            if root.left is not None:
                left_result = self.binaryTreePaths(root.left)
                result = result + ['%s->%s' % (root.val, v) for v in left_result]
            if root.right is not None:
                right_result = self.binaryTreePaths(root.right)
                result = result + ['%s->%s' % (root.val, v) for v in right_result]
            return result