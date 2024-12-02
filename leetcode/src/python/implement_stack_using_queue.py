class MyStack:
    queue1 = []
    queue2 = []
    last_item = None
    def __init__(self):
        print('')
    def push(self, x: int) -> None:
        self.queue1.append(x)
        self.last_item = x
    def pop(self) -> int:
        while len(self.queue1) > 2:
            self.queue2.append(self.queue1.pop(0))
        if len(self.queue1) > 1:
            self.last_item = self.queue1.pop(0)
            self.queue2.append(self.last_item)
        pop_item = self.queue1.pop(0)
        tmp = self.queue1
        self.queue1 = self.queue2
        self.queue2 = tmp
        if len(self.queue1) == 0:
            self.last_item = None
        return pop_item
    def top(self) -> int:
        return self.last_item
    def empty(self) -> bool:
        result = len(self.queue1) == 0
        self.queue1.clear()
        return result

if __name__ == '__main__':
    instance = MyStack()
    instance.push(1)
    # instance.push(2)
    # print('top: ', instance.top())
    print('pop: ', instance.pop())
    print(instance.empty())