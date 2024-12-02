class IsomorphicStrings:
    def isIsomorphic(self, s: str, t: str) -> bool:
        dic = {}
        for i, c in enumerate(s):
            if dic.get(c) is not None:
                if dic[c] != t[i]:
                    return False
            else:
                if t[i] in dic.values():
                    return False
                else:
                    dic[c] = t[i]
        return True

if __name__ == '__main__':
    instance = IsomorphicStrings()
    s = 'badc'
    t = 'baba'
    print(instance.isIsomorphic(s, t))