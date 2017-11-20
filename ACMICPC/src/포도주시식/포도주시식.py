n = int(input())
array = [0]*10001
solution = [0] * 10001

for i in range(1,n+1):
    array[i] = int(input())
solution[1] = array[1]
solution[2] = array[2] + array[1]
solution[3] = max(max(array[1]+array[2],array[1]+array[3]), array[2] + array[3])
for i in range(4,n+1):
    solution[i] = max(solution[i-1],max(array[i]+solution[i-2],array[i]+array[i-1]+solution[i-3]))
print(max(solution))