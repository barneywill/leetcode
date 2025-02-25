class ReverseWordsInAString:
    def reverseWords(self, s: str) -> str:
        result = ''
        arr = s.split()
        for i in range(len(arr) - 1, -1, -1):
            if (arr[i] != ''):
                result += ' ' + arr[i]
        result = result[1:]
        return result