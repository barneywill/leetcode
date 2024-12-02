class HappyNumber:
    def isHappy(self, n: int) -> bool:
        i = 0
        sm = n
        while i < 1000:
            sm = self.get_square_sum(sm)
            if sm == 1:
                return True
            else:
                i += 1
        return False
    def get_square_sum(self, n: int) -> int:
        result = 0
        while n > 0:
            left = int(n % 10)
            result += left * left
            n = int(n / 10)
        return result

if __name__ == '__main__':
    instance = HappyNumber()
    n = 2
    print(instance.isHappy(n))