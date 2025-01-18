class MergeStringAlternately:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result = ''
        len_word1 = len(word1)
        len_word2 = len(word2)
        len_min = min(len_word1, len_word2)
        for i in range(len_min):
            result += word1[i] + word2[i]
        if len_word1 > len_min:
            for i in range(len_min, len_word1):
                result += word1[i]
        if len_word2 > len_min:
            for i in range(len_min, len_word2):
                result += word2[i]
        return result