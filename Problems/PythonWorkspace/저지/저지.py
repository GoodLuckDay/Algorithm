##문제를 착각했다 최적의 값을 구해야 하는데 그냥 보통의 경우로 해버렸다.
J = int(input())
A = int(input())
count = 0
cloth = {"S" : 0, "M" : 0, "L" : 0}

numberOfCloth = [True] * (J + 1)

for i in range(J):
    size = input()
    cloth[size] = cloth[size] + 1

for i in range(A):
    size, number = input().split(" ")
    number = int(number)
    if cloth[size] > 0 and numberOfCloth[number]:
        count = count + 1
        cloth[size] = cloth[size] - 1
        numberOfCloth[number] = False

print(count)


