T = int(input())
for i in range(T):
    R, S = input().split()
    for tempS in S:
        for j in range(int(R)):
            print(tempS, end="")
    print()