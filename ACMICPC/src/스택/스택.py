class Stack:
    def __init__(self):
        self._stack = [0]*10001
        self._top = -1
    def push(self,number):
        self._stack[self._top+1] = number
        self._top = self._top + 1
    def top(self):
        if self._top == -1:
            return -1
        return self._stack[self._top]
    def size(self):
        return self._top+1
    def empty(self):
        if self._top == -1:
            return 1
        else:
            return 0
    def pop(self):
        if self.empty() == 0 :
            temp = self._stack[self._top]
            self._top = self._top - 1
            return temp
        else:
            return -1

inputNum = input()
myStack = Stack()
for i in range(0,inputNum):
    str = raw_input().split()
    if str[0] == "push" :
        myStack.push(str[1])
    elif str[0] == "pop":
        print myStack.pop()
    elif str[0] == "size":
        print myStack.size()
    elif str[0] == "empty":
        print myStack.empty()
    elif str[0] == "top":
        print myStack.top()




