class LongestSubstringWithoutRepeatingCharacters:
    def lengthOfLongestSubstring(self, s: str) -> int:
        result = 0
        s_len = len(s)
        if s_len <= 1:
            result = s_len
        else:
            sub_str = []
            for i, v in enumerate(s):
                if v in sub_str:
                    while True:
                        letter = sub_str.pop(0)
                        if letter == v:
                            break
                sub_str.append(v)
                if len(sub_str) > result:
                    result = len(sub_str)
        return result
    # TODO: 
    def lengthOfLongestSubstring1(self, s: str) -> int:
        result = 0
        s_len = len(s)
        if s_len <= 1:
            result = s_len
        else:
            letter_dict = {}
            is_match = False
            for i, v in enumerate(s):
                if letter_dict.get(v) is None:
                    letter_dict[v] = [i]
                else:
                    is_match = True
                    gap = i - letter_dict[v][- 1]
                    letter_dict[v].append(i)
                    if gap > result:
                        result = gap
            if not is_match:
                result = s_len
            else:
                for v in letter_dict.values():
                    gap = s_len - v[-1]
                    if gap > result:
                        result = gap
        return result