N = input()
result = [[0 for i in range(4)] for i in range(1001)]
RGB = [[0 for i in range(4)] for i in range(N+1)]
for i in range(1,N+1):
    inputStr = raw_input().split()
    for j in range(1,4):
        RGB[i][j] = int(inputStr[j-1])
for i in range(1,4):
    result[1][i] = RGB[1][i]
for i in range(2,N+1):
    result[i][1] = RGB[i][1]+min(result[i-1][2],result[i-1][3])
    result[i][2] = RGB[i][2] + min(result[i - 1][1], result[i - 1][3])
    result[i][3] = RGB[i][3] + min(result[i - 1][1], result[i - 1][2])
minVal = []
for i in range(3):
    minVal.append(result[N][i+1])
print min(minVal)
