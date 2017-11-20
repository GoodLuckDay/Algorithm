N = int(input())
index = 1

while N >= 1+index*(index-1)/2:
    index = index+1
index = index-1
a = index
b = 1
for i in range(int(1+index*(index-1)/2), N):
    a = a-1
    b = b+1
print(a, b)

