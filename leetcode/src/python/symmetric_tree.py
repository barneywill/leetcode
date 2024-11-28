from operator import truediv
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.compare(root.left, root.right) if root != None else True
    def compare(self, l: Optional[TreeNode], r: Optional[TreeNode]) -> bool:
        result = False
        if l == None and r == None:
            result = True
        elif l == None or r == None:
            result = False
        else:
            if l.val != r.val:
                result = False
            else:
                result = self.compare(l.left, r.right) and self.compare(l.right, r.left)
        return result