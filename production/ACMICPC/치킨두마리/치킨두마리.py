inputStr = raw_input().split()
account1 = int(inputStr[0])
account2 = int(inputStr[1])
price = input()
if account1+account2 >= 2*price:
    print account1+account2-2*price
else:
    print account1+account2