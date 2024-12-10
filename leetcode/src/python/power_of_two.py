class PowerOfTwo:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False
        elif n == 1:
            return True
        else:
            while n > 1:
                if n % 2 == 1:
                    return False
                else:
                    n = n / 2
            return True