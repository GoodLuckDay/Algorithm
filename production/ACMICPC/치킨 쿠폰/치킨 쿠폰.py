while(True):
    inputStr = raw_input().split()
    n = int(inputStr[0])
    k = int(inputStr[1])
    chiken = n
    coupon = n
    while coupon >= k:
        chiken = chiken+1
        coupon = coupon-k
        coupon = coupon+1
    print chiken