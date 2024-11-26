from typing import List

class SearchInsertPosition:
    def searchInsert(self, nums: List[int], target: int) -> int:
        for i, c in enumerate(nums):
            if target <= c:
                return i
        return len(nums)