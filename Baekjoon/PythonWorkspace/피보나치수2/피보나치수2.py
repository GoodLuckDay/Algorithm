def fibonachi(N):
    global memoization
    if memoization[N] != -1:
        return memoization[N]
    memoization[N] = fibonachi(N-1) + fibonachi(N-2)
    return memoization[N]
N = int(input())
memoization = [-1] * 91
memoization[0] = 0
memoization[1] = 1
print(fibonachi(N))


