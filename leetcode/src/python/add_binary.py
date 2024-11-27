class AddBinary:
    def addBinary(self, a: str, b: str) -> str:
        result = ''
        maxLen = max(len(a), len(b))
        left = 0
        for i in range(0, maxLen):
            itemA = 0 if i > len(a) - 1 else int(a[len(a) - 1 - i])
            itemB = 0 if i > len(b) - 1 else int(b[len(b) - 1 - i])
            sum = itemA + itemB + left
            if sum > 1:
                result = str(sum - 2) + result
                left = 1
            else:
                result = str(sum) + result
                left = 0
        if left == 1:
            result = '1' + result
        return result

if __name__ == '__main__':
    instance = AddBinary()
    a = '1111'
    b = '1111'
    print(instance.addBinary(a, b))
