H, W = map(int, input().split())
watermap = [[0]*W for i in range(H)]
inputStr=(list(map(int, input().split())))
index = 0
for i in inputStr:
    for j in range(i):
        watermap[j][index] = 1
    index = index+1

count = 0
for i in range(H):
    for j in range(W):
        if watermap[i][j] == 0 and j != 0:
            left = j
            while left >= 0 and watermap[i][left] == 0:
                left = left - 1
            right = j
            while right < W and watermap[i][right] == 0:
                watermap[i][j] = 1
                j = j+1
                right = j
            count = count + (right - left -1) if right != W and left >=0 else count

print(count)

