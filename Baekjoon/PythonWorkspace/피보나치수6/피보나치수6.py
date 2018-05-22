import sys
sys.setrecursionlimit(1000000)


def calc(N):
    if N == 1:
        return [[1,1], [1, 0]]
    elif N % 2 == 0:
        temp = calc(N//2)
        x1 = (temp[0][0] * temp[0][0] + temp[0][1] * temp[1][0]) % 1000000007
        x2 = (temp[0][0] * temp[0][1] + temp[0][1] * temp[1][1]) % 1000000007
        x3 = (temp[1][0] * temp[0][0] + temp[1][1] * temp[1][0]) % 1000000007
        x4 = (temp[1][0] * temp[0][1] + temp[1][1] * temp[1][1]) % 1000000007
        return [[x1, x2], [x3, x4]]
    else:
        temp = calc(N-1)
        x1 = (temp[0][0] + temp[0][1]) % 1000000007
        x2 = (temp[0][0]) % 1000000007
        x3 = (temp[0][0]) % 1000000007
        x4 = (temp[1][0]) % 1000000007
        return [[x1, x2], [x3, x4]]

n = int(input())
print(calc(n)[0][1])


