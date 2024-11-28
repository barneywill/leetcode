class FindTheIndexOfTheFirstOccurrenceInAString:
    def strStr(self, haystack: str, needle: str) -> int:
        for i in range(0, len(haystack) - len(needle) + 1):
            is_found = True
            for j in range(0, len(needle)):
                if haystack[i + j] != needle[j]:
                    is_found = False
                    break
            if is_found:
                return i
        return -1