def fibonacci(number):
    global array
    if array[number] != 0:
        return array[number]
    if number == 0 or number == 1:
        return array[number]
    array[number] = (fibonacci(number-2) + fibonacci(number-1))%1000000
    return array[number]
inputNum = input()
array = [0]*1000001
array[0] = 0
array[1] = 1
print fibonacci(inputNum)
