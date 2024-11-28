from typing import List

class PascalsTriangle2:
    def getRow(self, rowIndex: int) -> List[int]:
        result = []
        if rowIndex == 0:
            result = [1]
        elif rowIndex == 1:
            result = [1, 1]
        else:
            last_list = [1, 1]
            for i in range(rowIndex - 1):
                current_list = [1]
                for j in range(len(last_list) - 1):
                    current_list.append(last_list[j] + last_list[j + 1])
                current_list.append(1)
                result = current_list
                last_list = current_list
        return result

if __name__ == '__main__':
    instance = PascalsTriangle2()
    rowIndex = 3
    print(instance.getRow(rowIndex))