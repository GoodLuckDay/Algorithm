A = raw_input().split()
B = raw_input().split()
result = 0
for i in range(len(A)):
    if int(A[i]) > int(B[i]):
        result+=1
    elif int(A[i]) < int(B[i]):
        result -=1
if result>0:
    print 'A'
elif result <0:
    print 'B'
else :
    print 'D'