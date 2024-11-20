from typing import List

class LongestCommonPrefix:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        result = ''
        is_first = True
        for str in strs:
            if result == '':
                if is_first:
                    result = str
                    is_first = False
                else:
                    break
            else:
                prefix = ''
                for i, c in enumerate(result):
                    if i < len(str) and c == str[i]:
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