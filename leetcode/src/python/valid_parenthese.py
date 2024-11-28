class ValidParenthese:
    def isValid(self, s: str) -> bool:
        stack = []
        for i, c in enumerate(s):
            if len(stack) == 0:
                stack.append(c)
            else:
                last = stack[0]
                if self.is_start(last) and self.is_start(c):
                    stack.insert(0, c)
                    continue
                elif self.is_match(last, c):
                    stack.pop(0)
                    continue
                else:
                    return False
        return len(stack) == 0
    def is_start(self, c: str) -> bool:
        return c == '{' or c == '[' or c == '('
    def is_match(self, c1: str, c2: str) -> bool:
        return (c1 == '{' and c2 == '}') or (c1 == '[' and c2 == ']') or (c1 == '(' and c2 == ')')


if __name__ == '__main__':
    instance = ValidParenthese()

    s = '([])'
    print(instance.isValid(s))