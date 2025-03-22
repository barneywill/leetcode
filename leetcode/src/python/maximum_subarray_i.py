from typing import List

class MaximumSubarrayI:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        max_sum = 0
        current_sum = 0.0
        for i, num in enumerate(nums):
            if i < k:
                current_sum += num
                max_sum = current_sum
            else:
                current_sum -= nums[i - k]
                current_sum += num
                if current_sum > max_sum:
                    max_sum = current_sum
        return max_sum / k