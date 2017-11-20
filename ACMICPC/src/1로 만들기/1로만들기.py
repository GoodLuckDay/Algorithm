N = input()
numbers = [N]*(N+1)
numbers[N]=0
for i in range(N,0,-1):
    if i%3 == 0:
        numbers[i / 3] = min(numbers[i / 3], numbers[i] + 1)
    if i%2 == 0:
        numbers[i/2] = min(numbers[i/2],numbers[i]+1)
    numbers[i - 1] = min(numbers[i - 1], numbers[i] + 1)
print numbers[1]