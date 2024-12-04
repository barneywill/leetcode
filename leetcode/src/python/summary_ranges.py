from typing import List

class SummaryRanges:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        result = []
        current = ''
        start = 0
        for i in range(len(nums)):
            if current == '':
                start = nums[i]
                current = str(start)
            else:
                if nums[i] - nums[i - 1] > 1:
                    if start != nums[i - 1]:
                        current += '->' + str(nums[i - 1])
                    result.append(current)
                    start = nums[i]
                    current = str(start)
            if i == len(nums) - 1:
                if start != nums[i]:
                    current += '->' + str(nums[i])
                result.append(current)
        return result

if __name__ == '__main__':
    instance = SummaryRanges()
    #nums = [0,2,3,4,6,8,9]
    nums = [0,1,2,4,5,7]
    print(instance.summaryRanges(nums))