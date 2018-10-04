apart = [[0 for i in range(15)] for j in range(15)]
for i in range(15):
    apart[0][i] = i
for i in range(1,15):
    apart[i][1]=apart[i-1][1]
    for j in range(2,15):
        apart[i][j]=apart[i][j-1]+apart[i-1][j]
T = input()
for k in range(T):
    k = input()
    n = input()
    print(apart[k][n])
