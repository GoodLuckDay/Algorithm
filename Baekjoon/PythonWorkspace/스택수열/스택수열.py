import sys
read = lambda : sys.stdin.readline().rstrip()
readi = lambda : int(sys.stdin.readline())
writeln = lambda x : sys.stdout.write(str(x)+"\n")
write = lambda x : sys.stdout.write(x)
stack = []
target = []
solution = []
N = readi()

for i in range(N):
    target.append(readi())
i = 1
pointer = 0
while pointer < N and i <= N:
    if len(stack) == 0:
        stack.append(i)
        solution.append('+')
        i = i+1
    elif stack[-1] != target[pointer]:
        stack.append(i)
        solution.append('+')
        i = i + 1
    elif stack[-1] == target[pointer]:
        stack.pop()
        solution.append('-')
        pointer = pointer + 1
for i in range(pointer, N):
    if stack[-1] == target[i]:
        solution.append('-')
        stack.pop()

if len(stack) !=0 :
    writeln("NO")
else:
    for char in solution:
        writeln(char)

