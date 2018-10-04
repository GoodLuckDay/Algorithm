N = int(input())
data = []
info = [set() for i in range(3)]
Rinfo = [set() for i in range(3)]
for i in range(N):
    inputData = list(map(int, input().split(" ")))
    for i in range(3):
        if inputData[i] in info[i]:
            Rinfo[i].add(inputData[i])
        else:
            info[i].add(inputData[i])
    data.append(inputData)

for i in range(N):
    result = 0
    for j in range(3):
        if data[i][j] not in Rinfo[j]:
            result = result + data[i][j]
    print(result)
