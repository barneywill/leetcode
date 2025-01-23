class ReverseVowelsOfAString:
    def reverseVowels(self, s: str) -> str:
        result = ""
        vowel_list = []
        for i in range(len(s)):
            if self.isVowel(s[i]):
                vowel_list.append(s[i])
        for i in range(len(s)):
            if self.isVowel(s[i]):
                result += vowel_list.pop(-1)
            else:
                result += s[i]
        return result

    vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
    def isVowel(self, v: str) -> bool:
        return v in self.vowels