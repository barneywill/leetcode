from typing import List

class ContainsDuplicate2:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        dic = {}
        for i, c in enumerate(nums):
            if dic.get(c) is None:
                dic[c] = [i]
            else:
                ls = dic[c]
                if abs(ls[len(ls) - 1] - i) <= k:
                    return True
                else:
                    dic[c].append(i)
        # for key in dic.keys():
        #     ls = dic[key]
        #     if len(ls) > 1:
        #         for i in range(0, len(ls) - 1):
        #             if abs(ls[i] - ls[i + 1]) <= k:
        #                 return True
        return False

if __name__ == '__main__':
    instance = ContainsDuplicate2()
    nums = [1,2,3,1]
    k = 3
    print(instance.containsNearbyDuplicate(nums, k))