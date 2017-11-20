import sys
sys.setrecursionlimit(10**6)
count = 0
M, N = map(int,input().split())
map = [[0 for col in range(N)] for row in range(M)]
visit = [[False for col in range(N)] for row in range(M)]
def BFS(y, x):
    global map
    global visit
    visit[y][x] = True
    if(0<= y-1 <M and 0 <= x-1 <N and not visit[y-1][x-1] and map[y-1][x-1]):
        BFS(y-1,x-1)
    if (0<= y-1 <M and 0 <= x <N and not visit[y - 1][x] and map[y - 1][x]):
        BFS(y - 1, x)
    if (0<= y-1 <M and 0 <= x+1 <N and not visit[y - 1][x + 1] and map[y - 1][x + 1]):
        BFS(y - 1, x + 1)
    if (0<= y <M and 0 <= x-1 <N and not visit[y][x - 1] and map[y][x - 1]):
        BFS(y, x - 1)
    if (0<= y <M and 0 <= x+1 <N and not visit[y][x + 1] and map[y][x + 1]):
        BFS(y, x + 1)
    if (0<= y+1 <M and 0 <= x-1 <N and not visit[y + 1][x - 1] and map[y + 1][x - 1]):
        BFS(y + 1, x - 1)
    if (0<= y+1 <M and 0 <= x <N and not visit[y + 1][x] and map[y + 1][x]):
        BFS(y + 1, x)
    if (0<= y+1 <M and 0 <= x+1 <N and not visit[y + 1][x + 1] and map[y + 1][x + 1]):
        BFS(y + 1, x + 1)
for i in range(M):
    str = input().split()
    for j in range(N):
        map[i][j] = int(str[j])
for i in range(M):
    for j in range(N):
        if(map[i][j] and not visit[i][j]):
            count= count+1
            BFS(i, j)
print(count)



