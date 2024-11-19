from typing import List

class TwoSum:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(0, len(nums) - 1):
            num = target - nums[i]
            for j in range(i + 1, len(nums)):
                if nums[j] == num:
                    return [i, j]
        return []

if __name__ == '__main__':
    nums = [2, 7, 11, 15]
    target = 9
    s = TwoSum()
    print(s.twoSum(nums, target))