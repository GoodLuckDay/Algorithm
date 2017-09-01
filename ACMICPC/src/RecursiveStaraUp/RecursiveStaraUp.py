def func(N,n,count,result):
    global numbers
    global max
    if N<n:
        return result
    if count==3:
        return result
    result += numbers[n]
    temp = func(N,n+1,count+1,result)
    if max < temp:
        max = temp
    temp = func(N,n+2,1,result)
    if max < temp:
        max = temp
    return result
N = input()
max = 0
numbers = [0]*(N+1)
for i in range(1,N+1):
    numbers[i] = input()
print func(N,1,1,max)


