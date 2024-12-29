class AddDigits:
    def addDigits(self, num: int) -> int:
        result = 0
        while num > 0:
            result += num % 10
            num = int(num / 10)
        if result >= 10:
            result = self.addDigits(result)
        return result