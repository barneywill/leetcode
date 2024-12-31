# The isBadVersion API is already defined for you.
def isBadVersion(version: int) -> bool:
    return True

class FirstBadVersion:
    def firstBadVersionInRange(self, start: int, end: int) -> int:
        if end <= start:
            return start
        elif isBadVersion(start):
            return start
        else:
            middle = int((start + end) / 2)
            if isBadVersion(middle):
                if isBadVersion(middle - 1):
                    return self.firstBadVersionInRange(start, middle - 1)
                else:
                    return middle
            else:
                return self.firstBadVersionInRange(middle + 1, end)
    def firstBadVersion(self, n: int) -> int:
        return self.firstBadVersionInRange(1, n)