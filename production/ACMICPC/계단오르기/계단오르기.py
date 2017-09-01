T = input()
scores = [0]*(T+1)
result = [[0 for i in range(3)] for j in range(T+1)]
for i in range(1,T+1):
    scores[i]=input()
result[1][1]=scores[1]
result[1][2]=scores[1]
for i in range(2,T+1):
    result[i][1]=result[i-1][2]+scores[i]
    result[i][2]=max(result[i-2][1],result[i-2][2])+scores[i]
print max(result[T])