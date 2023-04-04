import sys
data = [int(sys.stdin.readline().strip()) for i in range(0,9)]

data = sorted(data)

over = sum(data)-100

break_out_flag = False
for i in range(0,8):
    for j in range(i+1,9):
        if data[i]+data[j] == over:
            data.pop(j)
            data.pop(i)
            break_out_flag = True
            break
    if break_out_flag == True:
        break

for i in data:
    print(i)
