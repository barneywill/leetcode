from typing import List

class LongestCommonPrefix:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        result = ''
        is_first = True
        for s in strs:
            if result == '':
                if is_first:
                    result = s
                    is_first = False
                else:
                    break
            else:
                prefix = ''
                for i, c in enumerate(result):
                    if i < len(s) and c == s[i]:
                        prefix += c
                    else:
                        break
                result = prefix
        return result

if __name__ == '__main__':
    #strs = ['flower','flow','flight']
    strs = ["dog","racecar","car"]
    instance = LongestCommonPrefix()
    print(instance.longestCommonPrefix(strs))