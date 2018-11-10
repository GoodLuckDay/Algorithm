import math

hashset = set()
used = []

def get_result(current, numbers):
    for i in range(len(numbers)):
        if not used[i]:
            used[i] = True
            newWord = current+numbers[i]
            hashset.add(int(newWord))
            get_result(newWord, numbers)
            used[i] = False


def is_decimal(x):
    if x <= 1:
        return False
    for i in range(2, int(math.sqrt(x))+1):
        if x%i == 0:
            return False
    return True

def solution(numbers):
    global used
    answer = 0
    used = [False for i in range(len(numbers))]

    for i in range(len(numbers)):
        used[i] = True
        hashset.add(int(numbers[i]))
        get_result(numbers[i], numbers)
        used[i] = False

    values = list(filter(lambda x: is_decimal(x) == True,[value for value in hashset]))
    print(values)
    answer = len(values)
    return answer



# print(solution("17"))
print(solution("011"))