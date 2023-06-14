import sys

N = int(sys.stdin.readline())
testcase = []

count = [1]*12
count[2] = 2
count[3] = 4

for i in range(4,12):
    tmp = 0
    for j in range(1,4):
        left = i-j
        tmp+= count[left]
    count[i] = tmp

for i in range(N):
    case = int(sys.stdin.readline())
    print(count[case])


