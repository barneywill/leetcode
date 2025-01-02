class WordPattern:
    def wordPattern(self, pattern: str, s: str) -> bool:
        pattern_len = len(pattern)
        arr = s.split(' ')
        arr_len = len(arr)
        if pattern_len != arr_len:
            return False
        else:
            pattern_dict = {}
            for i, c in enumerate(pattern):
                if pattern_dict.get(c) is None:
                    if arr[i] in pattern_dict.values():
                        return False
                    else:
                        pattern_dict[c] = arr[i]
                elif pattern_dict.get(c) != arr[i]:
                    return False
            return True