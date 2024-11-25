from typing import List

class RemoveDuplicatesFromSortedArray:
    def removeDuplicates(self, nums: List[int]) -> int:
        result = len(nums)
        for i in range(result - 1, 0, -1):
            if nums[i] == nums[i - 1]:
                nums.pop(i)
                result -= 1
        return result

if __name__ == '__main__':
    instance = RemoveDuplicatesFromSortedArray()
    nums = [0,0,1,1,1,2,2,3,3,4]
    print(instance.removeDuplicates(nums))