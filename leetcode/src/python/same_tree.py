from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class SameTree:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        str1 = self.tree_2_str(p)
        str2 = self.tree_2_str(q)
        return str1 == str2
    def tree_2_str(self, root: Optional[TreeNode]) -> str:
        result = ''
        if root is None:
            result += ' '
        else:
            result += str(root.val)
            result += self.tree_2_str(root.left)
            result += self.tree_2_str(root.right)
        return result