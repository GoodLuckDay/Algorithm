N = input()
inputStr = raw_input().split()
A = [0]*(N+1)
result = [1]*(N+1)
for i in range(1,N+1):
    A[i]=int(inputStr[i-1])
for i in range(1,N):
    for j in range(i+1,N+1):
        if(A[i] < A[j]):
            result[j]=max(result[i]+1,result[j])
print max(result)
