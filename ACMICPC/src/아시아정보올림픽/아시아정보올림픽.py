import Queue
class Student(object):
    def __init__(self,nation,strNum,score):
        self.nation = nation
        self.strNum = strNum
        self.score = score
    def __str__(self):
        return str(self.nation)+" "+str(self.strNum)
    def __cmp__(self, other):
        return other.score > self.score
queue = Queue.PriorityQueue()
N = input()
count = [0]*3
for i in range(N):
    inputStr = raw_input().split()
    nation = int(inputStr[0])
    strNum = int(inputStr[1])
    score = int(inputStr[2])
    queue.put(Student(nation,strNum,score))
for i in range(3):
    student = queue.get()
    if i == 2 and count[0] == count[1]:
        student=queue.get()
    count[i] = student.nation
    print student


