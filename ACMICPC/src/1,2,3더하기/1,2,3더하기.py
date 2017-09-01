numbers = [0]*12
numbers[1]=1
numbers[2]=2
numbers[3]=4
for i in range(4,12):
    numbers[i]=numbers[i-1]+numbers[i-2]+numbers[i-3]
T =input()
for j in range(T):
    n = input()
    print numbers[n]