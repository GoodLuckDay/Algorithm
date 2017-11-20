import sys
sys.setrecursionlimit(1000000)
def solve(n, k):
    global values, memoization
    if n == 0 or memoization[n][k] != 0:
        return memoization[n][k]
    elif k == 0:
        return 1
    elif k < values[n]:
        memoization[n][k] = solve(n-1, k)
        return memoization[n][k]
    else:
        memoization[n][k] = solve(n-1,k) + solve(n,k-values[n])
    return memoization[n][k]
n, k = map(int, input().split())
values = []
values.append(0)
for i in range(n):
    values.append(int(input()))
memoization = [[0 for i in range(k+3)] for i in range(n+3)]
print(solve(n, k))