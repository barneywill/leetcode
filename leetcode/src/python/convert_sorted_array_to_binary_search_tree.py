from typing import Optional
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class ConvertSortedArrayToBinarySearchTree:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        result = None
        l = len(nums)
        if l > 0:
            middle = int((l - 1) / 2)
            result = TreeNode(nums[middle], self.sortedArrayToBST([] if middle == 0 else nums[0:middle]), self.sortedArrayToBST([] if middle == l - 1 else nums[middle + 1:l]))
        return result