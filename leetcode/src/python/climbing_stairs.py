class ClimbingStairs:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        elif n == 2:
            return 2
        else:
        #     return self.climbStairs(n - 1) + self.climbStairs(n - 2)
            result = 0
            last1 = 1
            last2 = 2
            for i in range(3, n + 1):
                result = last1 + last2
                last1 = last2
                last2 = result
            return result