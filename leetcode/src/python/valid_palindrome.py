class ValidPalindrome:
    def isPalindrome(self, s: str) -> bool:
        new_s = ''
        for i, c in enumerate(s):
            if c.isalnum():
                new_s += c.lower()

        for i in range(len(new_s)):
            if i <= len(new_s) - 1 - i and new_s[i] != new_s[len(new_s) - 1 - i]:
                return False
        return True

if __name__ == '__main__':
    instance = ValidPalindrome()
    #s = 'A man, a plan, a canal: Panama'
    s = '0P'
    print(instance.isPalindrome(s))