class NextPermutation:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index = -1
        for i in range(len(nums) - 1, 0, -1):
            if nums[i] > nums[i - 1]:
                if i < len(nums) - 1:
                    for j in range(len(nums) - 1, i, -1):
                        if nums[j] > nums[i - 1]:
                            index = j
                            break
                index = index if index > 0 else i
                tmp = nums[index]
                nums[index] = nums[i - 1]
                nums[i - 1] = tmp
                index = i
                break
        index = 0 if index == -1 else index
        sort_nums = sorted(nums[index:])
        for i in range(index, len(nums)):
            nums[i] = sort_nums[i - index]