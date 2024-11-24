class ValidParenthese:
    def isValid(self, s: str) -> bool:
        stack = []
        for i, c in enumerate(s):
            if len(stack) == 0:
                stack.append(c)
            else:
                last = stack[0]
                if (last == '{' or last == '[' or last == '(') and (c == '{' or c == "[" or c == '('):
                    stack.insert(0, c)
                    continue
                elif (last == '{' and c == '}') or (last == '[' and c == ']') or (last == '(' and c == ')'):
                    stack.pop(0)
                    continue
                else:
                    return False
        return len(stack) == 0

if __name__ == '__main__':
    instance = ValidParenthese()

    s = '([])'
    print(instance.isValid(s))