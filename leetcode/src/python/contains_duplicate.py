from typing import List

class ContainsDuplicate:
    def containsDuplicate(self, nums: List[int]) -> bool:
        s = set()
        for num in nums:
            if num in s:
                return True
            else:
                s.add(num)
        return False