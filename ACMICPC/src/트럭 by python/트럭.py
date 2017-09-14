bridge = []
trucks = []
bridge_sum = 0
time = 0
inputStr = input().split(" ")

N = int(inputStr[0])
W = int(inputStr[1])
L = int(inputStr[2])

inputStr = input().split()
for i in inputStr:
    trucks.append(int(i))

while(len(trucks) != 0):
    if bridge_sum + trucks[0] > L:
        time = time + 1
        if len(bridge) == W:
            bridge_sum = bridge_sum - bridge.pop(0)
        if bridge_sum + trucks[0] <= L:
            truck = trucks.pop(0)
            bridge_sum = bridge_sum + truck
            bridge.append(truck)
        else:
            bridge.append(0)
    else:
        if len(bridge) == W:
            bridge_sum = bridge_sum - bridge.pop(0)
        truck = trucks.pop(0)
        bridge_sum = bridge_sum + truck
        bridge.append(truck)
        time = time + 1
print(time + W)