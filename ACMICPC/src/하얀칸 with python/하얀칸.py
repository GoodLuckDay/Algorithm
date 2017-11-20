board = [[0 for i in range(8)] for j in range(8) ]
count = 0
for i in range(8):
    inputStr = input()
    for j in range(8):
        board[i][j] = inputStr[j]

for i in range(8):
    for j in range(8):
        if i%2 == 0 and j%2 == 0 and board[i][j]=="F":
            count = count+1
        elif i%2 == 1 and j%2 == 1 and board[i][j] == "F":
            count = count+1
print(count)

