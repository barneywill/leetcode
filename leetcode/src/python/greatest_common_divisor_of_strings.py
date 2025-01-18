class GreatestCommonDivisorOfStrings2:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        len_str1 = len(str1)
        len_str2 = len(str2)
        if len_str1 == len_str2:
            if str1 == str2:
                return str1
            else:
                return ''
        elif str1[0] != str2[0]:
            return ''
        else:
            cd1 = self.getCD(str1)
            cd2 = self.getCD(str2)
            if cd1 == cd2:
                return cd1
            else:
                return ''

    def getCD(self, s: str) -> str:
        len_s = len(s)
        cd = ''
        first_letter = ''
        for i, v in enumerate(s):
            if cd == '':
                cd += v
                first_letter = v
            else:
                len_cd = len(cd)
                if v == first_letter and len_s % len_cd == 0:
                    times = int(len_s / len_cd)
                    is_match = True
                    for i, v in enumerate(cd):
                        for j in range(1, times):
                            if cd[i] != s[i + j * len_cd]:
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