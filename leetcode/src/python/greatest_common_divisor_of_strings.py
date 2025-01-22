class GreatestCommonDivisorOfStrings2:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        len_str1 = len(str1)
        len_str2 = len(str2)
        if len_str1 == len_str2:
            if str1 == str2:
                return str1
            else:
                return ''
        elif str1[0] != str2[0] or str1[-1] != str2[-1]:
            return ''
        elif len_str1 > len_str2 and not str1.startswith(str2):
            return ''
        elif len_str1 < len_str2 and not str2.startswith(str1):
            return ''
        else:
            scd1 = self.getSCD(str1)
            if (str2.startswith(scd1)):
                scd2 = self.getSCD(str2)
                if scd1 == scd2:
                    len_cd = len(scd1)
                    times_str1 = int(len_str1 / len_cd)
                    times_str2 = int(len_str2 / len_cd)
                    gcd = self.getGCD(times_str1, times_str2)
                    result = scd1
                    for i in range(1, gcd):
                        result += scd1
                    return result
                else:
                    return ''
            else:
                return ''

    def getGCD(self, num1: int, num2: int) -> int:
        n1 = max(num1, num2)
        n2 = min(num1, num2)
        while n2 != 0:
            n1, n2 = n2, n1 % n2
        return n1

    def getSCD(self, s: str) -> str:
        len_s = len(s)
        cd = ''
        first_letter = ''
        is_same = True
        for i, v in enumerate(s):
            if first_letter == '':
                first_letter = v
            else:
                if v != first_letter:
                    is_same = False
                    break
        if is_same:
            return first_letter
        else:
            for i, v in enumerate(s):
                if cd == '':
                    cd += v
                    first_letter = v
                elif i > len_s / 2:
                    cd = s
                    break
                else:
                    len_cd = len(cd)
                    if v == first_letter and len_s % len_cd == 0:
                        times = int(len_s / len_cd)
                        is_match = True
                        for j in range(len_cd):
                            for k in range(1, times):
                                if cd[j] != s[j + k * len_cd]:
                                    is_match = False
                                    break
                            if not is_match:
                                break
                        if is_match:
                            return cd
                        else:
                            cd += v
                    else:
                        cd += v
        return cd

if __name__ == '__main__':
    instance = GreatestCommonDivisorOfStrings2()
    #cd = instance.getCD("BXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKMBXDCPBACKM")
    #cd = instance.getCD('AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA')
    cd = instance.gcdOfStrings("ABABAB", "AB")
    #cd = instance.getSCD("AB")
    print(cd)