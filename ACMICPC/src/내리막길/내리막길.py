size = raw_input().split()
M = int(size[0])
N = int(size[1])
Map = [[0 for i in range(N+1)]for j in range(M+1)]
result = [[0 for i in range(N+1)]for j in range(M+1)]
for i in range(1,M+1):
    inputStr = raw_input().split()
    for j in range(1,N+1):
        Map[i][j] = inputStr[j-1]
result[1][1] = 1
route = 1
for i in range(1,M+1):
    for j in range(1,N+1):
        if i == M and j !=N :
            if Map[i][j] > Map[i-1][j]:
                result[i-1][j]= 1
            if Map[i][j] > Map[i][j+1]:
                result[i][j+1]=1
            if Map[i][j] > Map[i - 1][j] and Map[i][j] > Map[i][j + 1]:
                result[i - 1][j] = result[i][j + 1] = 1
                route += 1
        elif j == N and i != M:
            if Map[i][j] > Map[i+1][j]:
                result[i+1][j]= 1
            if Map[i][j] > Map[i][j-1]:
                result[i][j-1]=1
            if Map[i][j] > Map[i + 1][j] and Map[i][j] > Map[i][j - 1]:
                result[i + 1][j] = result[i][j - 1] = 1
                route += 1
        elif j != N and result[i][j] != 0 :
            if Map[i][j] > Map[i+1][j]:
                result[i+1][j] = 1
            if Map[i][j] > Map[i][j+1]:
                result[i][j+1] = 1
            if Map[i][j] > Map[i+1][j] and Map[i][j] > Map[i][j+1]:
                result[i + 1][j]=result[i][j+1]= 1
                route +=1


print route