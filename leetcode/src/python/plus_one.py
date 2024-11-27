from typing import List

class PlusOne:
    def plusOne(self, digits: List[int]) -> List[int]:
        left = 1
        for i in range(len(digits) - 1, -1, -1):
            if left == 0:
                break
            else:
                sum = digits[i] + left
                if sum < 10:
                    digits[i] = sum
                    left = 0
                else:
                    digits[i] = 0
                    left = 1
        if left == 1:
            digits.insert(0, 1)
        return digits

if __name__ == '__main__':
    instance = PlusOne()
    digits = [9]
    print(instance.plusOne(digits))
