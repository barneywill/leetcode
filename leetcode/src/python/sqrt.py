class Sqrt:
    def mySqrt(self, x: int) -> int:
        l = len(str(x))
        if l % 2 == 0:
            min = int(10 ** ((l / 2) - 1))
            for i in range(min, min * 10):
                if i * i > x:
                    return i - 1
        else:
            max = int(10 ** ((l + 1) / 2))
            for i in range(max, -1, -1):
                if i * i <= x:
                    return i
        return 0

if __name__ == '__main__':
    instance = Sqrt()
    x = 10
    print(instance.mySqrt(x))