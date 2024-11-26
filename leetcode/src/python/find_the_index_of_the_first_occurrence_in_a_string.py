class FindTheIndexOfTheFirstOccurrenceInAString:
    def strStr(self, haystack: str, needle: str) -> int:
        for i in range(0, len(haystack) - len(needle) + 1):
            isFound = True
            for j in range(0, len(needle)):
                if haystack[i + j] != needle[j]:
                    isFound = False
                    break
            if isFound:
                return i
        return -1