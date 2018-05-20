current = 0
max_people = 0
for i in range(4):
    train_out, train_in = list(map(int, input().split(" ")))
    current = current + train_in - train_out
    max_people = max(max_people, current)

print(max_people)

