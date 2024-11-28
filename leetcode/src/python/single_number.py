from typing import List

class SingleNumber:
    def singleNumber(self, nums: List[int]) -> int:
        s = set()
        for num in nums:
            if num in s:
                s.remove(num)
            else:
                s.add(num)
        return s.pop()

if __name__ == '__main__':
    instance = SingleNumber()
    nums = [4, 1, 2, 1, 2]
    print(instance.singleNumber(nums))