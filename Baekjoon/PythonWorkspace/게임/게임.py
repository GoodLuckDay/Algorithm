class Point:
    pointY = 0
    pointX = 0
    level = 0

    def __init__(self, y, x, level):
        self.pointX = x
        self.pointY = y
        self.level = level


N, M = map(int, input().split(" "))
board = [list() for i in range(N)]
direction = [[0, 1], [-1, 0], [0, -1], [1, 0]]
queue = list()

for i in range(N):
    board[i] = list(input())

queue.append(Point(0, 0, 0))
maxLevel = -1
isInfinite = False
while (len(queue) != 0 and not isInfinite):
    temp = queue.pop(0)
    pointY = temp.pointY
    pointX = temp.pointX
    level = temp.level + 1
    number = board[pointY][pointX]
    for dirY, dirX in direction:
        tempY = pointY - dirY * int(number)
        tempX = pointX - dirX * int(number)
        if 0 <= tempY < N and 0 <= tempX < M and board[tempY][tempX] is not 'H':
            queue.append(Point(tempY, tempX, level))
            if maxLevel > N * M + 1:
                isInfinite = True
                break
        else:
            if maxLevel < level:
                maxLevel = level

print(-1 if isInfinite else maxLevel)
