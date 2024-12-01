from typing import List

class MajorityElement:
    def majorityElement(self, nums: List[int]) -> int:
        dic = {}
        majority = int((len(nums) + 1) / 2)
        for num in nums:
            count = dic.get(num)
            if count is not None:
                dic[num] = dic[num] + 1
            else:
                dic[num] = 1
            if dic[num] >= majority:
                return num
        return -1

if __name__ == '__main__':
    instance = MajorityElement()
    nums = [2,2,1,1,1,2,2]
    print(instance.majorityElement(nums))