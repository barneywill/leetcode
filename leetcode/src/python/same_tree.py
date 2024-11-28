from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class SameTree:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        str1 = self.tree2Str(p)
        str2 = self.tree2Str(q)
        return str1 == str2
    def tree2Str(self, root: Optional[TreeNode]) -> str:
        result = ''
        if root == None:
            result += ' '
        else:
            result += str(root.val)
            result += self.tree2Str(root.left)
            result += self.tree2Str(root.right)
        return result