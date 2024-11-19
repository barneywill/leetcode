class RomanToInteger:
    def romanToInt(self, s: str) -> int:
        result = 0
        is_skip = False
        for i in range(0, len(s)):
            if is_skip:
                is_skip = False
                continue
            elif s[i] == 'I':
                if i < len(s) - 1:
                    if s[i + 1] == 'V':
                        result += 4
                        is_skip = True
                        continue
                    elif s[i + 1] == 'X':
                        result += 9
                        is_skip = True
                        continue
                    else:
                        result += 1
                else:
                    result += 1
            elif s[i] == 'X':
                if i < len(s) - 1:
                    if s[i + 1] == 'L':
                        result += 40
                        is_skip = True
                        continue
                    elif s[i + 1] == 'C':
                        result += 90
                        is_skip = True
                        continue
                    else:
                        result += 10
                else:
                    result += 10
            elif s[i] == 'C':
                if i < len(s) - 1:
                    if s[i + 1] == 'D':
                        result += 400
                        is_skip = True
                        continue
                    elif s[i + 1] == 'M':
                        result += 900
                        is_skip = True
                        continue
                    else:
                        result += 100
                else:
                    result += 100
            elif s[i] == 'V':
                result += 5
            elif s[i] == 'L':
                result += 50
            elif s[i] == 'D':
                result += 500
            elif s[i] == 'M':
                result += 1000
        return result

if __name__ == '__main__':
    s = 'MCMXCIV'
    r = RomanToInteger()
    print(r.romanToInt(s))