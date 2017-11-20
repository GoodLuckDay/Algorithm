N = int(input())
list = list(map(int, input().split()))

milk_index = 0
milk_count = 0
for milk in list:
    if milk_index == milk:
        milk_index = (milk_index+1)%3
        milk_count = milk_count+1
print(milk_count)