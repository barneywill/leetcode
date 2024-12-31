class MissingNumber:
    def missingNumber(self, nums: List[int]) -> int:
        actual_sum = sum(nums)
        expect_sum = sum(range(len(nums) + 1))
        return expect_sum - actual_sum