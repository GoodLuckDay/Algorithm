import Queue
class Homework:
    def __init__(self,D,T):
        self.D = D
        self.T = T
    def __cmp__(self, other):
        return self.T < other.T
    def __str__(self):
        return str(self.T)
N=input()
queue = Queue.PriorityQueue()
for i in range(N):
    inputStr = raw_input().split()
    homework = Homework(int(inputStr[0]),int(inputStr[1]))
    queue.put(homework)
result = [False]*(10**6+1)
while queue.empty() == False :
    temp = queue.get()
    i = 0
    while(temp.D>0):
        if result[temp.T-i] is False:
            result[temp.T - i] = True
            temp.D = temp.D - 1
        i = i + 1
counts = []
count = 0
for i in range(1,len(result)):
    if result[i] is False:
        count=count+1
    else:
        counts.append(count)
        count= 0
print counts