from typing import List

class PascalsTriangle:
    def generate(self, numRows: int) -> List[List[int]]:
        result = []
        if numRows >= 1:
            result.append([1])
        if numRows >= 2:
            result.append([1, 1])
        if numRows >= 3:
            last_list = result[len(result) - 1]
            for i in range(numRows - 2):
                current_list = [1]
                for j in range(len(last_list) - 1):
                    current_list.append(last_list[j] + last_list[j + 1])
                current_list.append(1)
                result.append(current_list)
                last_list = current_list
        return result

if __name__ == '__main__':
    instance = PascalsTriangle()
    numRows = 5
    print(instance.generate(numRows))
