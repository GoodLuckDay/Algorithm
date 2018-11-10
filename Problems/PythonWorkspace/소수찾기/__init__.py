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
print(solution("011"))기

'''
python permutations를 이용한 빠른 정답 구하 
'''

# from itertools import permutations
#
# def solution(numbers):
#     answer = 0
#     candidates, num_set = [], set()
#     digits = [digit for digit in numbers]
#
#     for i in range(1, len(numbers)+1):
#         candidates += [*list(permutations(digits, i))]
#
#     for candidate in candidates:
#         num_set.add(int(''.join(map(str, candidate))))
#
#     for num in num_set:
#         if is_prime(num):
#             answer += 1
#
#     return answer
#
# def is_prime(number):
#     if number == 0 or number == 1:
#         return False
#
#     for i in range(2, number//2 + 1):
#         if (number/i) == (number//i):
#             return False
#
#     return True