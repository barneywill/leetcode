class ExcelSheetColumnNumber:
    def titleToNumber(self, columnTitle: str) -> int:
        result = 0
        ab = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        ls = []
        dic = {}
        for i, c in enumerate(ab):
            ls.append(c)
            dic[c] = i + 1
        base = 1
        for i in range(len(columnTitle) - 1, -1, -1):
            result += base * dic.get(columnTitle[i])
            base *= 26
        return result

if __name__ == '__main__':
    instance = ExcelSheetColumnNumber()
    columnTitle = 'AB'
    print(instance.titleToNumber(columnTitle))