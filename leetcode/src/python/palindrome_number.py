class PalindromeNumber:
    def isPalindrome(self, x: int) -> bool:
        s = str(x)
        for i, c in enumerate(s):
            j = len(s) - 1 - i
            if i > j:
                break
            if c != s[j]:
                return False
        return True

if __name__ == '__main__':
    x = 1231
    p = PalindromeNumber()
    print(p.isPalindrome(x))