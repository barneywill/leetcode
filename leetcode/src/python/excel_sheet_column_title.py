class ExcelSheetColumnTitle:
    def convertToTitle(self, columnNumber: int) -> str:
        # result = []
        ab = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        ls = []
        # dic = {}
        for i, c in enumerate(ab):
            ls.append(c)
        #     dic[c] = i
        # for i in range(columnNumber):
        #     if len(result) == 0:
        #         result.append('A')
        #     else:
        #         for i in range(len(result)):
        #             if result[i] == 'Z':
        #                 result[i] = 'A'
        #                 if i == len(result) - 1:
        #                     result.append('A')
        #             else:
        #                 result[i] = ls[dic[result[i]] + 1]
        #                 break
        s = ''
        # for i in range(len(result) - 1, -1, -1):
        #     s += result[i]
        while columnNumber > 26:
            rest = int(columnNumber % 26)
            s = ls[rest - 1] + s
            columnNumber = int(columnNumber / 26)
            if rest == 0:
                columnNumber -= 1
        s = ls[columnNumber - 1] + s
        return s



if __name__ == '__main__':
    instance = ExcelSheetColumnTitle()
    columnNum = 53
    print(instance.convertToTitle(columnNum))
