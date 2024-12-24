class ValidAnagram:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        elif s == t:
            return True
        letter_dict_s = {}
        for i, c in enumerate(s):
            if letter_dict_s.get(c) is None:
                letter_dict_s[c] = 1
            else:
                letter_dict_s[c] += 1
        letter_dict_t = {}
        for i, c in enumerate(t):
            if letter_dict_s.get(c) is None:
                return False
            elif letter_dict_t.get(c) is None:
                letter_dict_t[c] = 1
            else:
                letter_dict_t[c] += 1
        for key_s in letter_dict_s:
            if letter_dict_t.get(key_s) is None or letter_dict_t[key_s] != letter_dict_s[key_s]:
                return False
        return True