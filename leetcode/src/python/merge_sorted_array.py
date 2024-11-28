from typing import List

class MergeSortedArray:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        if n != 0:
            index1 = 0
            index2 = 0
            while index2 < n:
                if index1 == m + index2:
                    nums1[index1] = nums2[index2]
                    index2 += 1
                else:
                    num1 = nums1[index1]
                    num2 = nums2[index2]
                    if num2 <= num1:
                        nums1.insert(index1, num2)
                        nums1.pop(len(nums1) - 1)
                        index2 += 1
                    index1 += 1

if __name__ == '__main__':
    instance = MergeSortedArray()
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3
    # nums1 = [0]
    # m = 0
    # nums2 = [1]
    # n = 1
    instance.merge(nums1, m, nums2, n)
    print(nums1)