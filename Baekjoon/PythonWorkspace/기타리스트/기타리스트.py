N, S, M = list(map(int, input().split()))
V = list(map(int, input().split()))
ans = [[False for i in range(M+1)] for i in range(N+1)]
ans[0][S] = True
for i in range(N):
    volume = V.pop(0)
    for j in range(M+1):
        if ans[i][j]:
            if j-volume>=0:
                ans[i+1][j-volume] = True
            if j+volume<=M:
                ans[i+1][j+volume] = True

maxIndex = -1
for i in range(len(ans[N])-1,-1,-1):
    if ans[N][i]:
        maxIndex = i
        break
print(maxIndex)