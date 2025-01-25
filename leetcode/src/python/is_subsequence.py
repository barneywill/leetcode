class IsSubsequence:
    def isSubsequence(self, s: str, t: str) -> bool:
        last_index = 0
        for i, v in enumerate(s):
            is_found = False
            if last_index >= len(t):
                return False
            for j in range(last_index, len(t)):
                if v == t[j]:
                    last_index = j + 1
                    is_found = True
                    break
            if not is_found:
                return False
        return True