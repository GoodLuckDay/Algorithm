from string import ascii_lowercase
diction = {}
for char in list(ascii_lowercase):
    diction[char] = -1

string = input()

for index, char in enumerate(string):
    if diction[char] == -1:
        diction[char] = index

for key in sorted(diction.keys()):
    print(diction[key], end=" ")
