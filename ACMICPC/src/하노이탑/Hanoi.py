def Hanoi(N,X,Y,Z):
    if N==1:
        print X, Z
    else:
        Hanoi(N-1,X,Z,Y)
        print X, Z
        Hanoi(N-1,Y,X,Z)
N = input()
count = (2**N)-1
print count
if N<=20:
    Hanoi(N,1,2,3)
