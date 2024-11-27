class LengthOfLastWrod:
    def lengthOfLastWord(self, s: str) -> int:
        list = s.split(' ')
        for i in range(len(list) - 1, -1, -1):
            if list[i] != '':
                return len(list[i])
        return 0

if __name__ == '__main__':
    instance = LengthOfLastWrod()
    s = '   fly me   to   the moon  '
    print(instance.lengthOfLastWord(s))