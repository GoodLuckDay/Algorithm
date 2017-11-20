import math
def iscanuse(x):
    if x==1 or x==2:
        return True
    if x % 2 == 0:
        return False
    else:
        for i in range(3,int(math.sqrt(x))+1,2):
            if x % i == 0:
                return False
        return True

inputNumber = input()
k = 0
numbers = []
result = []
for i in range(inputNumber):
    numbers.append(input())
for i in numbers :
     k = int(math.sqrt(i))
     while len(result) is not 1:
         if iscanuse(k) is True:
             result.append(k)
             i = i-k
     for j in range(k+1,i):
         if iscanuse(j) is True and len(result) is not 3:
             if iscanuse(i-j) is True and k + j+i-j== i+k :
                 result.append(j)
                 result.append(i-j)
     result.sort()
     for num in result:
         if len(result) == 3 :
             print num,
         else:
             print 0,
     print ' '
     result = []




