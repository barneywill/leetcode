class UglyNumber:
    def isUgly(self, n: int) -> bool:
        ls = [2, 3, 5]
        if n <= 0:
            return False
        while n > 1:
            is_match = False
            for i in ls:
                if n % i == 0:
                    is_match = True
                    n = n / i
            if not is_match and n not in ls:
                print(n)
                return False
        return True

if __name__ == '__main__':
    instance = UglyNumber()
    print(instance.isUgly(-2147483648))