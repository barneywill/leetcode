from typing import List

class FinalArrayStateAfterKMultiplicationOperationsI:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        for i in range(k):
            min_num = 0
            min_index = -1
            for i, c in enumerate(nums):
                if min_index == -1:
                    min_num = c
                    min_index = i
                else:
                    if c < min_num:
                        min_num = c
                        min_index = i
            nums[min_index] = min_num * multiplier
        return nums