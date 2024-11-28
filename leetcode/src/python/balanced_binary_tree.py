from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BalancedBinaryTree:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        else:
            isLeftBalanced = self.isBalanced(root.left)
            isRightBalanced = self.isBalanced(root.right)
            if isLeftBalanced and isRightBalanced:
                leftDepth = self.maxDepth(root.left)
                rightDepth = self.maxDepth(root.right)
                return abs(leftDepth - rightDepth) <= 1
            else:
                return False
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        result = 0
        if root != None:
            leftDepth = 1 + self.maxDepth(root.left)
            rightDepth = 1 + self.maxDepth(root.right)
            result = max(leftDepth, rightDepth)
        return result