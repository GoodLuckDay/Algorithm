N, K = list(map(int, input().split(" ")))
multiTab = list(map(int, input().split(" ")))
avail = list(map(lambda x: x//2 if x%2==0 else x//2+1, multiTab))
print("YES" if sum(avail) >= N else "NO")