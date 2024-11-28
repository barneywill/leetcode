class LengthOfLastWrod:
    def lengthOfLastWord(self, s: str) -> int:
        ls = s.split(' ')
        for i in range(len(ls) - 1, -1, -1):
            if ls[i] != '':
                return len(ls[i])
        return 0

if __name__ == '__main__':
    instance = LengthOfLastWrod()
    s = '   fly me   to   the moon  '
    print(instance.lengthOfLastWord(s))