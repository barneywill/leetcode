class NimGame:
    def canWinNim(self, n: int) -> bool:
        return n % 4 <= 3 and n % 4 >= 1