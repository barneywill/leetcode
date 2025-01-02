class MoveZeroes:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        last_index = -1
        zero_nums = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[last_index + 1] = nums[i]
                last_index += 1
            else:
                zero_nums += 1
        for i in range(zero_nums):
            nums[len(nums) - 1 - i] = 0