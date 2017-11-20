inputStr = raw_input().split()
A = int(inputStr[0])
B = int(inputStr[1])
array = [0]*1001

index = 1
count = 1
while index <= 1000:
    for j in range(0, count):
        array[index] = count
        index = index+1
        if index > 1000 :
            break
    count = count+1
sum = 0
for number in array[A:B+1] :
    sum += number
print sum
